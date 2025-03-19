package com.example.crudlivro.service;

import com.example.crudlivro.model.Livro;
import com.example.crudlivro.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    @Transactional(readOnly = true)
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado com ID: " + id));
    }

    @Transactional
    public Livro criar(Livro livro) {
        return livroRepository.save(livro);
    }

    @Transactional
    public Livro atualizar(Long id, Livro livro) {
        Livro livroExistente = buscarPorId(id);
        livro.setId(livroExistente.getId());
        return livroRepository.save(livro);
    }

    @Transactional
    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new EntityNotFoundException("Livro não encontrado com ID: " + id);
        }
        livroRepository.deleteById(id);
    }
} 