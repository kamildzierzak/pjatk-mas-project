package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.Stock;

import java.util.ArrayList;

@Entity
@Table(name = "shelf")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Shelf {
    public static final int SHELF_WIDTH = 240;
    public static final int SHELF_HEIGHT = 80;
    public static final int SHELF_DEPTH = 80;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer number;

    @ManyToOne(cascade = CascadeType.ALL)
    private Rack rack;

    @OneToMany(mappedBy = "shelf", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    private ArrayList<Stock> stock = new ArrayList<>();

    private Shelf(Rack rack, int number) {
        this.rack = rack;
        this.number = number;
    }

    public static Shelf createShelf(Rack rack, int number) throws Exception {
        if (rack == null) {
            throw new Exception("Cannot create shelf without a rack.");
        }

        Shelf shelf = new Shelf(rack, number);

        rack.addShelf(shelf);

        return shelf;
    }
}
