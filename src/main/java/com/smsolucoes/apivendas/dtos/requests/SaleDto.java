package com.smsolucoes.apivendas.dtos.requests;

import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleDto {

    private Long id;

    private String date;

    private Client client;

    private List<Product> products = new ArrayList<>();

}
