package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.entities.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ClientMapperTest {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Test
    public void shouldMapClientToDto(){
        List salesList = new ArrayList<Sale>();
        Sale sale = new Sale(1L, LocalDate.now(), new Client(), new ArrayList<Product>());
        salesList.add(sale);

        Client client = new Client(1L,"Thiago","123.123.123-21",salesList);

        ClientDto clientDto = clientMapper.toDto(client);

        assertNotNull(clientDto);
        assertEquals(client.getName(), clientDto.getName());
        assertEquals(client.getCpfCnpj(), clientDto.getCpfCnpj());
        assertEquals(client.getSales(), clientDto.getSales());
    }

    @Test
    public void shouldMapClientDtoToClient(){
        List salesList = new ArrayList<Sale>();
        Sale sale = new Sale(1L, LocalDate.now(), new Client(), new ArrayList<Product>());
        salesList.add(sale);

        ClientDto clientDto = new ClientDto(1L,"Thiago","123.123.123-21",salesList);

        Client client = clientMapper.toModel(clientDto);

        assertNotNull(clientDto);
        assertEquals(client.getName(), clientDto.getName());
        assertEquals(client.getCpfCnpj(), clientDto.getCpfCnpj());
        assertEquals(client.getSales(), clientDto.getSales());
    }

}