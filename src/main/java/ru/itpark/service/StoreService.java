package ru.itpark.service;

import ru.itpark.model.Product;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class StoreService {
    private ProductRepository repository = new ProductRepository(new ArrayList<Product>());

    public static List<Product> sortItems(List<Product> items, int page, int itemsPerPage) {
        items.sort((o1, o2) -> o1.getPriceKop() - o2.getPriceKop());
        return items.subList(page * (itemsPerPage - 1), page * itemsPerPage);
    }

    public static List<Product> sortItemsByPriceDesc(List<Product> items, int page, int itemsPerPage) {
        items.sort((o1, o2) -> o2.getPriceKop() - o1.getPriceKop());
        return items.subList(page * (itemsPerPage - 1), page * itemsPerPage);
    }

    public static List<Product> sortItemsByRating(List<Product> items, int page, int itemsPerPage) {
        items.sort((o1, o2) -> o1.getRating() - o2.getRating());
        return items.subList(page * (itemsPerPage - 1), page * itemsPerPage);
    }

    public static List<Product> sortItemsByName(List<Product> items, int page, int itemsPerPage) {
        items.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return items.subList(page * (itemsPerPage - 1), page * itemsPerPage);
    }

    public void add(Product item) {
        if (item.getId() != 0) {
            throw new IllegalArgumentException("id must be zero!");
        }
        if (item.getPriceKop() <= 0) {
            throw new IllegalArgumentException("price must be greater than zero");
        }
        repository.saveItem(item);
    }

    public void addBatch(Collection<Product> items) {
        for (Product item : items) {
            add(item);
        }
    }

    public void delete(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be above zero!");
        }
        try {
            repository.removeItem(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public List<Product> getByName(String name) {
        List<Product> results = repository.searchByName(name);
        results.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return results;
    }

    public List<Product> getByCategory(String category) {
        List<Product> results = repository.searchByCategory(category);
        results.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return results;
    }

    public List<Product> getSortedBy(Comparator<Product> comparator) {
        List<Product> result = new LinkedList<>(repository.getAll());
        result.sort(comparator);
        return result;
    }

    public List<Product> getSortedBy() {
        return getSortedBy((o1, o2) -> o1.getPriceKop() - o2.getPriceKop());
    }

    public List<Product> getCategorySorted(String category) {
        List<Product> result = new LinkedList<>(repository.searchByCategory(category));
        result.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return result;
    }
}