package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.SaleDto;
import com.smsolucoes.apivendas.entities.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd")
    SaleDto toDto(Sale sale);

    Sale toModel(SaleDto saleDto);

}
