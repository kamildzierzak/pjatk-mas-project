package mas.ManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.ShelfDto;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import mas.ManagementSystem.mappers.Mapper;
import mas.ManagementSystem.services.ShelfService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/shelves")
public class ShelfController {

  private final ShelfService shelfService;
  private Mapper<ShelfEntity, ShelfDto> shelfMapper;

  @GetMapping
  public List<ShelfDto> getShelves() {
    List<ShelfEntity> shelfEntities = shelfService.getShelves();
    return shelfEntities.stream().map(shelfMapper::mapTo).collect(Collectors.toList());
  }

}
