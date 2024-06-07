package mas.ManagementSystem.config;

import mas.ManagementSystem.model.warehouse.Row;
import mas.ManagementSystem.model.warehouse.Shelf;
import mas.ManagementSystem.model.warehouse.Warehouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WarehouseConfig {

    @Bean
    public Warehouse warehouse(List<Row> rows) {
        return new Warehouse(rows);
    }

    @Bean
    public List<Row> rows() {
        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            rows.add(new Row(shelves()));
        }

        return rows;
    }

    @Bean
    public List<Shelf> shelves() {
        List<Shelf> shelves = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            shelves.add(new Shelf(i));
        }

        return shelves;
    }
}
