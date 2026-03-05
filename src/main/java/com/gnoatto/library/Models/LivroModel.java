package com.gnoatto.library.Models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tb_livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    @Column(name = "titulo")
    String titulo;

    @Column(name = "autor")
    String autor;
    Integer anoPublicacao;

    public LivroModel(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
