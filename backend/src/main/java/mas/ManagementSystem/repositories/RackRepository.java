package mas.ManagementSystem.repositories;

import mas.ManagementSystem.domain.entities.storage.RackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<RackEntity, Long> {

}
