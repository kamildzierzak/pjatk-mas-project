package mas.ManagementSystem.mappers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.RowDto;
import mas.ManagementSystem.domain.entities.storage.RowEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RowMapper implements Mapper<RowEntity, RowDto> {

  private final ModelMapper modelMapper;
  private final RackMapper rackMapper;

  public RowMapper() {
    this.modelMapper = new ModelMapper();
    configureModelMapper();
    this.rackMapper = new RackMapper();
  }

  private void configureModelMapper() {
    modelMapper.typeMap(RowEntity.class, RowDto.class)
        .addMapping(src -> src.getWarehouseEntity().getId(), RowDto::setWarehouseId)
        .addMapping(src -> src.getRacks() != null ? src.getRacks().stream().map(
            rack -> rackMapper.mapTo(rack)
        ).collect(Collectors.toList()) : new ArrayList<>(), RowDto::setRacks);
  }

  @Override
  public RowDto mapTo(RowEntity rowEntity) {
    return modelMapper.map(rowEntity, RowDto.class);
  }

  @Override
  public RowEntity mapFrom(RowDto rowDto) {
    return modelMapper.map(rowDto, RowEntity.class);
  }
}
