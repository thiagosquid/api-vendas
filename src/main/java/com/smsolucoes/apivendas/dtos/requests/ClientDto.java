package com.smsolucoes.apivendas.dtos.requests;

import com.smsolucoes.apivendas.entities.Sale;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDto {

    private Long id;

    private String name;

    private String cpfCnpj;

    private List<Sale> sales = new ArrayList<>();

}
