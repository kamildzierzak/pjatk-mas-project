package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.warehouse.WarehouseEntity;
import mas.ManagementSystem.repositories.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public List<WarehouseEntity> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<WarehouseEntity> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

}
