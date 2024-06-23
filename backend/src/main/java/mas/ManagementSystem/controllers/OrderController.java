package mas.ManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.OrderDto;
import mas.ManagementSystem.domain.entities.OrderEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;
  private Mapper<OrderEntity, OrderDto> orderMapper;

  @GetMapping
  public List<OrderDto> getOrders() {
    List<OrderEntity> orders = orderService.getOrders();
    return orders.stream().map(orderMapper::mapTo).collect(Collectors.toList());
  }

//  @GetMapping
//  public Page<OrderDto> getOrderPage(Pageable pageable) {
//    Page<OrderEntity> orders = orderService.getOrderPage(pageable);
//    return orders.map(orderMapper::mapTo);
//  }

  @PostMapping("/moveBatch")
  public ResponseEntity<String> moveBatchFromOrderToShelf(@RequestParam Long orderId,
      @RequestParam Long batchId, @RequestParam Long shelfId, @RequestParam Double pricePerItem,
      @RequestParam Integer quantity) {
    try {
      orderService.moveBatchFromOrderToShelf(orderId, batchId, shelfId, pricePerItem, quantity);
      String responseBody =
          "Batch " + batchId + " has been moved from order " + orderId + " to shelf " + shelfId;
      return new ResponseEntity<>(responseBody, HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

}
