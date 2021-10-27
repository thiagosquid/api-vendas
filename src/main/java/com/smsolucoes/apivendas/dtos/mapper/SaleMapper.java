package com.smsolucoes.apivendas.dtos.mapper;

import com.smsolucoes.apivendas.dtos.request.SaleDto;
import com.smsolucoes.apivendas.entities.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Sale toModel(SaleDto dto);

    SaleDto toDTO(Sale sale);

}
