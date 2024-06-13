package mas.ManagementSystem.mappers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.StockDto;
import mas.ManagementSystem.domain.entities.storage.StockEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockMapper implements Mapper<StockEntity, StockDto> {

    private final ModelMapper modelMapper;
    
    @Override
    public StockDto mapTo(StockEntity stockEntity) {
        return modelMapper.map(stockEntity, StockDto.class);
    }

    @Override
    public StockEntity mapFrom(StockDto stockDto) {
        return modelMapper.map(stockDto, StockEntity.class);
    }
}
