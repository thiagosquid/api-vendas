package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.dtos.mapper.SaleMapper;
import com.smsolucoes.apivendas.dtos.request.SaleDto;
import com.smsolucoes.apivendas.entities.Client;
import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import com.smsolucoes.apivendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleMapper saleMapper;

    @Autowired
    ClientRepository clientRepository;

    public SaleService() {
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();

    }

    public SaleDto createSale(long id, SaleDto saleDto) {

        Sale saleToSave = saleMapper.toModel(saleDto);

        Client client = clientRepository.getById(id);
        saleToSave.setClient(client);
        Sale saleSaved = saleRepository.save(saleToSave);

        return saleMapper.toDTO(saleSaved);
    }

    public SaleDto getSaleById(Long id) {

        return saleMapper.toDTO(saleRepository.getById(id));
    }
}
