package mas.ManagementSystem.config;

import mas.ManagementSystem.domain.entities.warehouse.Warehouse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarehouseConfig implements CommandLineRunner {

    public Warehouse warehouse() {
        return new Warehouse();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
