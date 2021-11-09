package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.dtos.response.MessageResponseDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientsController {

    @Autowired
    ClientService service;


    @GetMapping
    public List<Client> getAll(){

        return service.getAllClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Client getById(@PathVariable Long id){
        return service.getClientById(id);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Valid Client client){

        Client clientSaved = service.createClient(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clientSaved.getId())
                .toUri();

        MessageResponseDto messageResponseDto = createMessageResponse("Client successfully created whit ID: ", clientSaved.getId());

        return ResponseEntity.created(uri).body(messageResponseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) throws ClientNotFoundException {
        service.deleteClientById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client updateClient(@PathVariable Long id, @RequestBody @Valid Client clientDto) throws ClientNotFoundException {

        return service.updateClient(id, clientDto);

    }

    private MessageResponseDto createMessageResponse(String s, Long id) {

        return MessageResponseDto.builder().message(s + id).build();

    }

}
