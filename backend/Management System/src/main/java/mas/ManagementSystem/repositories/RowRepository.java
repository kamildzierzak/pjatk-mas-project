package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.warehouse.RowEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends CrudRepository<RowEntity, Long> {
}
