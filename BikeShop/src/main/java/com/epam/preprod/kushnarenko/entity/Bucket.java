package main.java.com.epam.preprod.kushnarenko.entity;

import java.util.HashMap;
import java.util.Map.Entry;

import main.java.com.epam.preprod.kushnarenko.service.ProductService;

public class Bucket {

    private HashMap<Long, Integer> container;
    private ProductService productService;

    public Bucket(ProductService productService) {
        this.productService = productService;
        container = new HashMap<>();
    }

    public void put(Long key, Integer value) {
        container.put(key, value);
    }

    public Integer get(Long key) {
        return container.get(key);
    }

    public void remove(Long key) {
        container.remove(key);
    }

    public HashMap<Product, Integer> getBucketForView() {
        HashMap<Product, Integer> bucketForView = new HashMap<>();
        for (Entry<Long, Integer> entry : container.entrySet()) {
            bucketForView.put(productService.getProductById(entry.getKey()), entry.getValue());
        }
        return bucketForView;
    }

    @Override
    public String toString() {
        return container.toString();
    }

    public Integer summ() {
        Integer summ = 0;
        for (Entry<Long, Integer> entry : container.entrySet()) {
            summ += entry.getValue();
        }
        return summ;
    }

}
