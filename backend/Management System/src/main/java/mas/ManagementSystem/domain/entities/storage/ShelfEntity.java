package mas.ManagementSystem.domain.entities.storage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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
