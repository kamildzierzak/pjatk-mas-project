package mas.ManagementSystem.repository;

import mas.ManagementSystem.domain.entities.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
