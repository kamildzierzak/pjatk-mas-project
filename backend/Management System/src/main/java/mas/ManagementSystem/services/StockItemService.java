package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.StockItemEntity;
import mas.ManagementSystem.repositories.StockItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    public List<StockItemEntity> getStocks() {
        return stockItemRepository.findAll();
    }

    public Optional<StockItemEntity> getStock(Long id) {
        return stockItemRepository.findById(id);
    }

    public StockItemEntity createStock(StockItemEntity stockItemEntity) {
        return stockItemRepository.save(stockItemEntity);
    }

    public StockItemEntity updateStock(StockItemEntity stockItemEntity) {
        return stockItemRepository.save(stockItemEntity);
    }

    public void deleteStock(StockItemEntity stockItemEntity) {
        stockItemRepository.delete(stockItemEntity);
    }
}
