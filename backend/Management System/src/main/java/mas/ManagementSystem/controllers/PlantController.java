package mas.ManagementSystem.controllers;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.dto.PlantDto;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.mappers.PlantMapper;
import mas.ManagementSystem.services.PlantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;
    private PlantMapper plantMapper;

    @PostMapping
    public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) {
        PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
        PlantEntity savedPlantEntity = plantService.createPlant(plantEntity);
        return new ResponseEntity<>(plantMapper.mapTo(savedPlantEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<PlantDto> getPlants(Pageable pageable) {
        Page<PlantEntity> plants = plantService.getPageOfPlants(pageable);
        return plants.map(plantMapper::mapTo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDto> getPlantById(@PathVariable("id") Long id) {
        Optional<PlantEntity> foundPlant = plantService.getPlantById(id);
        return foundPlant.map(plantEntity -> {
            PlantDto plantDto = plantMapper.mapTo(plantEntity);
            return new ResponseEntity<>(plantDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlantDto> updatePlant(@PathVariable("id") Long id, @RequestBody PlantDto plantDto) {
        if (!plantService.isPresent(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        plantDto.setId(id);
        PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
        PlantEntity updatedPlantEntity = plantService.updatePlant(plantEntity);
        return new ResponseEntity<>(plantMapper.mapTo(updatedPlantEntity), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<PlantDto> partialUpdatePlant(@PathVariable("id") Long id, @RequestBody PlantDto plantDto) {
        if (!plantService.isPresent(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PlantEntity plantEntity = plantMapper.mapFrom(plantDto);
        PlantEntity partiallyUpdatedPlantEntity = plantService.partialUpdatePlant(id, plantEntity);
        return new ResponseEntity<>(plantMapper.mapTo(partiallyUpdatedPlantEntity), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePlant(@PathVariable("id") Long id) {
        plantService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
