package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.people.EmployeeEntity;
import mas.ManagementSystem.domain.types.ReportType;

import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private ReportType type;

    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_employeeEntity", nullable = false)
    private EmployeeEntity creator;

}
