package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.dtos.mappers.ProductMapper;
import com.smsolucoes.apivendas.dtos.requests.ProductDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.exceptions.ProductNotFoundException;
import com.smsolucoes.apivendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().stream().map(product -> productMapper.toDto(product))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        return productMapper.toDto(verifyIfExists(id));
    }

    public void deleteProductById(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }

    public ProductDto createProduct(ProductDto productDto){
        Product product = productMapper.toModel(productDto);
        return  productMapper.toDto(productRepository.save(product));
    }

    public ProductDto updateProduct(ProductDto productDto) throws ProductNotFoundException {
        verifyIfExists(productDto.getId());
        Product product = productMapper.toModel(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    private Product verifyIfExists(Long id) throws ProductNotFoundException {

        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id.intValue()));

    }
}
