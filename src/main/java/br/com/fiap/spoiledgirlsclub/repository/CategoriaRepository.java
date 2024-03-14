package br.com.fiap.spoiledgirlsclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spoiledgirlsclub.model.ItemVenda;

public interface CategoriaRepository extends JpaRepository<ItemVenda, Long>{
    
}
