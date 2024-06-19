package mas.ManagementSystem.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.RackEntity;
import mas.ManagementSystem.domain.entities.storage.RowEntity;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;
import mas.ManagementSystem.domain.entities.storage.WarehouseEntity;
import mas.ManagementSystem.repositories.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class WarehouseService {


    private final WarehouseRepository warehouseRepository;
//    private final RowService rowService;
//    private final RackService rackService;
//    private final ShelfService shelfService;

    @Transactional
    public void initializeWarehouse() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setName("My Favourite Warehouse");

        List<RowEntity> rows = new ArrayList<>();
        for (int i = 0; i < WarehouseEntity.ROWS; i++) {
            RowEntity rowEntity = new RowEntity();
            rowEntity.setName(String.valueOf((char) ('A' + i)));
            rowEntity.setWarehouseEntity(warehouseEntity);

            List<RackEntity> racks = new ArrayList<>();
            for (int rackNumber = 1; rackNumber <= WarehouseEntity.RACKS_IN_ROW; rackNumber++) {
                RackEntity rackEntity = new RackEntity();
                rackEntity.setNumber(rackNumber);
                rackEntity.setRowEntity(rowEntity);

                List<ShelfEntity> shelves = new ArrayList<>();
                for (int shelfNumber = 1; shelfNumber <= WarehouseEntity.SHELVES_IN_RACK; shelfNumber++) {
                    ShelfEntity shelfEntity = new ShelfEntity();
                    shelfEntity.setNumber(shelfNumber);
                    shelfEntity.setRackEntity(rackEntity);

                    shelves.add(shelfEntity);
                }
                rackEntity.setShelves(shelves);
                racks.add(rackEntity);
            }
            rowEntity.setRacks(racks);
            rows.add(rowEntity);
        }
        warehouseEntity.setRows(rows);

        createWarehouse(warehouseEntity);
    }

    public WarehouseEntity createWarehouse(WarehouseEntity warehouseEntity) {
        return warehouseRepository.save(warehouseEntity);
    }

    public List<WarehouseEntity> getWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<WarehouseEntity> getWarehouse(Long id) {
        return warehouseRepository.findById(id);
    }

    //    TODO 4 now it's working only for 1 warehouse
    @Transactional
    public List<RowEntity> getWarehouseRows() {
        WarehouseEntity warehouseEntity = getWarehouse(1L).orElseThrow(() -> new RuntimeException("Warehouse not " +
                "found"));
        return warehouseEntity.getRows();
    }

    //    TODO 4 now it's working only for 1 warehouse
    @Transactional
    public List<RackEntity> getWarehousesRacks() {
        List<RowEntity> warehouseRows = getWarehouseRows();
        List<RackEntity> warehouseRacks = new ArrayList<>();

        warehouseRows.forEach(rowEntity -> warehouseRacks.addAll(rowEntity.getRacks()));

        return warehouseRacks;
    }

    //    TODO 4 now it's working only for 1 warehouse
    @Transactional
    public List<ShelfEntity> getWarehouseShelves() {
        List<RackEntity> warehouseRacks = getWarehousesRacks();
        List<ShelfEntity> warehouseShelves = new ArrayList<>();

        warehouseRacks.forEach(rackEntity -> warehouseShelves.addAll(rackEntity.getShelves()));

        return warehouseShelves;
    }

}
