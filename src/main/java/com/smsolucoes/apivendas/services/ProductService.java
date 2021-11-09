package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
}
