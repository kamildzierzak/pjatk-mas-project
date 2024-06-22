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
public class RackDto {

  private Long id;
  private Integer number;
  private Long rowId;
  private List<ShelfDto> shelves;

}
