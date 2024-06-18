package mas.ManagementSystem.domain.entities.storage;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.OrderEntity;
import mas.ManagementSystem.domain.entities.PlantEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
@Getter
@Setter
public class BatchEntity {
    public static final Integer MAX_BATCH_WIDTH = 120;
    public static final Integer MAX_BATCH_HEIGHT = 80;
    public static final Integer MAX_BATCH_DEPTH = 80;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private PlantEntity plantEntity;

    private Double pricePerItem;

    private Integer quantity;

    @OneToOne(mappedBy = "batchEntity")
    private ShelfEntity shelfEntity;

    @ManyToOne
    @JoinColumn(name = "fk_orderEntity", nullable = true)
    private OrderEntity orderEntity;

    @Transient
    public Double getTotalPrice() {
        return quantity * pricePerItem;
    }

    @Transient
    public Double getTotalWeight() {
        return quantity * plantEntity.getMaxPlantWeight();
    }

    public void setQuantity(Integer quantity) {
        if (quantity > plantEntity.getMaximumQuantityInBatch()) {
            throw new IllegalArgumentException("You cannot add more plants to this batch!");
        }
        this.quantity = quantity;
    }

    //    TODO getLocation()
}
