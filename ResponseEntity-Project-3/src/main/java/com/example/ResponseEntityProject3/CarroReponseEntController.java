package com.example.ResponseEntityProject3;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
    O ResponseEntity é classe spring que representa as respostas das requisições http (ET/POST/DELETE...)
 */
@RestController
@RequestMapping("/carros")      //Todos EndPoints dessa controller se inicia com "/carros"
public class CarroReponseEntController {

    private List<Carro> carros = new ArrayList<>();

    @GetMapping     // EndPoint chamado na "/carros" com o metodo GET
    public ResponseEntity getCarros() {
        if(carros.isEmpty()){       //se a lista "carros" for vazia V
            return ResponseEntity.status(204).build();       // A aplicação retorna o codigo "204 - No content", indica que a requisição foi bem sucedida porem não tem conteudo a ser apresentado
        } else {                  // Se a lista não estiver vazia    V
            return ResponseEntity.status(200).body(carros);    // A aplicação retorna "200 - OK" codigo indica que a requisição foi feita com sucesso.
        }
    }

        /*

                RESPONSE ENTITY TIPO 1
                     VVVVVVVVV

        */
    @GetMapping("/{id}")
    public ResponseEntity recuperarCarro(@PathVariable int id){
        if (carros.size() >= id){        // Se o tamanho da lista de carros for maior ou igual ao parametro passado na variavel "id" via URI, vv
            return ResponseEntity.status(200).body(carros.get(id-1));       //  O Response code retorna "200 - OK"
        } else{     // SENÃO
            return ResponseEntity.status(404).build();      // Retorna "404 - NOT FOUND"
        }
    }

    @PostMapping        // EndPoint chamado na "/carros" com o metodo POST
    public ResponseEntity criarCarro(@RequestBody Carro novoCarro){
        carros.add(novoCarro);
        return ResponseEntity.status(201).build();  // "201 - Created" response code que informa a criação de um novo objeto
        // return ResponseEntity.created().build();
   }
        /*

                RESPONSE ENTITY TIPO 2
                       VVVVVVVV

        */
    @DeleteMapping("/{id}") // EndPoint chamado na "/carros" com o metodo DELETE
    public ResponseEntity excluirCarro(@PathVariable int id){       // metodo do tipo ResponseEntity
        if(carros.size() >= id){
            return ResponseEntity.ok().body(carros.remove(id-1));      // Uma alternativa do ResponseEntity e escrever o Response Code esperado na propria linha de codigo, inves de passar o numero como o exemplo comentado abaixo
            //return ResponseEntity.status(200).body(carros.remove(id-1));  //  <<<<<<<<<<<<<<
        } else {            // senao
            return ResponseEntity.notFound().build();        // Apontando o Response code como ".notFound()"
            //return ResponseEntity.status(404).build();   // Apontando como ".status(404)"
        }
    }

    @GetMapping("/populares")
    public ResponseEntity carrosPopulares(){
        List<Carro> carrosPopulares = carros.stream().filter(carro -> carro.getPreco() < 1000.0).collect(Collectors.toList());
        if(carrosPopulares.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carrosPopulares);
        }

    }
}
