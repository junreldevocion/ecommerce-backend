package com.project.ecommerce_rest_api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.ecommerce_rest_api.model.Product;
import com.project.ecommerce_rest_api.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product prod, MultipartFile imagefFile) throws IOException {
        prod.setImageName(imagefFile.getOriginalFilename());
        prod.setImageType(imagefFile.getContentType());
        prod.setImageDate(imagefFile.getBytes());
        return repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

}
