package mas.ManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.OrderDto;
import mas.ManagementSystem.domain.entities.OrderEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
