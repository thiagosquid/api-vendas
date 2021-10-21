package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void createClient(@RequestBody Client client){
        service.createClient(client);
    }

}
