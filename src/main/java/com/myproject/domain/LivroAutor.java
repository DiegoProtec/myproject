package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livro_autor")
public class LivroAutor implements Serializable {

    public static final long serialVersionUID = 1L;

    @EmbeddedId
    private IDLivroAutor id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Autor autor;

    public LivroAutor() {
    }

    public LivroAutor(Livro livro, Autor autor) {
        this.livro = livro;
        this.autor = autor;
        this.id = new IDLivroAutor(livro.getId(), autor.getId());
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
