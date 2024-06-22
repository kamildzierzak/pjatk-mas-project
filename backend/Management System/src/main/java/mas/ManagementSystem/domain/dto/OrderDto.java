package mas.ManagementSystem.domain.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

  private Long id;
  private LocalDateTime creationDate;
  private LocalDateTime completionDate;
  private Double priceToPay;
  private String orderType;
  private String orderStatusType;
  private List<BatchDto> content;
}
