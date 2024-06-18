package mas.ManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.entities.storage.ShelfEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {

    private Long id;
    private Integer amount;
    private Double pricePerUnit;
    private ShelfEntity shelfEntity;
    private PlantEntity plantEntity;
}
