package com.rodrigo.biblioteca.jogos.repository;

import com.rodrigo.biblioteca.jogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}