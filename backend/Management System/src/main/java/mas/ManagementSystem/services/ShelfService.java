package mas.ManagementSystem.services;

import mas.ManagementSystem.domain.entities.warehouse.ShelfEntity;
import mas.ManagementSystem.repositories.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public ShelfService(final ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public Iterable<ShelfEntity> getAllShelves() {
        return shelfRepository.findAll();
    }

    public Optional<ShelfEntity> getShelfById(Long id) {
        return shelfRepository.findById(id);
    }

//    TODO public Shelf saveShelf(Shelf shelf) {}
//    TODO public void deleteShelf(Long id) {}
}
