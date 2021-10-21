package com.smsolucoes.apivendas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

//    @ManyToMany
//    private List<Product> productList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

}
