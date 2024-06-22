package mas.ManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.types.PlantType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantDto {

  private Long id;
  private String name;
  private String description;
  private PlantType type;

}
