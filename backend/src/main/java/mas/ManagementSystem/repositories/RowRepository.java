package mas.ManagementSystem.repositories;

import java.util.List;
import mas.ManagementSystem.domain.entities.storage.RowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RowRepository extends JpaRepository<RowEntity, Long> {

  @Query("SELECT row FROM RowEntity row " +
      "JOIN row.racks racks " +
      "JOIN racks.shelves shelves " +
      "WHERE shelves.batchEntity IS NULL")
  List<RowEntity> findAllRowsWithEmptyShelves();
}

