package mas.ManagementSystem.controllers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.BatchDto;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.BatchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/batches")
public class BatchController {

    private BatchService batchService;

    private Mapper<BatchEntity, BatchDto> batchMapper;

//    TODO getBatches
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
