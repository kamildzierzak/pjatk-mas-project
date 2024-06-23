package mas.ManagementSystem.controllers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.BatchDto;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.mappers.BatchMapper;
import mas.ManagementSystem.services.BatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/batches")
public class BatchController {

  private final BatchService batchService;
  private BatchMapper batchMapper;

//    @GetMapping
//    public List<BatchDto> getBatches() {
//        List<BatchEntity> batchEntities = batchService.getBatches();
//        return batchEntities.stream().map(batchMapper::mapTo).collect(Collectors.toList());
//    }

  @GetMapping
  public Page<BatchDto> getBatchPage(Pageable pageable) {
    Page<BatchEntity> batches = batchService.getBatchPage(pageable);
    return batches.map(batchMapper::mapTo);
  }

//    TODO getBatchById

//  TODO createBatch
//  @PostMapping
//  public BatchDto createBatch(@RequestBody BatchDto batch) {
//    BatchEntity batchEntity = batchMapper.mapFrom(batch);
//    BatchEntity savedBatchEntity = batchService.createBatch(batchEntity);
//    return batchMapper.mapTo(savedBatchEntity);
//  }

//    TODO updateBatch
//    TODO deleteBatch
}
