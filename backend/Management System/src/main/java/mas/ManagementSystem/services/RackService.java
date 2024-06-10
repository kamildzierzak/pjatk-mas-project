package mas.ManagementSystem.services;

import mas.ManagementSystem.domain.entities.warehouse.RackEntity;
import mas.ManagementSystem.repositories.RackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RackService {

    private final RackRepository rackRepository;

    public RackService(final RackRepository rackRepository) {
        this.rackRepository = rackRepository;
    }

    public Iterable<RackEntity> getAllRacks() {
        return rackRepository.findAll();
    }

    public Optional<RackEntity> getRackById(Long id) {
        return rackRepository.findById(id);
    }

//    TODO public Rack saveRack(Rack rack) {}
//    TODO public void deleteRack(Long id) {}
}
