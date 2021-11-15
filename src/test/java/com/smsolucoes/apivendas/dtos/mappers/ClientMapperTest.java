package com.smsolucoes.apivendas.dtos.mappers;

import com.smsolucoes.apivendas.dtos.requests.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ClientMapperTest {

    @Test
    public void shouldMapClientToDto(){
        Client client = new Client(1L,"Thiago","123.123.123-21",new ArrayList<>());

        ClientDto clientDto = ClientMapper.INSTANCE.toDto(client);

        assertNotNull(clientDto);
        assertEquals(client.getName(), clientDto.getName());
        assertEquals(client.getCpfCnpj(), clientDto.getCpfCnpj());
        assertEquals(client.getSales(), clientDto.getSales());
    }

    @Test
    public void shouldMapClientDtoToClient(){
        ClientDto clientDto = new ClientDto(1L,"Thiago","123.123.123-21",new ArrayList<>());

        Client client = ClientMapper.INSTANCE.toModel(clientDto);

        assertNotNull(clientDto);
        assertEquals(client.getName(), clientDto.getName());
        assertEquals(client.getCpfCnpj(), clientDto.getCpfCnpj());
        assertEquals(client.getSales(), clientDto.getSales());
    }

}