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
@Table(name = "batch")
@Getter
@Setter
public class BatchEntity {
    public static final Integer MAX_BATCH_WIDTH = 120;
    public static final Integer MAX_BATCH_HEIGHT = 80;
    public static final Integer MAX_BATCH_DEPTH = 80;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_plantEntity", nullable = false)
    private PlantEntity plantEntity;

    private Double pricePerItem;

    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "fk_shelfEntity", nullable = true)
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
        return Double.valueOf(Math.round(quantity * plantEntity.getMaxPlantWeight()));
    }

    public void setQuantity(Integer quantity) {
        if (quantity > plantEntity.getMaximumQuantityInBatch()) {
            throw new IllegalArgumentException("You cannot add more plants to this batch!");
        }
        this.quantity = quantity;
    }

    //    TODO - create method to count real dimensions
    public String getDimensions() {
        return MAX_BATCH_WIDTH + "x" + BatchEntity.MAX_BATCH_HEIGHT + "x" + BatchEntity.MAX_BATCH_DEPTH;
    }
}
