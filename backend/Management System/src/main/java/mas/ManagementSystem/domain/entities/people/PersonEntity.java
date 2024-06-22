package mas.ManagementSystem.domain.entities.people;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.AddressEntity;
import mas.ManagementSystem.domain.entities.OrderActionEntity;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private Long id;

  private String firstName;

  private String lastName;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_addressEntity", nullable = true)
  private AddressEntity addressEntity;

  private String phone;

  private String email;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_supplierEntity", nullable = true)
  private SupplierEntity supplierEntity;

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_customerEntity", nullable = true)
  private CustomerEntity customerEntity;


  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "fk_employeeEntity", nullable = true)
  private EmployeeEntity employeeEntity;

  @OneToMany(mappedBy = "personEntity")
  private List<OrderActionEntity> actionsPerformedOn;

  public boolean isCustomer() {
    return customerEntity != null;
  }

  public boolean isSupplier() {
    return supplierEntity != null;
  }

  public boolean isEmployee() {
    return employeeEntity != null;
  }

}
