package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    @Autowired
    SaleService service;

    @GetMapping
    public ResponseEntity<List<Sale>> getAll(){
        List<Sale> allSales = service.findAllSales();
        return ResponseEntity.ok().body(allSales);
    }

    @PostMapping
    public void createSale(Sale sale){
        service.createSale(sale);
    }
}
