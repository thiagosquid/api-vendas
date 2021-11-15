package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.dtos.requests.ProductDto;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.exceptions.ProductNotFoundException;
import com.smsolucoes.apivendas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) throws ProductNotFoundException{
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
        return productService.updateProduct(productDto);
    }
}
