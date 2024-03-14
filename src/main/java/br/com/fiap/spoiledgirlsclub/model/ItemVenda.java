package br.com.fiap.spoiledgirlsclub.model;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class ItemVenda {
   

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeropedido;
    private Integer qtd;
    private Double preco;
    private String tamanho;
    private String descricao;

    
    
                
}
