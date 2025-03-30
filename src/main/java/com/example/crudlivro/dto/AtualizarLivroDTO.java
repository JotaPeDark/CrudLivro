package com.example.crudlivro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class AtualizarLivroDTO {
    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    
    @NotBlank(message = "O autor é obrigatório")
    private String autor;
    
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser positivo")
    private BigDecimal preco;
    
    @NotNull(message = "A quantidade em estoque é obrigatória")
    @Positive(message = "A quantidade em estoque deve ser positiva")
    private Integer quantidadeEstoque;
} 