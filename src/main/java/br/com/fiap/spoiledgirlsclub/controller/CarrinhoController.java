package br.com.fiap.spoiledgirlsclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import br.com.fiap.spoiledgirlsclub.model.ItemVenda;
import br.com.fiap.spoiledgirlsclub.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Carrinho")
@Slf4j
public class CarrinhoController {

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<ItemVenda> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemVenda create(@RequestBody ItemVenda roupa){ 
        log.info("cadastrando roupa {}", roupa );
        repository.save(roupa);
        return roupa;
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemVenda> show(@PathVariable Long id){
        log.info("buscando roupa com id {} ", id);

        var categoriaEncontrada = repository.findById(id);


        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(categoriaEncontrada.get());

    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("apagando categoria {}", id);

        var categoriaEncontrada = repository.findById(id);

        if (categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(categoriaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

}
