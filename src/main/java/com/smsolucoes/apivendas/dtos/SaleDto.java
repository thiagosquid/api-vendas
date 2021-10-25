package com.smsolucoes.apivendas.dtos;

import com.smsolucoes.apivendas.entities.Sale;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SaleDto {

    public int id;
    public LocalDate date;
//    public List<ProductDto> products = new ArrayList<>();

    public SaleDto(Sale sale) {
        this.id = sale.getId();
        this.date = sale.getDate();

//        this.products = sale.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

}