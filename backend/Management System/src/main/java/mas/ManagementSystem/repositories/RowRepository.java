package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.warehouse.RowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends JpaRepository<RowEntity, Long> {
}
