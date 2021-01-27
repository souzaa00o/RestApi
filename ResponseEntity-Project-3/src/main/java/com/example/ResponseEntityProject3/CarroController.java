package com.example.ResponseEntityProject3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@RestController
@RequestMapping("/carros")      //Todos EndPoints dessa controller se inicia com "/carros"
public class CarroController {

    private List<Carro> carros = new ArrayList<>();

    @GetMapping     // EndPoint chamado na "/carros" com o metodo GET
    public List<Carro> getCarros() {
        return carros;
    }

    @GetMapping("/{id}")
    public Carro recuperarCarro(@PathVariable int id){
        return carros.get(id-1);
    }

    @PostMapping        // EndPoint chamado na "/carros" com o metodo POST
    public void criarCarro(@RequestBody Carro novoCarro){
        carros.add(novoCarro);
    }

    @DeleteMapping("/{id}") // EndPoint chamado na "/carros" com o metodo DELETE
    public void excluirCarro(@PathVariable int id){
        carros.remove(id-1);
    }

    @GetMapping("/populares")
    public List<Carro> carrosPopulares(){
        List<Carro> carrosPopulares = carros.stream().filter(carro -> carro.getPreco() < 1000.0).collect(Collectors.toList());
        return carrosPopulares;     // Retorna lista carrosPopulares

        /*
        STREAM():
               O "stream()" foi criado para manipulação de listas,
               O parametro FILTER "filter(carro -> carro.getPreco() < 10000)", que ira filtrar essa lista por carros com o valor de getPreco < 10000,
               O parametro COLLECT ".collect(Collectors.toList())" que faz a coleta dos itens filtrados para a list "carrosPopulares"
               extra: O parametro .map(carro -> new carro.getModelo()), a função faz a coleta parametro "modelo" da classe.
               obs: O stream contem mais funçoes a serem exploradas.
         */
    }
}
