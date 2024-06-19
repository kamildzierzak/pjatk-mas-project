package mas.ManagementSystem.controllers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.BatchDto;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.BatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private final BatchService batchService;
    private Mapper<BatchEntity, BatchDto> batchMapper;

    @GetMapping
    public Page<BatchDto> getBatchPage(Pageable pageable) {
        Page<BatchEntity> plants = batchService.getBatchPage(pageable);
        return plants.map(batchMapper::mapTo);
    }

//    TODO getBatchById

    @PostMapping
    public BatchDto createBatch(@RequestBody BatchDto batch) {
        BatchEntity batchEntity = batchMapper.mapFrom(batch);
        BatchEntity savedBatchEntity = batchService.createBatch(batchEntity);
        return batchMapper.mapTo(savedBatchEntity);
    }

//    TODO updateBatch
//    TODO deleteBatch
}
