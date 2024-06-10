package mas.ManagementSystem.mappers;

import mas.ManagementSystem.domain.dto.StockDto;
import mas.ManagementSystem.domain.entities.StockEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StockMapper implements Mapper<StockEntity, StockDto> {

    private ModelMapper modelMapper;

    public StockMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StockDto mapTo(StockEntity stockEntity) {
        return modelMapper.map(stockEntity, StockDto.class);
    }

    @Override
    public StockEntity mapFrom(StockDto stockDto) {
        return modelMapper.map(stockDto, StockEntity.class);
    }
}
