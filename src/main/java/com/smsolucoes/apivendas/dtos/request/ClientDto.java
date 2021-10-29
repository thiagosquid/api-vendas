package com.smsolucoes.apivendas.dtos.request;

import com.smsolucoes.apivendas.dtos.mapper.SaleMapper;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private Long id;

    @NotEmpty
    @Size(min=2, max=50)
    private String name;

    @NotEmpty
    @CPF
    private String cpfCnpj;

    @Valid
    @NotEmpty
    private List<SaleDto> salesList = new ArrayList<>();

    public ClientDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.cpfCnpj = client.getCpfCnpj();

        this.salesList = client.getSales().stream().map(sale -> new SaleDto(sale)).collect(Collectors.toList());

    }

}
