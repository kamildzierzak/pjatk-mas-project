package mas.ManagementSystem.services;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.repositories.PlantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlantService {

  private final PlantRepository plantRepository;

  public List<PlantEntity> getPlants() {
    return plantRepository.findAll();
  }

  public Page<PlantEntity> getPlantsPage(Pageable pageable) {
    return plantRepository.findAll(pageable);
  }

  public Optional<PlantEntity> getPlant(Long id) {
    return plantRepository.findById(id);
  }

  public PlantEntity createPlant(PlantEntity plantEntity) {
    return plantRepository.save(plantEntity);
  }

  public List<PlantEntity> createPlants(List<PlantEntity> plants) {
    return plantRepository.saveAll(plants);
  }

  public PlantEntity updatePlant(PlantEntity plantEntity) {
    return plantRepository.save(plantEntity);
  }

  public PlantEntity updatePlantPartial(Long id, PlantEntity plantEntity) {
    plantEntity.setId(id);

    return plantRepository.findById(id).map(existingPlant -> {
      Optional.ofNullable(plantEntity.getName()).ifPresent(existingPlant::setName);
      Optional.ofNullable(plantEntity.getDescription()).ifPresent(existingPlant::setDescription);
      Optional.ofNullable(plantEntity.getType()).ifPresent(existingPlant::setType);
      return plantRepository.save(existingPlant);
    }).orElseThrow(RuntimeException::new);
  }

  public void deletePlant(Long id) {
    plantRepository.deleteById(id);
  }

  public boolean isPlantPresent(Long id) {
    return plantRepository.existsById(id);
  }

  public long getNumberOfPlants() {
    return plantRepository.count();
  }

}
