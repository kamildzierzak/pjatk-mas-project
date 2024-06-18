package mas.ManagementSystem.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.people.CustomerEntity;
import mas.ManagementSystem.domain.entities.people.SupplierEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.types.OrderStatusType;
import mas.ManagementSystem.domain.types.OrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"order\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime creationDate;

    private LocalDateTime completionDate;

    private BigDecimal priceToPay;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

    @ManyToOne
    @JoinColumn(name = "fk_customerEntity", nullable = true)
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "fk_supplierEntity", nullable = true)
    private SupplierEntity supplierEntity;

    @OneToMany(mappedBy = "orderEntity")
    @OrderBy("time DESC")
    private List<OrderActionEntity> actionsPerformedBy = new ArrayList<>();

    @OneToMany(mappedBy = "orderEntity")
    private List<BatchEntity> content;
}
