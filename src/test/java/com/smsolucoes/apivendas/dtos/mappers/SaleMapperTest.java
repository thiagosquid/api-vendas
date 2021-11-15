package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.SaleDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Sale;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaleMapperTest {

    @Test
    public void shouldMapSaleToDto(){
        Sale sale = new Sale(1L, LocalDate.now(),new Client(),new ArrayList<>());

        SaleDto saleDto = SaleMapper.INSTANCE.toDto(sale);

        assertNotNull(saleDto);
        assertEquals(sale.getDate().toString(), saleDto.getDate());
        assertEquals(sale.getClient(), saleDto.getClient());
    }

    @Test
    public void shouldMapSaleDtoToSale(){

        SaleDto saleDto = new SaleDto(1L, "2021-11-01", new Client(), new ArrayList<>());

        Sale sale = SaleMapper.INSTANCE.toModel(saleDto);

        assertNotNull(sale);
        assertEquals(sale.getDate().toString(), saleDto.getDate());
        assertEquals(sale.getClient(), saleDto.getClient());

    }

}