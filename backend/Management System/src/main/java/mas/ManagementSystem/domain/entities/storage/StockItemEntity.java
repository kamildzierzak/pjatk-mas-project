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
@Table(name = "stock_item")
@Getter
@Setter
public class StockItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double width;

    private Double height;

    private Double depth;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "fk_stockEntity", nullable = false)
    private StockEntity stockEntity;

    @ManyToOne
    @JoinColumn(name = "fk_plantEntity", nullable = false)
    private PlantEntity plantEntity;

    @ManyToOne
    @JoinColumn(name = "fk_orderEntity")
    private OrderEntity orderEntity;

    @Transient
    private Double getSquareBase() {
        return width * depth;
    }

    @Transient
    private Double getCubicArea() {
        return getSquareBase() * height;
    }
}
