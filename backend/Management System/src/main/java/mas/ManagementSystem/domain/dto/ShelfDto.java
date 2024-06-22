package mas.ManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShelfDto {

  private Long id;
  private Integer number;
  private Long rackId;
  private Long batchId;

}
