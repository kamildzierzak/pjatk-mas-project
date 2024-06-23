package mas.ManagementSystem.services;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.storage.RowEntity;
import mas.ManagementSystem.repositories.RowRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RowService {

  private final RowRepository rowRepository;

  public List<RowEntity> getRows() {
    return rowRepository.findAll();
  }

  public List<RowEntity> getRowsWithEmptyShelves() {
    return rowRepository.findAllRowsWithEmptyShelves();
  }

  public Optional<RowEntity> getRow(Long id) {
    return rowRepository.findById(id);
  }

//    public List<RowEntity> getRowsByWarehouse(Long id) {
//        return rowRepository.findAll;
//    }

  public RowEntity createRow(RowEntity rowEntity) {
    return rowRepository.save(rowEntity);
  }

  public RowEntity updateRow(RowEntity rowEntity) {
    return rowRepository.save(rowEntity);
  }

  public void deleteRow(Long id) {
    rowRepository.deleteById(id);
  }

}
