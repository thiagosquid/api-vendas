package com.smsolucoes.apivendas.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

//    @ManyToMany(cascade = {CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.PERSIST,
//            CascadeType.REFRESH})
//    @JoinTable(name = "sale_product",
//            joinColumns = @JoinColumn(name = "client_id"),
//            inverseJoinColumns = @JoinColumn(name = "products_id"))
//    private List<Product> products = new ArrayList<>();

}
