package mas.ManagementSystem.service;

import mas.ManagementSystem.domain.entities.warehouse.Shelf;
import mas.ManagementSystem.repository.ShelfRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public ShelfService(final ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public Iterable<Shelf> getAllShelves() {
        return shelfRepository.findAll();
    }

    public Optional<Shelf> getShelfById(Long id) {
        return shelfRepository.findById(id);
    }

//    TODO public Shelf saveShelf(Shelf shelf) {}
//    TODO public void deleteShelf(Long id) {}
}
