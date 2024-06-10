package mas.ManagementSystem.controller;

import mas.ManagementSystem.domain.entities.warehouse.Warehouse;
import mas.ManagementSystem.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(final WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
}
