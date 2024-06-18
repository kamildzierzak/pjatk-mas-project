package mas.ManagementSystem.domain.entities.people;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.AddressEntity;
import mas.ManagementSystem.domain.entities.OrderActionEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@NoArgsConstructor
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
    @JoinColumn(name = "fk_addressEntity")
    private AddressEntity addressEntity;

    private String phone;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_supplierEntity")
    @Nullable
    private SupplierEntity supplierEntity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_customerEntity")
    @Nullable
    private CustomerEntity customerEntity;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_employeeEntity")
    @Nullable
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "personEntity")
    private List<OrderActionEntity> actionsPerformedOn = new ArrayList<>();

}
