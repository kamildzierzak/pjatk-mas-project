package mas.ManagementSystem.service;

import mas.ManagementSystem.domain.entities.warehouse.Rack;
import mas.ManagementSystem.repository.RackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RackService {

    private final RackRepository rackRepository;

    public RackService(final RackRepository rackRepository) {
        this.rackRepository = rackRepository;
    }

    public Iterable<Rack> getAllRacks() {
        return rackRepository.findAll();
    }

    public Optional<Rack> getRackById(Long id) {
        return rackRepository.findById(id);
    }

//    TODO public Rack saveRack(Rack rack) {}
//    TODO public void deleteRack(Long id) {}
}
