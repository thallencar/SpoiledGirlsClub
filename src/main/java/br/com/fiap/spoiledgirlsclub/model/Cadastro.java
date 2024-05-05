package br.com.fiap.spoiledgirlsclub.model;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Entity
@NotBlank
public class Cadastro {
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, max = 150)
    private String email;
    private String senha;
}
