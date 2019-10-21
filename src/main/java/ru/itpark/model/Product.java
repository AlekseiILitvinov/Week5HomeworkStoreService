package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product implements Comparable<Product> {
    private long id;
    private String name;
    private String description;
    private String category;
    private int priceKop;
    private int rating;

    @Override
    public int compareTo(Product o) {
        return getPriceKop() - o.getPriceKop();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", priceKop=" + priceKop +
                ", rating=" + rating +
                '}';
    }
}
