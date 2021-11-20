package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.dtos.mappers.ClientMapper;
import com.smsolucoes.apivendas.dtos.mappers.SaleMapper;
import com.smsolucoes.apivendas.dtos.requests.SaleDto;
import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.entities.Sale;
import com.smsolucoes.apivendas.exceptions.ClientNotFoundException;
import com.smsolucoes.apivendas.exceptions.SaleNotFoundException;
import com.smsolucoes.apivendas.repositories.ClientRepository;
import com.smsolucoes.apivendas.repositories.ProductRepository;
import com.smsolucoes.apivendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductRepository productRepository;

    private final SaleMapper saleMapper = SaleMapper.INSTANCE;

    public List<SaleDto> getAllSales(){
        return saleRepository.findAll().stream().map(sale -> saleMapper.toDto(sale))
                .collect(Collectors.toList());
    }

    public SaleDto getSaleById(Long id) {
        return saleMapper.toDto(saleRepository.getById(id));
    }

    public void deleteById(Long id) throws SaleNotFoundException {
        verifyIfExists(id);

        saleRepository.deleteById(id);
    }

    public SaleDto createSale(Long id, SaleDto saleToSave) throws ClientNotFoundException {

        saleToSave.setClient(ClientMapper.INSTANCE.toModel(clientService.verifyIfExists(id)));
        Sale saleSaved = saleRepository.save(saleMapper.toModel(saleToSave));

        return saleMapper.toDto(saleSaved);
    }

    public SaleDto updateSale(Long id, List<Long> productsIds) throws SaleNotFoundException {
        Sale saleToUpdate = verifyIfExists(id);

        List<Product> productList = productRepository.findAllById(productsIds);

        saleToUpdate.setProducts(productList);

        return saleMapper.toDto(saleRepository.save(saleToUpdate));

    }

    private Sale verifyIfExists(Long id) throws SaleNotFoundException {

        return saleRepository.findById(id).orElseThrow(()-> new SaleNotFoundException(id));

    }

    public String deliveryTimeToSale(Long id) throws SaleNotFoundException {

        Sale sale = verifyIfExists(id);
        LocalDate deadline = sale.getDate();
        deadline = deadline.plusDays(10L);
        String dateStr = deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "O prazo de entrega da venda nº " + sale.getId() + " é até o dia " + dateStr;
    }
}
