package com.rodrigo.biblioteca.jogos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "A plataforma é obrigatória.")
    private String plataforma;

    private boolean finalizado = false;

    @Min(value = 0, message = "A nota mínima é 0.")
    @Max(value = 10, message = "A nota máxima é 10.")
    private Integer nota;

    private String dataCompra;

    // Getters e Setters (ou pode usar Lombok se quiser)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public boolean isFinalizado() { return finalizado; }
    public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public String getDataCompra() { return dataCompra; }
    public void setDataCompra(String dataCompra) { this.dataCompra = dataCompra; }
}
