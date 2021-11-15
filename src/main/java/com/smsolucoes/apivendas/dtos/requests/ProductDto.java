package com.smsolucoes.apivendas.dtos.requests;

import com.smsolucoes.apivendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private double price;

    private List<Sale> saleList;

}
