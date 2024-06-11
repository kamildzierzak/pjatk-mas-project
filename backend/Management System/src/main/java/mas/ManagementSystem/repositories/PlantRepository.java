package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.PlantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<PlantEntity, Long> {
}
