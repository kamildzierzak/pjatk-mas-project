package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.StockEntity;

import java.util.ArrayList;

@Entity
@Table(name = "shelf")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShelfEntity {
    public static final int SHELF_WIDTH = 240;
    public static final int SHELF_HEIGHT = 80;
    public static final int SHELF_DEPTH = 80;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer number;

    @ManyToOne(cascade = CascadeType.ALL)
    private RackEntity rackEntity;

    //    aggregation (delete whole, leave parts untouched)
    @OneToMany(mappedBy = "shelfEntity", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    private ArrayList<StockEntity> stockEntity = new ArrayList<>();

//    private ShelfEntity(RackEntity rackEntity, int number) {
//        this.rackEntity = rackEntity;
//        this.number = number;
//    }
//
//    public static ShelfEntity createShelf(RackEntity rackEntity, int number) throws Exception {
//        if (rackEntity == null) {
//            throw new Exception("Cannot create shelf without a rack.");
//        }
//
//        ShelfEntity shelfEntity = new ShelfEntity(rackEntity, number);
//
//        rackEntity.addShelf(shelfEntity);
//
//        return shelfEntity;
//    }
}
