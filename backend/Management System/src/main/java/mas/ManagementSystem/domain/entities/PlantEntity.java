package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.storage.StockItemEntity;
import mas.ManagementSystem.domain.types.PlantType;

import java.util.List;

@Entity
@Table(name = "plant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private Double maxWidth;

    private Double maxHeight;

    private Double maxDepth;

    private Double maxWeight;

    @Enumerated(EnumType.STRING)
    private PlantType type;

    @OneToMany(mappedBy = "plantEntity")
    private List<StockItemEntity> stockItems;

    @Transient
    private Double getSquareBase() {
        return maxWidth * maxDepth;
    }

    @Transient
    private Double getCubicArea() {
        return getSquareBase() * maxHeight;
    }

}
