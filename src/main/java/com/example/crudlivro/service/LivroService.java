package com.example.crudlivro.service;

import com.example.crudlivro.dto.LivroDTO;
import com.example.crudlivro.dto.CriarLivroDTO;
import com.example.crudlivro.dto.AtualizarLivroDTO;
import com.example.crudlivro.mapper.LivroMapper;
import com.example.crudlivro.model.Livro;
import com.example.crudlivro.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    @Transactional(readOnly = true)
    public List<LivroDTO> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(livroMapper::paraDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LivroDTO buscarPorId(Long id) {
        return livroRepository.findById(id)
                .map(livroMapper::paraDTO)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado com ID: " + id));
    }

    @Transactional
    public LivroDTO criar(CriarLivroDTO dto) {
        Livro livro = livroMapper.paraEntidade(dto);
        return livroMapper.paraDTO(livroRepository.save(livro));
    }

    @Transactional
    public LivroDTO atualizar(Long id, AtualizarLivroDTO dto) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado com ID: " + id));
        
        livroMapper.atualizarEntidade(livroExistente, dto);
        return livroMapper.paraDTO(livroRepository.save(livroExistente));
    }

    @Transactional
    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new EntityNotFoundException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }
} 