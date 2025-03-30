package com.example.crudlivro.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
} 