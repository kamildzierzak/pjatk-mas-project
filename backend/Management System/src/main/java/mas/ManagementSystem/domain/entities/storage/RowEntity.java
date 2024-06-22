package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "row")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RowEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Pattern(regexp = "[A-J]", message = "Row name must be a letter from A to J")
  private String name;

  @ManyToOne
  @JoinColumn(name = "fk_warehouseEntity", nullable = false)
  private WarehouseEntity warehouseEntity;

  @OneToMany(mappedBy = "rowEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  @Size(max = 30, message = "Maximum number of racks per row is 30.")
  private List<RackEntity> racks = new ArrayList<>();

  //    TODO getLocation()
  //    TODO COUNT AVAILABLE SPACE AT THIS ROW
}
