package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.people.PersonEntity;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(mappedBy = "addressEntity")
    private PersonEntity personEntity;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

}
