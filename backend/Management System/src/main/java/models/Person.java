package models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Embedded
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
