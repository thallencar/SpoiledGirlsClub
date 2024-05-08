package br.com.fiap.spoiledgirlsclub.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.spoiledgirlsclub.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

    Page<Cadastro> findByEmail(String email, Pageable pageable);
    
}
