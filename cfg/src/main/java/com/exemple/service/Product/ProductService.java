package com.exemple.service.Product;


import com.exemple.entity.Product;
import com.exemple.repository.InterfaceProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ProductService implements IProduct {

        @Autowired
        private InterfaceProductRespository produitRepository;

        @Override
        public List<Product> getProducts() {
            return produitRepository.findAll();
        }

        @Override
        public Product getProductById(long id) {
            return produitRepository.findById(id).orElse(null);
        }

        @Override
        public Product updateProduct(long id, String name, String description, double price, int quantity) {
            Product existingProduit = produitRepository.findById(id).orElse(null);

            if (existingProduit != null) {
                existingProduit.setName(name);
                existingProduit.setDescription(description);
                existingProduit.setPrix(price);
                existingProduit.setQnt(quantity);

                return produitRepository.save(existingProduit);
            }

            return null;
        }

        @Override
        public void deleteProduct(long id) {
            produitRepository.deleteById(id);
        }

        @Override
        public Product addProduct(String name, String description, double price, int quantity) {
            Product newProduit = new Product();
            newProduit.setName(name);
            newProduit.setDescription(description);
            newProduit.setPrix(price);
            newProduit.setQnt(quantity);

            return produitRepository.save(newProduit);
        }
    }

