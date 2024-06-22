package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long> {

  @Query("SELECT batch FROM BatchEntity batch "
      + "WHERE batch.shelfEntity IS NOT NULL")
  Page<BatchEntity> findAllBatchesWithoutShelf(Pageable pageable);
}
