package mas.ManagementSystem.services;

import mas.ManagementSystem.domain.entities.warehouse.RowEntity;
import mas.ManagementSystem.repositories.RowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RowService {

    private final RowRepository rowRepository;

    public RowService(final RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    public Iterable<RowEntity> getAllRows() {
        return rowRepository.findAll();
    }

    public Optional<RowEntity> getRowById(Long id) {
        return rowRepository.findById(id);
    }

//    TODO public Row saveRow(Row row) {}
//    TODO public void deleteRow(Long id) {}
}
