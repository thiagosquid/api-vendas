package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.services.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {

    private final SaleService service;

    public SalesController(SaleService salesService) {
        this.service = salesService;
    }

    @GetMapping
    public List<Sale> getAll(){
        return service.findAllSales();
    }

    @PostMapping
    public void createSale(Sale sale){
        service.createSale(sale);
    }
}
