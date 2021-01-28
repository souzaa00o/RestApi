package com.example.JPA1.dominios;

import javax.persistence.Entity;
import javax.persistence.Id;
/*
    @Entity: A classe tageada com @Entity vira uma entidade de banco de dados
   ORM (Object Relational Mapping)
 */

@Entity
public class Praia {

    @Id     // Id e primary key da tabela
    private Integer id;

    private String nome;
    private Double tamanho;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getTamanho() {
        return tamanho;
    }
}
