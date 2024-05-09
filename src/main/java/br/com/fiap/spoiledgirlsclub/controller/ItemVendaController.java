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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("cadastroPecas")
@Slf4j
@Tag(name = "Peças")
public class ItemVendaController {

    @Autowired
    ItemVendaRepository repository;


    @GetMapping
    @Operation(summary = "Listar Roupas",
                description= "Retorna um Array com todas as roupas disponíveis para venda")
    public List<ItemVenda> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(summary = "Cadastrar Roupas")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cadastro criada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autenticado. Se autentique em /InformacoesPerfis")
    })
    public ItemVenda create(@RequestBody @Valid ItemVenda roupa){ 
        log.info("cadastrando roupa {}", roupa );
        repository.save(roupa);
        return roupa;
    }

    @GetMapping("{id}")
    @Operation(summary = "Listar a roupa com o id buscado")
    public ResponseEntity<ItemVenda> show(@PathVariable Long id){
        log.info("buscando roupa com id {} ", id);

        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(summary = "Apagar Roupas")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Roupa apagada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autenticado. Se autentique em /InformacoesPerfis"),
        @ApiResponse(responseCode = "404", description = "Não existe roupa com o id informado")
    })
    public void destroy(@PathVariable Long id){
        log.info("apagando categoria {}", id);

        verificarSeItemExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar Informações sobre as Roupas")
    public ItemVenda update(
        @PathVariable Long id, @RequestBody ItemVenda itemVenda){
        log.info("atualizando item venda {} para {}", id, itemVenda);

        verificarSeItemExiste(id);
        itemVenda.setId(id);
        return repository.save(itemVenda);
    }

    private void verificarSeItemExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException( NOT_FOUND,
                                "Não existe categoria com o id informado"));
    }

}
