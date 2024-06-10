package mas.ManagementSystem.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.warehouse.ShelfEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
@Getter
@Setter
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer amount;
    private Double pricePerUnit;

    @ManyToOne(cascade = CascadeType.ALL)
    private ShelfEntity shelfEntity;

    @ManyToOne
    private PlantEntity plantEntity;


}
