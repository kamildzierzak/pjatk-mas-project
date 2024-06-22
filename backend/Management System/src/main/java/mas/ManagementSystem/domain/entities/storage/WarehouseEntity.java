package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @OneToMany(mappedBy = "warehouseEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  @Size(max = 10, message = "Maximum number of rows per warehouse is 10.")
  private List<RowEntity> rows = new ArrayList<>();

//    TODO COUNT AVAILABLE SPACE AT THIS WAREHOUSE
//
}
