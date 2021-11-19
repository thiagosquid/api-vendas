package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.dtos.mappers.ClientMapper;
import com.smsolucoes.apivendas.dtos.requests.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientDto> getAllClients(){
        List<Client> allClients = clientRepository.findAll();

        return allClients.stream().map(client -> ClientMapper.INSTANCE.toDto(client))
                .collect(Collectors.toList());
    }

    public ClientDto createClient(ClientDto clientDto) {

        Client clientToSave = ClientMapper.INSTANCE.toModel(clientDto);

        return ClientMapper.INSTANCE.toDto(clientRepository.save(clientToSave));

    }

    public void deleteClientById(Long id) throws ClientNotFoundException {

        verifyIfExists(id);
        clientRepository.deleteById(id);

    }

    public ClientDto getClientById(Long id) throws ClientNotFoundException {
        ClientDto clientDto = verifyIfExists(id);

        return clientDto;
    }

    public ClientDto updateClient(Long id, ClientDto clientDto) throws ClientNotFoundException {

        verifyIfExists(id);

        clientDto.setId(id);
        Client client = ClientMapper.INSTANCE.toModel(clientDto);

        return ClientMapper.INSTANCE.toDto(clientRepository.save(client));

    }

    public ClientDto verifyIfExists(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id).orElseThrow(()-> new ClientNotFoundException(id.intValue()));
        return ClientMapper.INSTANCE.toDto(client);

    }

}
