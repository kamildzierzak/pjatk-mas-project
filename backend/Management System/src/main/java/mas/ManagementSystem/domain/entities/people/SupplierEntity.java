package mas.ManagementSystem.domain.entities.people;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.OrderEntity;

@Entity
@Table(name = "supplier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplierEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @OneToOne(mappedBy = "supplierEntity")
  private PersonEntity personEntity;

  @OneToMany(mappedBy = "supplierEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderEntity> deliveries = new ArrayList<>();

}
