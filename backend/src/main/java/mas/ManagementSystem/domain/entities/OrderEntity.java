package mas.ManagementSystem.domain.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mas.ManagementSystem.domain.entities.people.CustomerEntity;
import mas.ManagementSystem.domain.entities.people.SupplierEntity;
import mas.ManagementSystem.domain.entities.storage.BatchEntity;
import mas.ManagementSystem.domain.types.OrderStatusType;
import mas.ManagementSystem.domain.types.OrderType;

@Entity
@Table(name = "\"order\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalDateTime creationDate;

  private LocalDateTime completionDate;

  private Double priceToPay;

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
  private List<OrderActionEntity> actionsPerformedBy;

  @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
  @CollectionTable
  private List<BatchEntity> content;
}
