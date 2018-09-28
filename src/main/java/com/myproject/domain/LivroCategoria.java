package com.myproject.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "livro_categoria")
public class LivroCategoria implements Serializable {

    public static final long serialVersionUID = 1L;

    @EmbeddedId
    private IDLivroAutor id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private Categoria categoria;

    public LivroCategoria() {
    }

    public LivroCategoria(Livro livro, Categoria categoria) {
        this.livro = livro;
        this.categoria = categoria;
    }

    public IDLivroAutor getId() {
        return id;
    }

    public void setId(IDLivroAutor id) {
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