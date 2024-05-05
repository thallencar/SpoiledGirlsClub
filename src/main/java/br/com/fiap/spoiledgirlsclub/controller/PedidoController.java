package br.com.fiap.spoiledgirlsclub.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.spoiledgirlsclub.model.Pedido;
import br.com.fiap.spoiledgirlsclub.repository.PedidoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("Carrinho")
@Slf4j
public class PedidoController {
    
    @Autowired
    PedidoRepository repository;

    @GetMapping
    public List<Pedido> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Pedido create(@RequestBody @Valid Pedido pedido){ 
        log.info("cadastrando pedido {}", pedido);
        repository.save(pedido);
        return pedido;
    }

     @GetMapping("{id}")
    public ResponseEntity<Pedido> show(@PathVariable Long id){
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

        verificarSePedidoExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Pedido update(
        @PathVariable Long id, @RequestBody Pedido pedido){
        log.info("atualizando pedido {} para {}", id, pedido);

        verificarSePedidoExiste(id);
        pedido.setId(id);
        return repository.save(pedido);
    }

    private void verificarSePedidoExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException( NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }
    
}
