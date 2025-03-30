package com.example.crudlivro.mapper;

import com.example.crudlivro.dto.LivroDTO;
import com.example.crudlivro.dto.CriarLivroDTO;
import com.example.crudlivro.dto.AtualizarLivroDTO;
import com.example.crudlivro.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {
    
    public LivroDTO paraDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setDescricao(livro.getDescricao());
        dto.setPreco(livro.getPreco());
        dto.setQuantidadeEstoque(livro.getQuantidadeEstoque());
        return dto;
    }
    
    public Livro paraEntidade(CriarLivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setDescricao(dto.getDescricao());
        livro.setPreco(dto.getPreco());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        return livro;
    }
    
    public void atualizarEntidade(Livro livro, AtualizarLivroDTO dto) {
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setDescricao(dto.getDescricao());
        livro.setPreco(dto.getPreco());
        livro.setQuantidadeEstoque(dto.getQuantidadeEstoque());
    }
} 