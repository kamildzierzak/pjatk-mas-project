package mas.ManagementSystem.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.people.PersonEntity;
import mas.ManagementSystem.domain.types.OrderActionType;

@Entity
@Table(name = "order_action")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderActionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "fk_orderEntity", nullable = false)
  private OrderEntity orderEntity;

  @ManyToOne
  @JoinColumn(name = "fk_personEntity", nullable = false)
  private PersonEntity personEntity;

  @Enumerated(EnumType.STRING)
  private OrderActionType actionType;

  private LocalDateTime time;
}
