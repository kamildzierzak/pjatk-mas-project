package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shelf")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShelfEntity {
    public static final Integer SHELF_WIDTH = 240;
    public static final Integer SHELF_HEIGHT = 80;
    public static final Integer SHELF_DEPTH = 80;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_rackEntity")
    private RackEntity rackEntity;

    @OneToMany(mappedBy = "shelfEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    private List<StockEntity> stocks;

    @Transient
    public static Integer getSquareBase() {
        return SHELF_WIDTH * SHELF_DEPTH;
    }

    @Transient
    public static Integer getCubicArea() {
        return getSquareBase() * SHELF_HEIGHT;
    }

//    TODO COUNT AVAILABLE SPACE AT THIS SHELF
//    @Transient
//    public static Double getAvailableCapacity() {
//        return getCubicArea() -
//    }

}
