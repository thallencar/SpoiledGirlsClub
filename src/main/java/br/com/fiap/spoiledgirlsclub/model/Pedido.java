package br.com.fiap.spoiledgirlsclub.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@NotBlank
public class Pedido {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 10, max = 150)
    private String nome;
    private String foto;
    @Positive
    private Double preco;
    private String tamanho;
    @PastOrPresent
    private LocalDate data;
    private String tipoFrete;
    @Positive
    private BigDecimal valorFrete;
    private int qtd;  
}
