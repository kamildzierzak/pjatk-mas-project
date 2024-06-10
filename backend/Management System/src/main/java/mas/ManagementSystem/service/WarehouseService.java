package mas.ManagementSystem.service;

import mas.ManagementSystem.domain.entities.warehouse.Warehouse;
import mas.ManagementSystem.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    //    using the constructor injection to reduce the risk of NullPointerException
    public WarehouseService(final WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public Iterable<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }

}
