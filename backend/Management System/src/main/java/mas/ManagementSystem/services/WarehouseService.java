package mas.ManagementSystem.services;

import mas.ManagementSystem.domain.entities.warehouse.WarehouseEntity;
import mas.ManagementSystem.repositories.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    //    using the constructor injection to reduce the risk of NullPointerException
    public WarehouseService(final WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public Iterable<WarehouseEntity> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<WarehouseEntity> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

}
