package com.smsolucoes.apivendas.dtos.mapper;

import com.smsolucoes.apivendas.dtos.request.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "name")
    Client toModel(ClientDto dto);

    ClientDto toDTO(Client client);

}
