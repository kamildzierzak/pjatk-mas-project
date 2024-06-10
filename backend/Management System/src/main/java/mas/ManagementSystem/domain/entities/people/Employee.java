package mas.ManagementSystem.domain.entities.people;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class Employee {
    private LocalDate startDate;
    private LocalDate endDate;
    private Double salary;
}
