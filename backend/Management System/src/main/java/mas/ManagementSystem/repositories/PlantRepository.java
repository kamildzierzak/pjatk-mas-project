package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.PlantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<PlantEntity, Long> {
}
