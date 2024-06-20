package mas.ManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {

    private Long id;
    private String plantName;
    private String dimensions;
    private Double weight;
    private String rowLocation;
    private Integer rackLocation;
    private Integer shelfLocation;
    private Integer plantsQuantity;
    private Long orderId;
}
