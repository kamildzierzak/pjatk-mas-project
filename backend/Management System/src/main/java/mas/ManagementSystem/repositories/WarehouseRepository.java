package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.warehouse.WarehouseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<WarehouseEntity, Long> {
}
