package mas.ManagementSystem.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import mas.ManagementSystem.model.types.OrderStatusType;
import mas.ManagementSystem.model.types.OrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")
@NoArgsConstructor
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
