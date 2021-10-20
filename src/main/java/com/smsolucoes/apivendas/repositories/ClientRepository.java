package com.smsolucoes.apivendas.repositories;

import com.smsolucoes.apivendas.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
