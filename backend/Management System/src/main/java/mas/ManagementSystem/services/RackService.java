package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.RackEntity;
import mas.ManagementSystem.repositories.RackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RackService {

    private final RackRepository rackRepository;

    public List<RackEntity> getRacks() {
        return rackRepository.findAll();
    }

    public Optional<RackEntity> getRack(Long id) {
        return rackRepository.findById(id);
    }

    public RackEntity createRack(RackEntity rackEntity) {
        return rackRepository.save(rackEntity);
    }

    public void deleteRack(Long id) {
        rackRepository.deleteById(id);
    }
}
