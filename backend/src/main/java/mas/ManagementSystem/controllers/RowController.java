package mas.ManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.RowDto;
import mas.ManagementSystem.domain.entities.storage.RowEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.RowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rows")
public class RowController {

  private final RowService rowService;
  private Mapper<RowEntity, RowDto> rowMapper;

//  @GetMapping
//  public List<RowDto> getRows() {
//    List<RowEntity> rows = rowService.getRows();
//    return rows.stream().map(rowMapper::mapTo).collect(Collectors.toList());
//  }

  @GetMapping
  public List<RowDto> getRows() {
    List<RowEntity> rows = rowService.getRowsWithEmptyShelves();
    return rows.stream().map(rowMapper::mapTo).collect(Collectors.toList());
  }
}
