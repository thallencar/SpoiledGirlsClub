package br.com.fiap.spoiledgirlsclub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.List;

import br.com.fiap.spoiledgirlsclub.model.Cadastro;
import br.com.fiap.spoiledgirlsclub.repository.CadastroRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{

    @Autowired
    CadastroRepository cadastro;
    @Override
    public void run(String... args) throws Exception {
        cadastro.saveAll(List.of(
            Cadastro.builder().id(1L).email("isabelle@spoiledgirlsclub.com").senha("123").build(),
            Cadastro.builder().id(2L).email("marina@spoiledgirlsclub.com").senha("123").build(),
            Cadastro.builder().id(3L).email("thalita@spoiledgirlsclub.com").senha("123").build()
        ));
    }
    
}
