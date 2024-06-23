package mas.ManagementSystem.mappers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.PlantDto;
import mas.ManagementSystem.domain.entities.PlantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlantMapper implements Mapper<PlantEntity, PlantDto> {

  private ModelMapper modelMapper;
  private BatchMapper batchMapper;

  public PlantMapper() {
    this.modelMapper = new ModelMapper();
    this.batchMapper = new BatchMapper();
    configureModelMapper();
  }

  private void configureModelMapper() {
    modelMapper.typeMap(PlantEntity.class, PlantDto.class)
        .addMapping(src -> src.getBatches() != null ? src.getBatches().stream()
            .map(batch -> batchMapper.mapTo(batch))
            .collect(Collectors.toList()) : new ArrayList<>(), PlantDto::setBatches);
  }

  @Override
  public PlantDto mapTo(PlantEntity plantEntity) {
    return modelMapper.map(plantEntity, PlantDto.class);
  }

  @Override
  public PlantEntity mapFrom(PlantDto plantDto) {
    return modelMapper.map(plantDto, PlantEntity.class);
  }
}
