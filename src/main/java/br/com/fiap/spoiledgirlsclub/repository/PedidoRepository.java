package br.com.fiap.spoiledgirlsclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spoiledgirlsclub.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}
