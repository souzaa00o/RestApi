package com.example.JPA2.repositorios;

import com.example.JPA2.dominios.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    /*

         @Query -> para queries personalizadas -> usa a syntax da linguagem JPQL (Java Persistence Query Language)
         JPQL é orientada a objeto, por isso devemos usar os nomes das Classes e seus atributos, e não usar os nome de tabelas e colunas

     */

    @Query("select p from Produto p where p.preco > ?1")    // "?1" -> CHAMADA DE PARAMETRO -> o JPQL nos permite configurar os parametros que sera declarado na linha abaixo, nessa linha nos estamos solicitando o primeiro parametro, por isso ?"1", a chamada de parametros acontece de forma crescente: ?1, ?2, ?3... (primeiro parametro, segundo parametro, terceiro parametro...)
    List<Produto> pesquisarPorPrecoMaiorQue(Double preco);  // "(Double preco)" -> DECLARAÇAO DE PARAMETRO -> o atributo preco foi passado como primeiro e unico parametro, por isso na linha acima, chamamos ele de "?1"
}
