package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.types.OrderStatusType;
import mas.ManagementSystem.domain.types.OrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"Order\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime creationDate;
    private LocalDateTime completionDate;

    private BigDecimal amountToPay;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

}
