package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.repositories.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;

    public PlantEntity createPlant(PlantEntity plantEntity) {
        return plantRepository.save(plantEntity);
    }

    public List<PlantEntity> getAllPlants() {
        return plantRepository.findAll();
    }

    public Optional<PlantEntity> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    public boolean isPresent(Long id) {
        return plantRepository.existsById(id);
    }


    public PlantEntity updatePlant(PlantEntity plantEntity) {
        return plantRepository.save(plantEntity);
    }

    public PlantEntity partialUpdatePlant(Long id, PlantEntity plantEntity) {
        plantEntity.setId(id);

        return plantRepository.findById(id).map(existingPlant -> {
            Optional.ofNullable(plantEntity.getName()).ifPresent(existingPlant::setName);
            Optional.ofNullable(plantEntity.getDescription()).ifPresent(existingPlant::setDescription);
            Optional.ofNullable(plantEntity.getType()).ifPresent(existingPlant::setType);
            return plantRepository.save(existingPlant);
        }).orElseThrow(RuntimeException::new);
    }

    public void delete(Long id) {
        plantRepository.deleteById(id);
    }

}
