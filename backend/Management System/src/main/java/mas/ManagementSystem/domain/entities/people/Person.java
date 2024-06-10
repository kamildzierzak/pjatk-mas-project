package mas.ManagementSystem.domain.entities.people;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.Address;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String phone;
    private String email;

    @Embedded
    @Nullable
    private Supplier supplier;
    @Embedded
    @Nullable
    private Customer customer;
    @Embedded
    @Nullable
    private Employee employee;

    public void becomeSupplier() {
        this.supplier = new Supplier();
    }

    public void becomeCustomer() {
        this.customer = new Customer();
    }

    public void becomeEmployee() {
        this.employee = new Employee();
    }

}
