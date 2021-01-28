package com.example.JPA1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(Jpa1Application.class, args);
	}

}


/*
	@DeleteMapping("/{id}")
    public ResponseEntity deletarPraia(@PathVariable int id) {
        if (repository.existsById(id)) {     // .existsById -> select count from praia where id=<ID PASSADO NA URI>
            repository.deleteById(id);      // deleteById(id) -> Deleta por Id passado na URI -> (metodo do CrudRepository)
            return ResponseEntity.ok().build();     // Apenas o ".build()" pois não ira retornar corpo
        }

 */