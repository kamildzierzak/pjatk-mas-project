package mas.ManagementSystem.controllers;

import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.PlantDto;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.mappers.PlantMapper;
import mas.ManagementSystem.services.PlantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/plants")
public class PlantController {

  private final PlantService plantService;
  private PlantMapper plantMapper;

//    @GetMapping
//    public List<PlantDto> getPlants() {
//        List<PlantEntity> plantEntities = plantService.getAllPlants();
//        return plantEntities.stream().map(plantMapper::mapTo).collect(Collectors.toList());
//    }

  @GetMapping
  public Page<PlantDto> getPlantsPage(Pageable pageable) {
    Page<PlantEntity> plants = plantService.getPlantsPage(pageable);
    return plants.map(plantMapper::mapTo);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlantDto> getPlant(@PathVariable("id") Long id) {
    Optional<PlantEntity> foundPlant = plantService.getPlant(id);
    return foundPlant.map(plantEntity -> {
      PlantDto plantDto = plantMapper.mapTo(plantEntity);
      return new ResponseEntity<>(plantDto, HttpStatus.OK);
    }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) {
    PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
    PlantEntity savedPlantEntity = plantService.createPlant(plantEntity);
    return new ResponseEntity<>(plantMapper.mapTo(savedPlantEntity), HttpStatus.CREATED);
  }


  @PutMapping("/{id}")
  public ResponseEntity<PlantDto> updatePlant(@PathVariable("id") Long id,
      @RequestBody PlantDto plantDto) {
    if (!plantService.isPlantPresent(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    plantDto.setId(id);
    PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
    PlantEntity updatedPlantEntity = plantService.updatePlant(plantEntity);
    return new ResponseEntity<>(plantMapper.mapTo(updatedPlantEntity), HttpStatus.OK);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<PlantDto> updatePlantPartial(@PathVariable("id") Long id,
      @RequestBody PlantDto plantDto) {
    if (!plantService.isPlantPresent(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
    PlantEntity partiallyUpdatedPlantEntity = plantService.updatePlantPartial(id, plantEntity);
    return new ResponseEntity<>(plantMapper.mapTo(partiallyUpdatedPlantEntity), HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity deletePlant(@PathVariable("id") Long id) {
    plantService.deletePlant(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
