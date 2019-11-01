package ru.itpark.repository;

import ru.itpark.model.Product;

import java.util.*;

public class ProductRepository {
    private Collection<Product> items;
    private long nextId = 1;

    public ProductRepository(Collection<Product> items) {
        this.items = items;
    }

    public void saveItem(Product item) {
        if (item.getId() == 0) {
            item.setId(nextId++);
            items.add(item);
        }
    }

    public void removeItem(long id) {
        if (!items.removeIf(o -> id == o.getId())) {
            throw new IllegalArgumentException("The ID didn't match any item");
        }
    }

    public Collection<Product> getAll() {
        return items;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> results = new LinkedList<>();
        for (Product item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                results.add(item);
            }
        }
        return results;
    }

    public List<Product> searchByName(String name) {
        List<Product> results = new LinkedList<>();
        for (Product item : items) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }


    public void saveBatch(Collection<Product> items) {
        this.items.addAll(items);
    }

    public void saveItems(Product[] items) {
        Collections.addAll(this.items, items);
    }
}
