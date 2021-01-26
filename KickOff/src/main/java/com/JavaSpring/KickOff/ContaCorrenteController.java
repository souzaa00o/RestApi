package com.JavaSpring.KickOff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/conta")       // O @RequestMapping obriga todas as URIs da aplicaçao se inicie com /conta
public class ContaCorrenteController {

    private Double saldo = 0.0;
    private Integer saques = 0;
    private Integer depositos = 0;

    @GetMapping("/saldo")       // para acessar a URI, localhost:<PORT>/conta/saldo
    public Double getSaldo(){
        return saldo;
    }

    @GetMapping("/depositar/{value}")       // URI com PathParam
    public void depositar(@PathVariable double value){  // O PathVariable utiliza o valor digitado na URI para realizar a operação
            saldo += value;
            depositos ++;
    }
    @GetMapping("/sacar/{value}")
    public void sacar(@PathVariable double value){
        if (saldo > 0){
            saldo -= value;
            saques ++;
        }
    }
    @GetMapping("/transacoes")
    public String getTransfers(){   //RETURN STRING
        return String.format("Você fez %d saques e %d depositos", saques, depositos);
    }

}
