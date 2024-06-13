package mas.ManagementSystem.controllers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.StockDto;
import mas.ManagementSystem.domain.entities.storage.StockEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private StockService stockService;

    private Mapper<StockEntity, StockDto> stockMapper;

//    TODO getStocks
//    TODO getStockById

    @PostMapping
    public StockDto createStock(@RequestBody StockDto stock) {
        StockEntity stockEntity = stockMapper.mapFrom(stock);
        StockEntity savedStockEntity = stockService.createStock(stockEntity);
        return stockMapper.mapTo(savedStockEntity);
    }

//    TODO updateStock
//    TODO deleteStock
}
