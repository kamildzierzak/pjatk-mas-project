package mas.ManagementSystem.mappers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.RackDto;
import mas.ManagementSystem.domain.entities.storage.RackEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RackMapper implements Mapper<RackEntity, RackDto> {

  private final ModelMapper modelMapper;
  private final ShelfMapper shelfMapper;

  public RackMapper() {
    this.modelMapper = new ModelMapper();
    configureModelMapper();
    this.shelfMapper = new ShelfMapper();
  }

  private void configureModelMapper() {
    modelMapper.typeMap(RackEntity.class, RackDto.class)
        .addMapping(src -> src.getRowEntity().getId(), RackDto::setRowId)
        .addMapping(src -> src.getShelves() != null ? src.getShelves().stream().map(
            shelf -> shelfMapper.mapTo(shelf)
        ).collect(Collectors.toList()) : new ArrayList<>(), RackDto::setShelves);
  }

  @Override
  public RackDto mapTo(RackEntity rackEntity) {
    return modelMapper.map(rackEntity, RackDto.class);
  }

  @Override
  public RackEntity mapFrom(RackDto rackDto) {
    return modelMapper.map(rackDto, RackEntity.class);
  }
}
