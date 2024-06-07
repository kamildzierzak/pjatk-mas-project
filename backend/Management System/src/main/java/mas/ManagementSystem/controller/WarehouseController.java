package mas.ManagementSystem.controller;

import mas.ManagementSystem.model.warehouse.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @Autowired
    private Warehouse warehouse;

    @GetMapping("/warehouse")
    public Warehouse getWarehouse() {
        return warehouse;
    }
}
