package com.project.ecommerce_rest_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce_rest_api.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
