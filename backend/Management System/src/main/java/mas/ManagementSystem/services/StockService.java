package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.StockEntity;
import mas.ManagementSystem.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<StockEntity> getAllStocks() {
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
