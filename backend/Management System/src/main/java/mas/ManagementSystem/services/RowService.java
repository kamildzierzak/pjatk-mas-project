package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.warehouse.RowEntity;
import mas.ManagementSystem.repositories.RowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RowService {

    private final RowRepository rowRepository;

    public List<RowEntity> getAllRows() {
        return rowRepository.findAll();
    }

    public Optional<RowEntity> getRowById(Long id) {
        return rowRepository.findById(id);
    }

//    TODO public Row saveRow(Row row) {}
//    TODO public void deleteRow(Long id) {}
}
