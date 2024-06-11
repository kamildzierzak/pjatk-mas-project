package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.warehouse.RackEntity;
import mas.ManagementSystem.repositories.RackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RackService {

    private final RackRepository rackRepository;

    public List<RackEntity> getAllRacks() {
        return rackRepository.findAll();
    }

    public Optional<RackEntity> getRackById(Long id) {
        return rackRepository.findById(id);
    }

//    TODO public Rack saveRack(Rack rack) {}
//    TODO public void deleteRack(Long id) {}
}
