package mas.ManagementSystem.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.types.PlantType;

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

  @OneToMany(mappedBy = "plantEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
