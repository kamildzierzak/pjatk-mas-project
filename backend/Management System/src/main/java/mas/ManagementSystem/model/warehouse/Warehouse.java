package mas.ManagementSystem.model.warehouse;

import java.util.List;


public class Warehouse {
    private List<Row> rows;

    public Warehouse(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }
}
