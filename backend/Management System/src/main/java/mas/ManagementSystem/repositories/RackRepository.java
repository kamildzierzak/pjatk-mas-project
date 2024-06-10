package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.warehouse.RackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends CrudRepository<RackEntity, Long> {
}
