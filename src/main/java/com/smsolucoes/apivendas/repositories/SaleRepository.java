package com.smsolucoes.apivendas.repositories;

import com.smsolucoes.apivendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    public Sale getById(Long id);
}
