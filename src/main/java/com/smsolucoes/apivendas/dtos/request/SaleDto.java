package com.smsolucoes.apivendas.dtos.request;

import com.smsolucoes.apivendas.entities.Sale;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleDto {

    public int id;

    @NotEmpty
    public String date;

//    public List<ProductDto> products = new ArrayList<>();


}