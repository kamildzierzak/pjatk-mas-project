package mas.ManagementSystem.mappers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.ShelfDto;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShelfMapper implements Mapper<ShelfEntity, ShelfDto> {

  private final ModelMapper modelMapper;

  public ShelfMapper() {
    this.modelMapper = new ModelMapper();
    configureModelMapper();
  }

  private void configureModelMapper() {
    modelMapper.typeMap(ShelfEntity.class, ShelfDto.class)
        .addMapping(src -> src.getRackEntity().getId(), ShelfDto::setRackId)
        .addMapping(src -> src.getBatchEntity().getId(), ShelfDto::setBatchId);
  }


  @Override
  public ShelfDto mapTo(ShelfEntity shelfEntity) {
    return modelMapper.map(shelfEntity, ShelfDto.class);
  }

  @Override
  public ShelfEntity mapFrom(ShelfDto shelfDto) {
    return modelMapper.map(shelfDto, ShelfEntity.class);
  }
}
