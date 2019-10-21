package ru.itpark.model;

import lombok.Data;

@Data
public class JeansProduct extends Product {
    private static final String CATEGORY_NAME = "Джинсы";
    private String color;
    private int size;

    public JeansProduct(long id, String name, String description, int priceKop, int rating, String color, int size) {
        super(id, name, description, CATEGORY_NAME, priceKop, rating);
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "JeansProduct{" +
                "color='" + color + '\'' +
                ", size=" + size +
                "} " + super.toString();
    }
}
