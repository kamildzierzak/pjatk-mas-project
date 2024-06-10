package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Table(name = "row")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "row_id")
    private Long id;

    private String name;

    @ManyToOne
    private WarehouseEntity warehouseEntity;

    @OneToMany(mappedBy = "rowEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<RackEntity> rackEntities = new ArrayList<>();


    private RowEntity(WarehouseEntity warehouseEntity, String name) {
        this.warehouseEntity = warehouseEntity;
        this.name = name;
    }

    public void addRack(RackEntity rackEntity) throws Exception {
        if (!rackEntities.contains(rackEntity)) {
            rackEntities.add(rackEntity);
        }
    }

    public static RowEntity createRow(WarehouseEntity warehouseEntity, String name) throws Exception {
        if (warehouseEntity == null) {
            throw new Exception("Cannot create row without warehouse");
        }

        RowEntity rowEntity = new RowEntity(warehouseEntity, name);

        warehouseEntity.addRow(rowEntity);

        return rowEntity;
    }


}
