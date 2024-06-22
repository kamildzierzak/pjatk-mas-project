package mas.ManagementSystem.domain.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RowDto {

  private Long id;
  private String name;
  private Long warehouseId;
  private List<RackDto> racks;

}
