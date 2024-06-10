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
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "row_id")
    private Long id;

    private String name;

    @ManyToOne
    private Warehouse warehouse;

    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Rack> racks = new ArrayList<>();


    private Row(Warehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }

    public void addRack(Rack rack) throws Exception {
        if (!racks.contains(rack)) {
            racks.add(rack);
        }
    }

    public static Row createRow(Warehouse warehouse, String name) throws Exception {
        if (warehouse == null) {
            throw new Exception("Cannot create row without warehouse");
        }

        Row row = new Row(warehouse, name);

        warehouse.addRow(row);

        return row;
    }


}
