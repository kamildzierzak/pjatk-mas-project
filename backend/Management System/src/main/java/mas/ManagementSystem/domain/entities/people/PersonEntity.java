package mas.ManagementSystem.domain.entities.people;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.AddressEntity;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private AddressEntity addressEntity;

    private String phone;

    private String email;

    @Embedded
    @Nullable
    private SupplierEntity supplierEntity;

    @Embedded
    @Nullable
    private CustomerEntity customerEntity;

    @Embedded
    @Nullable
    private EmployeeEntity employeeEntity;

    public void becomeSupplier() {
        this.supplierEntity = new SupplierEntity();
    }

    public void becomeCustomer() {
        this.customerEntity = new CustomerEntity();
    }

    public void becomeEmployee() {
        this.employeeEntity = new EmployeeEntity();
    }

}
