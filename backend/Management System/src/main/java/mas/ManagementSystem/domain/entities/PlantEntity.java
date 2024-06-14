package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
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

    @Enumerated(EnumType.STRING)
    private PlantType type;

    private Double maxPlantWidth;

    private Double maxPlantHeight;

    private Double maxPlantDepth;

    private Double maxPlantWeight;

    private Integer maximumQuantityInBatch;

    @OneToMany(mappedBy = "plantEntity")
    private List<BatchEntity> batches;

    @Transient
    public Double getSquareBase() {
        return maxPlantWidth * maxPlantDepth;
    }

    @Transient
    public Double getCubicArea() {
        return getSquareBase() * maxPlantHeight;
    }

}
