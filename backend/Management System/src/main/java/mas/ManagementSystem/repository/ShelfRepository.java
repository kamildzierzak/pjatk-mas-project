package mas.ManagementSystem.repository;

import mas.ManagementSystem.domain.entities.warehouse.Shelf;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf, Long> {
}
