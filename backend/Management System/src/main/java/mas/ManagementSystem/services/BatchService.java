package mas.ManagementSystem.services;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.repositories.BatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatchService {

  private final BatchRepository batchRepository;

  public List<BatchEntity> getBatches() {
    return batchRepository.findAll();
  }

  @Transactional
  public Page<BatchEntity> getBatchPage(Pageable pageable) {
    return batchRepository.findAllBatchesWithoutShelf(pageable);
  }

  public Optional<BatchEntity> getBatch(Long id) {
    return batchRepository.findById(id);
  }

  @Transactional
  public BatchEntity createBatch(PlantEntity plantEntity, Double pricePerItem, Integer quantity) {
    BatchEntity batchEntity = new BatchEntity(null, plantEntity, pricePerItem, quantity, null,
        null);
    return batchRepository.save(batchEntity);
  }

  @Transactional
  public List<BatchEntity> createBatches(List<BatchEntity> batches) {
    return batchRepository.saveAll(batches);
  }

  public BatchEntity updateBatch(BatchEntity batchEntity) {
    return batchRepository.save(batchEntity);
  }

  public void deleteBatch(BatchEntity batchEntity) {
    batchRepository.delete(batchEntity);
  }

  public long getNumberOfBatches() {
    return batchRepository.count();
  }
}
