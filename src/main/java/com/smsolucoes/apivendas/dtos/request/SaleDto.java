package com.smsolucoes.apivendas.dtos.request;


import com.smsolucoes.apivendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDto {

    private Long id;

    @NotEmpty
    private String date;

    private ClientDto client;

//    public List<ProductDto> products = new ArrayList<>();

    public SaleDto(Sale sale) {
        this.id = sale.getId();
    }


}