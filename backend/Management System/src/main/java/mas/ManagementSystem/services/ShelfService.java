package mas.ManagementSystem.services;

import lombok.AllArgsConstructor;
import mas.ManagementSystem.domain.entities.warehouse.ShelfEntity;
import mas.ManagementSystem.repositories.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public List<ShelfEntity> getAllShelves() {
        return shelfRepository.findAll();
    }

    public Optional<ShelfEntity> getShelfById(Long id) {
        return shelfRepository.findById(id);
    }

//    TODO public Shelf saveShelf(Shelf shelf) {}
//    TODO public void deleteShelf(Long id) {}
}
