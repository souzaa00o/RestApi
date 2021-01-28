package com.example.JPA1.controladores;

import com.example.JPA1.dominios.Praia;
import com.example.JPA1.repositorios.PraiaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praias")
public class PraiaController {

    @Autowired  // Para instanciar em tempo de execução o PraiaRepository que não é uma classe e sim uma interface
    private PraiaRepository repository;

    Praia praia = new Praia();

    @GetMapping
    public ResponseEntity getPraia() {
      if(repository.count() > 0) {      // .count() -> O Count faz um select count na tabela -> (metodo do CrudRepository)
          return ResponseEntity.ok(repository.findAll());
      } else{
          return ResponseEntity.noContent().build();
      }
    }

//    @GetMapping
//    public ResponseEntity getRepository() {
//        return ResponseEntity.ok(repository.findAll());     // Retorna ok e da um findAll (função do CrudRepository criada em PraiaRepository)no repository, printa todos os dados que encontrar
//    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Praia novaPraia){
        repository.save(novaPraia);     // O save (função do CrudRepository criada em PraiaRepository) faz primeiro um select, para ver se o Id ja existe, apos o select e feito insert ou update, ele salva na tabela   /  obs: caso o auto_increment não esteja em uso
        return ResponseEntity.created(null).build();
     }

    @GetMapping("/{id}")
    public ResponseEntity getPraia(@PathVariable int id) {
        if(repository.existsById(id)) {     // .existsById(id) -> A função verifica a se o ID passado na URI é verdadeiro -> (metodo do CrudRepository)
            return ResponseEntity.ok(repository.findById(id).get());  // findById(id) ->  Retorna o corpo da requisição com o id igual ao digitado na URI -> (metodo do CrudRepository)
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPraia(@PathVariable int id) {
        if (repository.existsById(id)){
            repository.deleteById(id);      // deleteById(id) -> Deleta por Id passado na URI -> (metodo do CrudRepository)
            return ResponseEntity.ok().build();     // Apenas o ".build()" pois não ira retornar corpo
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
