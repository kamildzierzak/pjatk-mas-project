package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long> {
}