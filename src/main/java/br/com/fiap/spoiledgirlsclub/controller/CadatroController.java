package br.com.fiap.spoiledgirlsclub.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.spoiledgirlsclub.model.Cadastro;
import br.com.fiap.spoiledgirlsclub.repository.CadastroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Cadastro")
@Slf4j
@CacheConfig(cacheNames = "cadastro")
@Tag(name = "Cadastro")
public class CadatroController {

     @Autowired
    CadastroRepository repository;

    @GetMapping("/")
    @Cacheable
    @Operation(summary = "Listar Cadastros",
                description= "Retorna um Array com os usuários cadastrados")
    public List<Cadastro> index(){
        return repository.findAll();
    }

    @GetMapping("/filtro")
    @Operation(summary = "Listar Cadastros com Filtros e Ordenações",
                description= "Retorna um Array com os usuários cadastrados de acordo com o filtro imposto")
    public Page<Cadastro> index(@ParameterObject @PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable,
                                @RequestParam(required = false) String email){  
                                    
        if(email != null){
            return repository.findByEmail(email,pageable);
        }
        return repository.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cadastro criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Validação falhou. Verifique o corpo da requisição")
    })
    @Operation(summary = "Cadastrar usuário")
    public Cadastro create(@RequestBody @Valid Cadastro cadastro){ 
        log.info("cadastrando usuário {}", cadastro );
        repository.save(cadastro);
        return cadastro;
    }

    @GetMapping("{id}")
    @Operation(summary = "Lista o cadastro com o id buscado")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("buscando cadastro com id {} ", id);

        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(summary = "Apagar Roupas")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Usuário apagada com sucesso"),
        @ApiResponse(responseCode = "401", description = "Não autenticado. Se autentique em /InformacoesPerfis"),
        @ApiResponse(responseCode = "404", description = "Não existe usuário com o id informado")
    })
    public void destroy(@PathVariable Long id){
        log.info("apagando usuário {}", id);

        verificarSeItemExiste(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    @CacheEvict(allEntries = true)
    @Operation(summary = "Atualizar Informações sobre o usuário")
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
