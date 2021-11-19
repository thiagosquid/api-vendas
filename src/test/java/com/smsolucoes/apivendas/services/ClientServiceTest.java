package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.builder.ClientDtoBuilder;
import com.smsolucoes.apivendas.dtos.mappers.ClientMapper;
import com.smsolucoes.apivendas.dtos.requests.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    public final Long ID_NOT_EXISTENT = 1L;

    @Mock
    private ClientRepository clientRepository;

    private ClientMapper clientMapper = ClientMapper.INSTANCE;

    @InjectMocks
    private ClientService clientService;

    @Test
    void whenClientInformedItShouldBeCreated(){
        // given
        ClientDto clientDto = ClientDtoBuilder.builder().build().toClientDto();
        Client expectedSavedClient = clientMapper.toModel(clientDto);

        // when
//        when(clientRepository.save(expectedSavedClient)).thenReturn(expectedSavedClient);
        when(clientRepository.save(any())).then(returnsFirstArg());
        //then
        ClientDto createdClientDto = clientService.createClient(clientDto);

        assertEquals(clientDto.getName(), createdClientDto.getName());
        assertEquals(clientDto.getCpfCnpj(), createdClientDto.getCpfCnpj());

    }

    @Test
    void whenClientIdInformedIsValidItShouldBeReturnClient() throws ClientNotFoundException {
        // given
        ClientDto expectedClientDto = ClientDtoBuilder.builder().build().toClientDto();
        Client expectedSavedClient = clientMapper.toModel(expectedClientDto);

        // when
        when(clientRepository.findById(expectedClientDto.getId())).thenReturn(Optional.of(expectedSavedClient));

        // then
        ClientDto returnedClient = clientService.getClientById(expectedClientDto.getId());

        assertEquals(expectedClientDto.getId(), returnedClient.getId());
        assertEquals(expectedClientDto.getName(), returnedClient.getName());
        assertEquals(expectedClientDto.getCpfCnpj(), returnedClient.getCpfCnpj());
    }

    @Test
    void whenExclusionIsCalledWithValidIdThenClientShouldBeDeleted() throws ClientNotFoundException {
        // given
        ClientDto expectedDeletedClientDto = ClientDtoBuilder.builder().build().toClientDto();
        Client expectedDeletedClient = clientMapper.toModel(expectedDeletedClientDto);

        // when
        when(clientRepository.findById(expectedDeletedClientDto.getId())).thenReturn(Optional.of(expectedDeletedClient));
        doNothing().when(clientRepository).deleteById(expectedDeletedClientDto.getId());

        // then
        clientService.deleteClientById(expectedDeletedClientDto.getId());

        verify(clientRepository, times(1)).findById(expectedDeletedClientDto.getId());
        verify(clientRepository, times(1)).deleteById(expectedDeletedClientDto.getId());

    }

    @Test
    void whenListClientIsCalledThenReturnAListOfClients(){
        // given
        ClientDto expectedFoundClientDto = ClientDtoBuilder.builder().build().toClientDto();
        Client expectedFoundClient = clientMapper.toModel(expectedFoundClientDto);

        // when
        when(clientRepository.findAll()).thenReturn(Collections.singletonList(expectedFoundClient));

        // then
        List<ClientDto> foundListClientsDto = clientService.getAllClients();

        assertThat(foundListClientsDto, is(not(empty())));

    }

    @Test
    void whenListClientIsCalledThenReturnAnEmptyListOfClients(){
        // when
        when(clientRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        // then
        List<ClientDto> foundListClientsDto = clientService.getAllClients();

        assertThat(foundListClientsDto.isEmpty(), is(true));

    }

    @Test
    void whenClientIdInformedIsInvalidThenThrowsException(){
        // when
        when(clientRepository.findById(ID_NOT_EXISTENT)).thenReturn(Optional.empty());

        // then
        assertThrows(ClientNotFoundException.class,
                ()-> clientService.verifyIfExists(ID_NOT_EXISTENT),
                String.format("Client with ID %s not found", ID_NOT_EXISTENT));
    }




}