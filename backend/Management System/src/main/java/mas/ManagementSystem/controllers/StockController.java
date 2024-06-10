package mas.ManagementSystem.controllers;

import mas.ManagementSystem.domain.dto.StockDto;
import mas.ManagementSystem.domain.entities.StockEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private StockService stockService;

    private Mapper<StockEntity, StockDto> stockMapper;

    public StockController(StockService stockService, Mapper<StockEntity, StockDto> stockMapper) {
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @PostMapping(path = "/api/stocks")
    public StockDto createStock(@RequestBody StockDto stock) {
        StockEntity stockEntity = stockMapper.mapFrom(stock);
        StockEntity savedStockEntity = stockService.createStock(stockEntity);
        return stockMapper.mapTo(savedStockEntity);
    }
}
