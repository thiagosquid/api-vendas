package com.smsolucoes.apivendas.repositories;

import com.smsolucoes.apivendas.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Client, Long> {

}
