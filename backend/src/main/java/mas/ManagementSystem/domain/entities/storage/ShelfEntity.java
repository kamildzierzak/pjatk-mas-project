package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shelf")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShelfEntity {

  public static final Integer SHELF_WIDTH = 140;
  public static final Integer SHELF_HEIGHT = 100;
  public static final Integer SHELF_DEPTH = 100;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private Integer number;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fk_rackEntity", nullable = false)
  private RackEntity rackEntity;

  @OneToOne(mappedBy = "shelfEntity")
  private BatchEntity batchEntity;

  @Transient
  public static Integer getSquareBase() {
    return SHELF_WIDTH * SHELF_DEPTH;
  }

  @Transient
  public static Integer getCubicArea() {
    return getSquareBase() * SHELF_HEIGHT;
  }

  //    TODO getLocation()

}
