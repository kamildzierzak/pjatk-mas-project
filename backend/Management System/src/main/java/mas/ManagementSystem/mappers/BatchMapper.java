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

    @Override
    public BatchDto mapTo(BatchEntity batchEntity) {
        return modelMapper.map(batchEntity, BatchDto.class);
    }

    @Override
    public BatchEntity mapFrom(BatchDto batchDto) {
        return modelMapper.map(batchDto, BatchEntity.class);
    }
}
