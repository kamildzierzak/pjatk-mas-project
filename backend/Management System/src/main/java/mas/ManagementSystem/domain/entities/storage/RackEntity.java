package mas.ManagementSystem.domain.entities.storage;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @JoinColumn(name = "fk_rowEntity", nullable = false)
    private RowEntity rowEntity;

    //    composition (delete all parts when whole is deleted)
    @OneToMany(mappedBy = "rackEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 3, message = "Maximum number of shelves per rack is 3.")
    private List<ShelfEntity> shelves = new ArrayList<>();

    //    TODO getLocation()
    //    TODO COUNT AVAILABLE SPACE AT THIS RACK

}
