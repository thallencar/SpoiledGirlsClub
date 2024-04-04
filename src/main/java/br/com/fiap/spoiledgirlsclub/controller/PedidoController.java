package br.com.fiap.spoiledgirlsclub.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.spoiledgirlsclub.model.Pedido;
import br.com.fiap.spoiledgirlsclub.repository.PedidoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("pedido")
public class PedidoController {
    
    @Autowired
    PedidoRepository respository;

    @GetMapping
    public List<Pedido> index(){
        return respository.findAll();
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public Pedido create(@RequestBody @Valid Pedido pedido) {   
        return respository.save(pedido); 
    }
    
}
