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
public class RackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer number;

    @ManyToOne
    private RowEntity rowEntity;

    @OneToMany(mappedBy = "rackEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShelfEntity> shelves = new ArrayList<>();

    private RackEntity(RowEntity rowEntity, int number) {
        this.rowEntity = rowEntity;
        this.number = number;
    }

    public void addShelf(ShelfEntity shelfEntity) throws Exception {
        if (!shelves.contains(shelfEntity)) {
            shelves.add(shelfEntity);
        }
    }

    public static RackEntity createRack(RowEntity rowEntity, int number) throws Exception {
        if (rowEntity == null) {
            throw new Exception("Cannot create rack without row.");
        }

        RackEntity rackEntity = new RackEntity(rowEntity, number);

        rowEntity.addRack(rackEntity);

        return rackEntity;
    }
}
