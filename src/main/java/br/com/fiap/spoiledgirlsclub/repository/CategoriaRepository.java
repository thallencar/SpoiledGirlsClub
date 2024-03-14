package br.com.fiap.spoiledgirlsclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spoiledgirlsclub.controller.CarrinhoController;

public interface CategoriaRepository extends JpaRepository<CarrinhoController, Long>{
    
}
