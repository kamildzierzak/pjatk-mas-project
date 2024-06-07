package mas.ManagementSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.model.types.PlantType;

@Entity
@Table(name = "plant")
@NoArgsConstructor
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private PlantType type;

    public Plant(String name, String description, PlantType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }
}
