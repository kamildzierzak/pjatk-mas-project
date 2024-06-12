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

    public List<ShelfEntity> getShelves() {
        return shelfRepository.findAll();
    }

    public Optional<ShelfEntity> getShelf(Long id) {
        return shelfRepository.findById(id);
    }

    public ShelfEntity createShelf(ShelfEntity shelfEntity) {
        return shelfRepository.save(shelfEntity);
    }

    public ShelfEntity updateShelf(ShelfEntity shelfEntity) {
        return shelfRepository.save(shelfEntity);
    }

    public void deleteShelf(Long id) {
        shelfRepository.deleteById(id);
    }

}
