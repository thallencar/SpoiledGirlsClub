package br.com.fiap.spoiledgirlsclub.model;
import lombok.Data;

import java.math.BigDecimal;

import br.com.fiap.spoiledgirlsclub.validation.Tamanho;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@Entity
@NotBlank
public class ItemVenda {
   

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 10, max = 150)
    private String nome;
    @Positive
    private Integer qtd;
    @Positive
    private BigDecimal preco;
    @Tamanho
    private String tamanho;
    @Size(min = 10, max = 150)
    private String descricao;
              
}
