package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfEntity, Long> {

}
