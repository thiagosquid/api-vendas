package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.exceptions.ProductNotFoundException;
import com.smsolucoes.apivendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }

    public void deleteProductById(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }

    public Product createProduct(Product product){
        return  productRepository.save(product);
    }

    public Product updateProduct(Product product) throws ProductNotFoundException {
        verifyIfExists(product.getId());

        return productRepository.save(product);
    }




    private Product verifyIfExists(Long id) throws ProductNotFoundException {

        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id.intValue()));

    }
}
