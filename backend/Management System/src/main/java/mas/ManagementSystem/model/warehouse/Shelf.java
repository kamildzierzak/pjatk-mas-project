package mas.ManagementSystem.model.warehouse;

import mas.ManagementSystem.model.Plant;
import org.springframework.stereotype.Component;

import java.util.List;

public class Shelf {

    private int number;
    private List<Plant> plants;

    public Shelf(int number) {
        this.number = number;
    }
}
