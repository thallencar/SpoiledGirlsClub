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
@RequestMapping("cadastroPecas")
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
    public Cadastro create(@RequestBody @Valid Cadastro usuario){ 
        log.info("cadastrando usuário {}", usuario );
        repository.save(usuario);
        return usuario;
    }

    @GetMapping("{email}")
    public ResponseEntity<Cadastro> show(@PathVariable String email){
        log.info("buscando usuatio com email {} ", email);

        return repository
            .findByEmail(email)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{email}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable String email){
        log.info("apagando usuario {}", email);

        verificarSeItemExiste(email);
        repository.deleteByEmail(email);
    }

    @PutMapping("{email}")
    public Cadastro update(
        @PathVariable String email, @RequestBody Cadastro cadastro){
        log.info("atualizando usuario {} para {}", email, cadastro);

        verificarSeItemExiste(email);
        cadastro.setEmail(email);
        return repository.save(cadastro);
    }

    private void verificarSeItemExiste(String email) {
        repository
                .findByEmail(email)
                .orElseThrow(
                        () -> new ResponseStatusException( NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }
    
}
