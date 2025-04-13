package org.example.studentsapp.web;

import org.example.studentsapp.entities.Product;
import org.example.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    };

    @GetMapping("/products/{id}")
    public Product findproducts(@PathVariable Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    };
}
