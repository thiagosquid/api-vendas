package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository repository;

    public List<Client> getAllClients(){

        return repository.findAll();

    }

    public void createClient(Client client) {

        repository.save(client);

    }
}
