package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SaleService {

    private final SaleRepository repository;

    public List<Sale> findAllSales(){

        return repository.findAll();
    }

    public void createSale(Sale sale) {
        repository.save(sale);
    }
}
