package Entities;

import java.util.List;

public class SectionGeneral {

    List<Row> rows;

    public SectionGeneral(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }
}
