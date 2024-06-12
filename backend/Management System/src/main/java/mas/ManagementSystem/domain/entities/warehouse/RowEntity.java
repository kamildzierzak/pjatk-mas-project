package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;

@Entity
@Table(name = "row")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "row_id")
    private Long id;

    @Pattern(regexp = "[A-J]", message = "Row name must be a letter from A to J")
    private String name;

    @ManyToOne
    private WarehouseEntity warehouseEntity;

    //    composition (delete all parts when whole is deleted)
    @OneToMany(mappedBy = "rowEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 30, message = "Maximum number of racks per row is 30.")
    private ArrayList<RackEntity> rackEntities;


//    private RowEntity(WarehouseEntity warehouseEntity, String name) {
//        this.warehouseEntity = warehouseEntity;
//        this.name = name;
//    }

//    public void addRack(RackEntity rackEntity) throws Exception {
//        if (!rackEntities.contains(rackEntity)) {
//            rackEntities.add(rackEntity);
//        }
//    }

//    public static RowEntity createRow(WarehouseEntity warehouseEntity, String name) throws Exception {
//        if (warehouseEntity == null) {
//            throw new Exception("Cannot create row without warehouse");
//        }
//
//        RowEntity rowEntity = new RowEntity(warehouseEntity, name);
//
//        warehouseEntity.addRow(rowEntity);
//
//        return rowEntity;
//    }


}
