package mas.ManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.PlantEntity;
import mas.ManagementSystem.domain.entities.warehouse.ShelfEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private Long id;
    private Integer amount;
    private Double pricePerUnit;
    private ShelfEntity shelfEntity;
    private PlantEntity plantEntity;
}
