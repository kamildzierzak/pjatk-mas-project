package mas.ManagementSystem.repository;

import mas.ManagementSystem.domain.entities.warehouse.Rack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends CrudRepository<Rack, Long> {
}
