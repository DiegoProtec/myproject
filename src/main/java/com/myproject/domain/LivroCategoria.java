package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "livro_categoria")
public class LivroCategoria implements Serializable {

    public static final long serialVersionUID = 1L;

    @EmbeddedId
    private IDLivroCategoria id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Categoria categoria;

    public LivroCategoria() {
    }

    public LivroCategoria(Livro livro, Categoria categoria) {
        this.livro = livro;
        this.categoria = categoria;
        this.id = new IDLivroCategoria(livro.getId(), categoria.getId());
    }

    public IDLivroCategoria getId() {
        return id;
    }

    public void setId(IDLivroCategoria id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}