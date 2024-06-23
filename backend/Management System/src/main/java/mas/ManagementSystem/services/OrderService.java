package mas.ManagementSystem.services;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.OrderActionEntity;
import mas.ManagementSystem.domain.entities.OrderEntity;
import mas.ManagementSystem.domain.entities.people.SupplierEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import mas.ManagementSystem.domain.types.OrderStatusType;
import mas.ManagementSystem.domain.types.OrderType;
import mas.ManagementSystem.repositories.BatchRepository;
import mas.ManagementSystem.repositories.OrderRepository;
import mas.ManagementSystem.repositories.ShelfRepository;
import mas.ManagementSystem.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final BatchRepository batchRepository;
  private final ShelfRepository shelfRepository;
  private final SupplierRepository supplierRepository;

  public List<OrderEntity> getOrders() {
    return orderRepository.findAll();
  }

//  public Page<OrderEntity> getOrderPage(Pageable pageable) {
//    return orderRepository.findAll(pageable);
//  }

  @Transactional
  public OrderEntity createPurchaseOrder(LocalDateTime creationDate, Double price,
      Long supplierId) {
    SupplierEntity supplierEntity = supplierRepository.findById(supplierId)
        .orElseThrow(() -> new RuntimeException("Supplier not found"));
    List<OrderActionEntity> actions = new ArrayList<>();
    List<BatchEntity> batches = new ArrayList<>();

    OrderEntity orderEntity = new OrderEntity(null, creationDate, null, price, OrderType.PURCHASE,
        OrderStatusType.PENDING, null, supplierEntity, actions, batches);

    return orderRepository.save(orderEntity);
  }

  //  TODO - createSaleOrder

  @Transactional
  public void addBatchToOrder(Long id, BatchEntity batchEntity) {
    OrderEntity orderEntity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Order not found"));

    orderEntity.getContent().add(batchEntity);
    batchEntity.setOrderEntity(orderEntity);

    orderRepository.save(orderEntity);
  }

  @Transactional
  public void moveBatchToOrderFromShelf(Long shelfId, Long orderId) {
    ShelfEntity shelfEntity = shelfRepository.findById(shelfId)
        .orElseThrow(() -> new RuntimeException("Shelf not found"));
    BatchEntity batchEntity = shelfEntity.getBatchEntity();
    OrderEntity orderEntity = orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found"));

    orderEntity.getContent().add(batchEntity);
    shelfEntity.setBatchEntity(null);

    orderRepository.save(orderEntity);
    shelfRepository.save(shelfEntity);
  }

  @Transactional
  public void moveBatchFromOrderToShelf(Long orderId, Long batchId, Long shelfId,
      Double pricePerItem, Integer quantity) {
    OrderEntity orderEntity = orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found"));
    BatchEntity batchEntity =
        orderEntity.getContent().stream().filter(batch -> batch.getId().equals(batchId)).findAny()
            .orElseThrow(() -> new RuntimeException("Batch with id " + batchId + " not found"));
    ShelfEntity shelfEntity = shelfRepository.findById(shelfId)
        .orElseThrow(() -> new RuntimeException("Shelf not found"));

    if (shelfEntity.getBatchEntity() != null) {
      throw new RuntimeException("Shelf is not empty!");
    }

    batchEntity.setOrderEntity(null);
    batchEntity.setPricePerItem(pricePerItem);
    batchEntity.setQuantity(quantity);
    batchEntity.setShelfEntity(shelfEntity);
    shelfEntity.setBatchEntity(batchEntity);
    orderEntity.getContent().remove(batchEntity);
    shelfRepository.save(shelfEntity);
    orderRepository.save(orderEntity);
  }

  public long getNumberOfOrder() {
    return orderRepository.count();
  }

}
