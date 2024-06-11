package mas.ManagementSystem.mappers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.PlantDto;
import mas.ManagementSystem.domain.entities.PlantEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlantMapper implements Mapper<PlantEntity, PlantDto> {

    private ModelMapper modelMapper;

    @Override
    public PlantDto mapTo(PlantEntity plantEntity) {
        return modelMapper.map(plantEntity, PlantDto.class);
    }

    @Override
    public PlantEntity mapFrom(PlantDto plantDto) {
        return modelMapper.map(plantDto, PlantEntity.class);
    }
}
