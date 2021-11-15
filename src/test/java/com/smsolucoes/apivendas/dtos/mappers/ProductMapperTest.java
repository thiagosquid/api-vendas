package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.ProductDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.entities.Sale;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    @Test
    public void shouldMapProductToDto(){

        Sale sale = new Sale(1L, LocalDate.now(),new Client(),new ArrayList<Product>());
        List<Sale> saleList = new ArrayList<>();
        saleList.add(sale);

        Product product = new Product(1L, "Mesa", 2.50,new ArrayList<Sale>(saleList));

        ProductDto productDto = ProductMapper.INSTANCE.toDto(product);

        assertNotNull(productDto);
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getPrice(), productDto.getPrice());
        assertEquals(product.getSaleList(), productDto.getSaleList());

    }

    @Test
    public void shouldMapProductDtoToModel(){
        Sale sale = new Sale(1L, LocalDate.now(),new Client(),new ArrayList<Product>());
        List<Sale> saleList = new ArrayList<>();
        saleList.add(sale);
        ProductDto productDto = new ProductDto(1L, "Mesa", 2.50,new ArrayList<Sale>(saleList));

        Product product = ProductMapper.INSTANCE.toModel(productDto);

        assertNotNull(product);
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getPrice(), productDto.getPrice());
        assertEquals(product.getSaleList(), productDto.getSaleList());

    }

}