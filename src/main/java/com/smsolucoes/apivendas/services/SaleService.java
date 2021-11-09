package com.smsolucoes.apivendas.services;

import com.smsolucoes.apivendas.entities.Product;
import com.smsolucoes.apivendas.entities.Sale;
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

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public SaleService() {
    }

    public List<Sale> getAllSales(){
        return saleRepository.findAll();

    }

    public Sale getSaleById(Long id) {

        return saleRepository.getById(id);
    }

    public void deleteById(Long id) throws SaleNotFoundException {
        verifyIfExists(id);

        saleRepository.deleteById(id);
    }

    public Sale createSale(Long id, Sale saleToSave) {

        saleToSave.setClient(clientRepository.getById(id));
        Sale saleSaved = saleRepository.save(saleToSave);

        return saleSaved;
    }

    public Sale updateSale(Long id, List<Long> productsIds){
        Sale saleToUpdate = saleRepository.getById(id);

        List<Product> productList = productRepository.findAllById(productsIds);

        saleToUpdate.setProducts(productList);

        return saleRepository.save(saleToUpdate);

    }

    private Sale verifyIfExists(Long id) throws SaleNotFoundException {

        return saleRepository.findById(id).orElseThrow(()-> new SaleNotFoundException(id));

    }

    public String deliveryTimeToSale(Long id) {
        Sale sale = saleRepository.getById(id);
        LocalDate deadline = sale.getDate();
        deadline = deadline.plusDays(10L);
        String dateStr = deadline.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "O prazo de entrega da venda nº " + sale.getId() + " é até o dia " + dateStr;
    }
}
