package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.warehouse.ShelfEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends CrudRepository<ShelfEntity, Long> {
}
