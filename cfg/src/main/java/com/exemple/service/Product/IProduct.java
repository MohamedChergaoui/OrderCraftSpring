package com.exemple.service.Product;

import com.exemple.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> getProducts();

    Product getProductById(long id);

    Product updateProduct(long id, String name, String description, double price, int quantity);

    void deleteProduct(long id);

    Product addProduct(String name, String description, double price, int quantity);
}


