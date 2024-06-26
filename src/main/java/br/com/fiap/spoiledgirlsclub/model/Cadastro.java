package br.com.fiap.spoiledgirlsclub.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cadastro {
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 1, max = 150)
    private String email;
    private String senha;
}
