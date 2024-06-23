package mas.ManagementSystem.services;

import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.people.SupplierEntity;
import mas.ManagementSystem.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierService {

  private final SupplierRepository supplierRepository;

  public Optional<SupplierEntity> getSupplier(Long id) {
    return supplierRepository.findById(id);
  }
}
