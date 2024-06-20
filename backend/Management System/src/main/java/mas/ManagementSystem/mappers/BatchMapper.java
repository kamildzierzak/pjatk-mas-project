package mas.ManagementSystem.mappers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.BatchDto;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BatchMapper implements Mapper<BatchEntity, BatchDto> {

    private final ModelMapper modelMapper;

    public BatchMapper() {
        this.modelMapper = new ModelMapper();
        configureModelMapper();
    }

    private void configureModelMapper() {
        modelMapper.typeMap(BatchEntity.class, BatchDto.class)
                .addMapping(src -> src.getPlantEntity().getName(), BatchDto::setPlantName)
                .addMapping(src -> src.getDimensions(), BatchDto::setDimensions)
                .addMapping(src -> src.getTotalWeight(), BatchDto::setWeight)
                .addMapping(src -> src.getShelfEntity().getRackEntity().getRowEntity().getName(), BatchDto::setRowLocation)
                .addMapping(src -> src.getShelfEntity().getRackEntity().getNumber(), BatchDto::setRackLocation)
                .addMapping(src -> src.getShelfEntity().getNumber(), BatchDto::setShelfLocation)
                .addMapping(src -> src.getQuantity(), BatchDto::setPlantsQuantity)
                .addMapping(src -> src.getOrderEntity(), BatchDto::setOrderId);
    }

    @Override
    public BatchDto mapTo(BatchEntity batchEntity) {
        return modelMapper.map(batchEntity, BatchDto.class);
    }

    @Override
    public BatchEntity mapFrom(BatchDto batchDto) {
        return modelMapper.map(batchDto, BatchEntity.class);
    }
}
