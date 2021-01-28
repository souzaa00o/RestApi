package com.example.JPA1.repositorios;

import com.example.JPA1.dominios.Praia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
       A PraiaRepository criada como interface, é reponsavel por transformar as classes em tabelas do banco
 */
public interface PraiaRepository extends CrudRepository<Praia, Integer> {       // O extends herda o CrudRepository que e uma dependencia com funçoes de banco de dados  /   seguido do nome da classe/entidade "Praia" e o tipo da primary key "Integer"

}
