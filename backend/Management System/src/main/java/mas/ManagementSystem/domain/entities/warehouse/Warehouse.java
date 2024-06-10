package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouse")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Warehouse {
    public static final int ROWS = 10;
    public static final int RACKS_IN_ROW = 30;
    public static final int SHELVES_IN_RACK = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Row> rows = new ArrayList<>();

    public void addRow(Row row) {
        if (!rows.contains(row)) {
            rows.add(row);
        }
    }

}
