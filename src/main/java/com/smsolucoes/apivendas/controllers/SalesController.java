package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    @Autowired
    SaleService service;

    @GetMapping
    public List<Sale> getAllSales(){

        return service.getAllSales();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Sale getSaleById(@PathVariable Long id){
        return service.getSaleById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Sale createSale(@PathVariable long id, @RequestBody Sale sale){
        return service.createSale(id, sale);
    }
}
