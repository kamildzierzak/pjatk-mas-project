package mas.ManagementSystem.mappers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.StockDto;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockMapper implements Mapper<BatchEntity, StockDto> {

    private final ModelMapper modelMapper;

    @Override
    public StockDto mapTo(BatchEntity batchEntity) {
        return modelMapper.map(batchEntity, StockDto.class);
    }

    @Override
    public BatchEntity mapFrom(StockDto stockDto) {
        return modelMapper.map(stockDto, BatchEntity.class);
    }
}
