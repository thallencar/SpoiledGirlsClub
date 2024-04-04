package br.com.fiap.spoiledgirlsclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import br.com.fiap.spoiledgirlsclub.model.ItemVenda;
import br.com.fiap.spoiledgirlsclub.repository.ItemVendaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("Carrinho")
@Slf4j
public class ItemVendaController {

    @Autowired
    ItemVendaRepository repository;

    @GetMapping
    public List<ItemVenda> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ItemVenda create(@RequestBody @Valid ItemVenda roupa){ 
        log.info("cadastrando roupa {}", roupa );
        repository.save(roupa);
        return roupa;
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemVenda> show(@PathVariable Long id){
        log.info("buscando roupa com id {} ", id);

        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando categoria {}", id);

        verificarSeCategoriaExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public ItemVenda update(
        @PathVariable Long id, @RequestBody ItemVenda itemVenda){
        log.info("atualizando item venda {} para {}", id, itemVenda);

        verificarSeCategoriaExiste(id);
        itemVenda.setId(id);
        return repository.save(itemVenda);
    }

    private void verificarSeCategoriaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException( NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }

}
