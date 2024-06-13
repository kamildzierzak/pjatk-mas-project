package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
