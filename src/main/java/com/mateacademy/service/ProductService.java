package com.mateacademy.service;

import com.mateacademy.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product addProduct(Product product);

    Product getById(Long id);

    Product update(Product product);

    void delete(Long id);
}
