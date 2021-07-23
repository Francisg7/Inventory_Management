package com.eurekadevops.sabre.web.rest;

import com.eurekadevops.sabre.entity.Product;
import com.eurekadevops.sabre.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductResource {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
   
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable(name = "id") Long id) {
        return productService.getOne(id);
    }
    
}
