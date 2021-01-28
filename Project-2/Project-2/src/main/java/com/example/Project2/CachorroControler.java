package com.example.Project2;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//CRUD

@RestController
@RequestMapping("/cachorros")
public class CachorroControler {

    private List<Cachorro> cachorros = new ArrayList<>(); //instance lista cachorros do tipo Cachorro

    @GetMapping("/listar")  //GET
    public List<Cachorro> getCachorros() {
        return cachorros;
    }

    @GetMapping("/listar/{id}") //GET BY ID
    public Cachorro getCachorro(@PathVariable int id){
        return cachorros.get(id-1); // Retorna os atributos do ID passado // -1 por conta das posições de vetor [0,1,2,3...]
    }

    // Metodo(POST)  // URI
         //v            v
    @PostMapping("/cadastrar")      // CREATE/POST
    public void cadastrarDog(@RequestBody Cachorro novoCachorro){   // O RequestBody faz uma requisição nos atributos do tipo Cachorro, passados no body em JSON via Postman e guarda os mesmos na variavel "novoCachorro"
                cachorros.add(novoCachorro);    // aqui a variavel novo cachorro é adicionada a lista cachorros, instanciada acima
    }

    @DeleteMapping("/excluir/{id}") // DELETE BY ID
    public void excluirCachorro(@PathVariable int id){  // Solicita o ID na URI para excluir por ID
         cachorros.remove(id-1);   // apaga os atributos do ID passado em URI   // -1 por conta das posições de vetor [0,1,2,3...]
    }

    @PutMapping("/atualizar/{id}")  // UPDATE BY ID
    public void atualizarCachorro(@PathVariable int id, @RequestBody Cachorro updateCachorro){ // Solicita o ID na URI e a variavel "updateCachorro" solicita os atributos via Json do tipo Cachorro
        cachorros.set(id-1, updateCachorro);  // Os atributos passados em Json via postman da variavel "updateCachorro", são setados no campo do id passado em URI    // -1 por conta das posições de vetor [0,1,2,3...]
    }

}
