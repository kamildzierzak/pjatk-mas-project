package mas.ManagementSystem.services;

import mas.ManagementSystem.domain.entities.StockEntity;
import mas.ManagementSystem.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<StockEntity> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public StockEntity createStock(StockEntity stockEntity) {
        return stockRepository.save(stockEntity);
    }

    public void deleteStock(StockEntity stockEntity) {
        stockRepository.delete(stockEntity);
    }
}
