package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.StockItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemRepository extends JpaRepository<StockItemEntity, Long> {
}
