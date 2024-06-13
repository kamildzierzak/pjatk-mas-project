package mas.ManagementSystem.domain.entities.people;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.ReportEntity;
import mas.ManagementSystem.domain.types.EmployeeRole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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

    private LocalDate endDate;

    private Double salary;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private EnumSet<EmployeeRole> roles = EnumSet.of(EmployeeRole.EMPLOYEE);

    @OneToMany(mappedBy = "creator")
    private List<ReportEntity> reports = new ArrayList<>();
}
