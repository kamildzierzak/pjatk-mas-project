package mas.ManagementSystem.model.warehouse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Row {
    private String name;
    private static char currentName = 'A';
    private static final int MAX_SHELVES = 30;
    private List<Shelf> shelves = new ArrayList<>();

    public Row(List<Shelf> shelves) {
        if (currentName > 'J') {
            throw new IllegalStateException("Cannot create more thant 10 rows. J row was the last one available.");
        }
        this.name = String.valueOf(currentName);
        currentName++;
    }

    public void addShelf(Shelf shelf) {
        if (shelves.size() >= MAX_SHELVES) {
            throw new IllegalStateException("Cannot add more than " + MAX_SHELVES + " shelves.");
        }
        shelves.add(shelf);
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

}
