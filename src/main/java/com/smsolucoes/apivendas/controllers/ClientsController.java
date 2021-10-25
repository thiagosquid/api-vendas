package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.dtos.ClientDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {

    private final ClientService service;

    public ClientsController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAll(){
        return service.getAllClients();
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientDto client){
        Client clientToSave = new Client();
        clientToSave.setName(client.getName());
        clientToSave.setCpfCnpj(client.getCpfCnpj());
        service.createClient(clientToSave);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientToSave.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clientToSave);
    }

}
