package mas.ManagementSystem.domain.entities.storage;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private Double pricePerUnit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_shelfEntity")
    private ShelfEntity shelfEntity;

    @OneToMany(mappedBy = "stockEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockItemEntity> stockItems = new ArrayList<>();

    @Transient
    public Double getTotalPrice() {
        return getTotalQuantity() * pricePerUnit;
    }

    @Transient
    public Integer getTotalQuantity() {
        return stockItems.size();
    }

    @Transient
    public Double getTotalWeight() {
        Double totalWeight = 0.0;

        for (StockItemEntity item : stockItems) {
            Double itemWeight = item.getWeight();
            if (itemWeight != null) {
                totalWeight += itemWeight;
            }
        }

        return totalWeight;
    }

//    TODO COUNT OCCUPIED SPACE BY THIS STOCK
//    @Transient
//    public Double

//    TODO COUNT AVAILABLE SPACE <= MAX SHELF CAPACITY
//    @Transient
//    public Double availableSpace() {
//        return ShelfEntity.getSquareBase() -
//    }

}
