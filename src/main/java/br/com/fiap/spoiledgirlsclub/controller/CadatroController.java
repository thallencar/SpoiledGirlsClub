package br.com.fiap.spoiledgirlsclub.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.hibernate.validator.cfg.context.Cascadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.spoiledgirlsclub.model.Cadastro;
import br.com.fiap.spoiledgirlsclub.model.ItemVenda;
import br.com.fiap.spoiledgirlsclub.repository.CadastroRepository;
import br.com.fiap.spoiledgirlsclub.repository.ItemVendaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("cadastroUsuario")
@Slf4j
public class CadatroController {

     @Autowired
    CadastroRepository repository;

    @GetMapping
    public List<Cadastro> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Cadastro create(@RequestBody @Valid Cadastro cadastro){ 
        log.info("cadastrando usuário {}", cadastro );
        repository.save(cadastro);
        return cadastro;
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("buscando cadastro com id {} ", id);

        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando usuário {}", id);

        verificarSeItemExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Cadastro update(
        @PathVariable Long id, @RequestBody Cadastro cadastro){
        log.info("atualizando usuário {} para {}", id, cadastro);

        verificarSeItemExiste(id);
        cadastro.setId(id);
        return repository.save(cadastro);
    }

    private void verificarSeItemExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException( NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }
    
}
