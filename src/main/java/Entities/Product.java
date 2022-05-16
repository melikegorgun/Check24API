package Entities;

import java.util.List;

public class Product {

    public int id;
    public Tab tabs;

    public Product(int id, Tab tabs) {
        this.id = id;
        this.tabs = tabs;
    }

    public int getId() {
        return id;
    }

    public Tab getTabs() {
        return tabs;
    }
}
