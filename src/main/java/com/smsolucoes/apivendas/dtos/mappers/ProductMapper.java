package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.ProductDto;
import com.smsolucoes.apivendas.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);

    Product toModel(ProductDto productDto);
}
