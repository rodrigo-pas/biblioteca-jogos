package com.rodrigo.biblioteca.jogos.controller;

import com.rodrigo.biblioteca.jogos.model.Jogo;
import com.rodrigo.biblioteca.jogos.repository.JogoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository repository;

    public JogoController(JogoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Jogo> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jogo> cadastrar(@Valid @RequestBody Jogo jogo) {
        return ResponseEntity.status(201).body(repository.save(jogo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @Valid @RequestBody Jogo dadosAtualizados) {
        return repository.findById(id)
                .map(jogo -> {
                    jogo.setNome(dadosAtualizados.getNome());
                    jogo.setPlataforma(dadosAtualizados.getPlataforma());
                    jogo.setFinalizado(dadosAtualizados.isFinalizado());
                    jogo.setNota(dadosAtualizados.getNota());
                    jogo.setDataCompra(dadosAtualizados.getDataCompra());
                    return ResponseEntity.ok(repository.save(jogo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}