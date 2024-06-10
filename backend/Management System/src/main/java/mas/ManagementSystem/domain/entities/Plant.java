package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.types.PlantType;

@Entity
@Table(name = "plant")
@NoArgsConstructor
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    private PlantType type;

}
