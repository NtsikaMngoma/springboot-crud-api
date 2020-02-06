package com.crud.demo.services;

import com.crud.demo.entities.Product;

public interface ProductService {
    public Iterable<Product> findAll();
    public Product find(String id);
    public Product save(Product product);
    public void delete(String id);
}
