package mas.ManagementSystem.mappers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.OrderDto;
import mas.ManagementSystem.domain.entities.OrderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderMapper implements Mapper<OrderEntity, OrderDto> {

  private final ModelMapper modelMapper;
  private final BatchMapper batchMapper;

  public OrderMapper() {
    this.modelMapper = new ModelMapper();
    configureModelMapper();
    this.batchMapper = new BatchMapper();
  }

  private void configureModelMapper() {
    modelMapper.typeMap(OrderEntity.class, OrderDto.class)
        .addMapping(src -> src.getType(), OrderDto::setOrderType)
        .addMapping(src -> src.getStatus(), OrderDto::setOrderStatusType)
        .addMapping(src -> src.getContent() != null ? src.getContent().stream()
            .map(batch -> batchMapper.mapTo(batch)).collect(
                Collectors.toList()) : new ArrayList<>(), OrderDto::setContent);
  }

  @Override
  public OrderDto mapTo(OrderEntity orderEntity) {
    return modelMapper.map(orderEntity, OrderDto.class);
  }

  @Override
  public OrderEntity mapFrom(OrderDto orderDto) {
    return modelMapper.map(orderDto, OrderEntity.class);
  }
}
