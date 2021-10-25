package com.smsolucoes.apivendas.dtos;

import com.smsolucoes.apivendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;

    @NotNull
    private String name;

    @CPF
    private String cpfCnpj;

    private List<Sale> salesList = new ArrayList<>();

}
