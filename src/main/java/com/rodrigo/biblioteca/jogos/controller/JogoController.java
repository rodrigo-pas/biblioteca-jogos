package com.rodrigo.biblioteca.jogos.controller;

import com.rodrigo.biblioteca.jogos.model.Jogo;
import com.rodrigo.biblioteca.jogos.repository.JogoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoRepository repository;

    public JogoController(JogoRepository repository) {
        this.repository = repository;
    }

    // GET /jogos – Lista todos os jogos
    @GetMapping
    public List<Jogo> listarTodos() {
        return repository.findAll();
    }

    // GET /jogos/{id} – Busca jogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        Optional<Jogo> jogo = repository.findById(id);
        return jogo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /jogos – Cadastra novo jogo
    @PostMapping
    public ResponseEntity<Jogo> cadastrar(@Valid @RequestBody Jogo jogo) {
        Jogo salvo = repository.save(jogo);
        return ResponseEntity.status(201).body(salvo);
    }

    // PUT /jogos/{id} – Atualiza um jogo
    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @Valid @RequestBody Jogo novoJogo) {
        return repository.findById(id)
                .map(jogo -> {
                    jogo.setNome(novoJogo.getNome());
                    jogo.setPlataforma(novoJogo.getPlataforma());
                    jogo.setFinalizado(novoJogo.isFinalizado());
                    jogo.setNota(novoJogo.getNota());
                    jogo.setDataCompra(novoJogo.getDataCompra());
                    return ResponseEntity.ok(repository.save(jogo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /jogos/{id} – Remove um jogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}