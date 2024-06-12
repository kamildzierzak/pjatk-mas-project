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

    public WarehouseEntity createWarehouse(WarehouseEntity warehouseEntity) {
        return warehouseRepository.save(warehouseEntity);
    }

    public List<WarehouseEntity> getWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<WarehouseEntity> getWarehouse(Long id) {
        return warehouseRepository.findById(id);
    }
}
