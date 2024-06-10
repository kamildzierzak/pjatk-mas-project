package mas.ManagementSystem.repository;

import mas.ManagementSystem.domain.entities.warehouse.Row;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends CrudRepository<Row, Long> {
}
