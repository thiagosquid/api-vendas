package com.smsolucoes.apivendas.controllers;

import com.smsolucoes.apivendas.dtos.requests.SaleDto;
import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.exceptions.SaleNotFoundException;
import com.smsolucoes.apivendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class SalesController {

    @Autowired
    SaleService saleService;

    @GetMapping
    public List<SaleDto> getAllSales(){

        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public SaleDto getSaleById(@PathVariable Long id){
        return saleService.getSaleById(id);
    }

    @GetMapping("/prazo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deliveryTime(@PathVariable Long id) throws SaleNotFoundException {
        return saleService.deliveryTimeToSale(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSaleById(@PathVariable Long id) throws SaleNotFoundException {
        saleService.deleteById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleDto createSale(@PathVariable Long id, @RequestBody SaleDto saleDto) throws ClientNotFoundException {
        return saleService.createSale(id, saleDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public SaleDto updateSale(@PathVariable Long id, @RequestBody List<Long> productsIds) throws SaleNotFoundException {
        return saleService.updateSale(id, productsIds);
    }
}
