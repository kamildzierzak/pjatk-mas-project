package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.StockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<StockEntity, Long> {
}
