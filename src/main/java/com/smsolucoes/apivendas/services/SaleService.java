package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import com.smsolucoes.apivendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    public SaleService() {
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();

    }

    public Sale createSale(long id, Sale saleToSave) {

        saleToSave.setClient(clientRepository.getById(id));
        Sale saleSaved = saleRepository.save(saleToSave);

        return saleSaved;
    }

    public Sale getSaleById(Long id) {

        return saleRepository.getById(id);
    }
}
