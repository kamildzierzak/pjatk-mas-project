package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<BatchEntity> getStocks() {
        return stockRepository.findAll();
    }

    public Optional<BatchEntity> getStock(Long id) {
        return stockRepository.findById(id);
    }

    public BatchEntity createStock(BatchEntity batchEntity) {
        return stockRepository.save(batchEntity);
    }

    public BatchEntity updateStock(BatchEntity batchEntity) {
        return stockRepository.save(batchEntity);
    }

    public void deleteStock(BatchEntity batchEntity) {
        stockRepository.delete(batchEntity);
    }
}
