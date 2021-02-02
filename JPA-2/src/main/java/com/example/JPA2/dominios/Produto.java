package com.example.JPA2.dominios;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO INCREMENT ID
    private Integer codProduto;

    @Column(nullable = false, length = 30)  // @Column transforma a variavel em coluna "nullable = false, length = 30" representa que o atributo nao pode receber valor nulo de ate 30 caracteres
    private String nome;

    @Column(nullable = false, length = 10)
    private String unidade;

    @Column(name = "preco_produto")  // indica que na tabela o "name" é igual a "preco_produto"
    private Double preco;


    public Produto(String nome, String unidade, Double preco) {     // construtor sem codProduto
        this.nome = nome;
        this.unidade = unidade;
        this.preco = preco;
    }


    public Produto() {  //construtor none
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public String getNome() {
        return nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public Double getPreco() {
        return preco;
    }
}
