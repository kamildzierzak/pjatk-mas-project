package mas.ManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.RackDto;
import mas.ManagementSystem.domain.entities.storage.RackEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.RackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/racks")
public class RackController {

  private final RackService rackService;
  private Mapper<RackEntity, RackDto> rackMapper;

  @GetMapping
  public List<RackDto> getRack() {
    List<RackEntity> racks = rackService.getRacks();
    return racks.stream().map(rackMapper::mapTo).collect(Collectors.toList());
  }
}
