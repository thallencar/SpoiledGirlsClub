package br.com.fiap.spoiledgirlsclub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spoiledgirlsclub.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

    Optional<Cadastro> findByEmail(String email);

    void deleteByEmail(String email);

    
}
