package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.repositories.BatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;

    public List<BatchEntity> getBatches() {
        return batchRepository.findAll();
    }

    public Optional<BatchEntity> getBatch(Long id) {
        return batchRepository.findById(id);
    }

    public BatchEntity createBatch(BatchEntity batchEntity) {
        return batchRepository.save(batchEntity);
    }

    public BatchEntity updateBatch(BatchEntity batchEntity) {
        return batchRepository.save(batchEntity);
    }

    public void deleteBatch(BatchEntity batchEntity) {
        batchRepository.delete(batchEntity);
    }
}
