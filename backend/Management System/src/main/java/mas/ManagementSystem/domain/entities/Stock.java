package mas.ManagementSystem.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.warehouse.Shelf;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer amount;
    private Double pricePerUnit;

    @ManyToOne(cascade = CascadeType.ALL)
    private Shelf shelf;

    @ManyToOne
    private Plant plant;


}
