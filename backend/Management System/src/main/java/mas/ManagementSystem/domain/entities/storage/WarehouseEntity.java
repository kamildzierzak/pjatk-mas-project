package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "warehouse")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseEntity {
    public static final int ROWS = 10;
    public static final int RACKS_IN_ROW = 30;
    public static final int SHELVES_IN_RACK = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    //    composition (delete all parts when whole is deleted)
    @OneToMany(mappedBy = "warehouseEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 10, message = "Maximum number of rows per warehouse is 10.")
    private List<RowEntity> rows;

//    TODO COUNT AVAILABLE SPACE AT THIS WAREHOUSE
}
