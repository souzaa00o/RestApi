package com.example.JPA2.controladores;

import com.example.JPA2.dominios.Produto;
import com.example.JPA2.repositorios.ProdutoRepository;
import org.apache.coyote.Response;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.BeanCreationException;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity criar(@RequestBody Produto novoProduto){
        repository.save(novoProduto);
        return ResponseEntity.created(null).build();
    }

    /*
        @RequestParam -> programa os parametros de requisição passados após URI
        O primeiro parametro vem depois do ponto de interrogação "?"
        E os seguintes, apos "&",

        (required = false) -> indica que o parametro NÃO é obrigatório
     */
    @GetMapping
    public ResponseEntity pesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String unidade,
            @RequestParam(required = false) Double preco
    ){
      Produto produtoPesquisa = new Produto(nome, unidade, preco);

      /*
        findBy com Example.of -> a função example usa qualquer campo declados na URI (Parametros declarados acima com @RequestParam),
        os campos declarados na URI são usados de where no select.

        exemplo de parametro na URI -> "nome=<nome_do_item>" -> http://localhost:xxxx/xxx?unidade=pacote&preco=2.50 -> faz um get dos produtos que tem o valor "pacote" no atributo unidade e com "2.50" com valor de preco.
       */
      List<Produto> produtos = repository.findAll(Example.of(produtoPesquisa));

      if (produtos.isEmpty()){
          return ResponseEntity.noContent().build();
      } else{
            return ResponseEntity.ok(produtos);
      }
    }

    @GetMapping("/caros")
    public ResponseEntity listarCaros(){
        return ResponseEntity.ok(repository.pesquisarPorPrecoMaiorQue(6.0));
    }

}
