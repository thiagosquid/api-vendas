package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository repository;

    public List<Client> getAllClients(){
        List<Client> allClients = repository.findAll();
        return allClients;
    }

    public Client createClient(Client client) {

        return repository.save(client);

    }

    public void deleteClientById(Long id) throws ClientNotFoundException {

        verifyIfExists(id);
        repository.deleteById(id);

    }

    public Client getClientById(Long id) throws ClientNotFoundException {
        Client client = verifyIfExists(id);
        return client;
    }

    public Client updateClient(Long id, Client client) throws ClientNotFoundException {

        verifyIfExists(id);

        client.setId(id);

        return repository.save(client);

    }

    public Client verifyIfExists(Long id) throws ClientNotFoundException {

        return repository.findById(id).orElseThrow(()-> new ClientNotFoundException(id.intValue()));

    }

}
