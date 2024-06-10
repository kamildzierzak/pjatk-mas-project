package mas.ManagementSystem.service;

import mas.ManagementSystem.domain.entities.warehouse.Row;
import mas.ManagementSystem.repository.RowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RowService {

    private final RowRepository rowRepository;

    public RowService(final RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    public Iterable<Row> getAllRows() {
        return rowRepository.findAll();
    }

    public Optional<Row> getRowById(Long id) {
        return rowRepository.findById(id);
    }

//    TODO public Row saveRow(Row row) {}
//    TODO public void deleteRow(Long id) {}
}
