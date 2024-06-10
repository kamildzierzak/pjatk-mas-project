package mas.ManagementSystem.domain.entities.warehouse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rack")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer number;

    @ManyToOne
    private Row row;

    @OneToMany(mappedBy = "rack", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Shelf> shelves = new ArrayList<>();

    private Rack(Row row, int number) {
        this.row = row;
        this.number = number;
    }

    public void addShelf(Shelf shelf) throws Exception {
        if (!shelves.contains(shelf)) {
            shelves.add(shelf);
        }
    }

    public static Rack createRack(Row row, int number) throws Exception {
        if (row == null) {
            throw new Exception("Cannot create rack without row.");
        }

        Rack rack = new Rack(row, number);

        row.addRack(rack);

        return rack;
    }
}
