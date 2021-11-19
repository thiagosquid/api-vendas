package com.smsolucoes.apivendas.builder;

import com.smsolucoes.apivendas.dtos.requests.ClientDto;
import com.smsolucoes.apivendas.entities.Sale;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class ClientDtoBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Manoel";

    @Builder.Default
    private String cpfCnpj = "990.321.123-45";

//    @Builder.Default
//    private List<Sale> sales = new ArrayList<>();

    public ClientDto toClientDto(){
        return new ClientDto(null, name, cpfCnpj, null);
    }

}
