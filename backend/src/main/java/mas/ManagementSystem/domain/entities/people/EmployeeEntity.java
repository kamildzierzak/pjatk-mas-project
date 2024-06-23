package mas.ManagementSystem.domain.entities.people;

import jakarta.annotation.Nullable;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.ReportEntity;
import mas.ManagementSystem.domain.types.EmployeeRole;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @OneToOne(mappedBy = "employeeEntity")
  private PersonEntity personEntity;

  private LocalDate startDate;

  @Nullable
  private LocalDate endDate;

  private Double salary;

  @ElementCollection
  @CollectionTable(name = "employeeRoles", joinColumns = @JoinColumn(name = "fk_employeeEntity"))
  @Enumerated(EnumType.STRING)
  private Set<EmployeeRole> roles = EnumSet.of(EmployeeRole.EMPLOYEE);

  @OneToMany(mappedBy = "creator")
  private List<ReportEntity> reports = new ArrayList<>();

  public EmployeeEntity(Long id, PersonEntity personEntity, LocalDate startDate, LocalDate endDate,
      Double salary) {
    this.id = id;
    this.personEntity = personEntity;
    this.startDate = startDate;
    this.endDate = endDate;
    this.salary = salary;
  }

  public void addRole(EmployeeRole employeeRole) {
    roles.add(employeeRole);
  }

  public void removeRole(EmployeeRole employeeRole) {
    roles.remove(employeeRole);
  }

}
