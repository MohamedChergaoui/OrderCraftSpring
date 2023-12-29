package com.exemple.repository;

import com.exemple.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository("InterfaceProductRespository")
public interface InterfaceProductRespository extends JpaRepository<Product,Long> {
    Set<Product> findProduitsById(Long commandeId);
}
