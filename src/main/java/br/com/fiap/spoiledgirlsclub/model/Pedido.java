package br.com.fiap.spoiledgirlsclub.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import br.com.fiap.spoiledgirlsclub.validation.Tamanho;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @PastOrPresent
    private LocalDate data;
    private String tipoFrete;
    @Positive
    private BigDecimal valorFrete;
    @Positive
    private BigDecimal valorTotal;
    @Positive
    private int qtd;  
    private String status;

    //um item de venda, pode esta presente em N pedidos 
    //1-N
    @ManyToOne
    private ItemVenda itemVenda;
}
