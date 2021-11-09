package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;
    
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
}
