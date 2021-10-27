package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.dtos.mapper.ClientMapper;
import com.smsolucoes.apivendas.dtos.request.ClientDto;
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

    private final ClientRepository repository;

    private final ClientMapper clientMapper;

    public List<ClientDto> getAllClients(){
        List<Client> allClients = repository.findAll();
        return allClients.stream().map((client)->{
            return clientMapper.toDTO(client);
        }).collect(Collectors.toList());

    }

    public Client createClient(ClientDto clientDto) {

        Client client = clientMapper.toModel(clientDto);

        return repository.save(client);

    }


    public void deleteClientById(Long id) throws ClientNotFoundException {

        verifyIfExists(id);
        repository.deleteById(id);

    }

    private Client verifyIfExists(Long id) throws ClientNotFoundException {

        return repository.findById(id).orElseThrow(()-> new ClientNotFoundException(id.intValue()));

    }

    public ClientDto getClientById(Long id) {
        Client clientFound = repository.getById(id);

        return clientMapper.toDTO(clientFound);
    }

    public ClientDto updateClient(Long id, ClientDto clientDto) throws ClientNotFoundException {

        verifyIfExists(id);

        clientDto.setId(id);
        Client clientToUpdate = clientMapper.toModel(clientDto);

        return clientMapper.toDTO(repository.save(clientToUpdate));


    }
}
