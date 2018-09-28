package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private IDCarrinho id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Compra compra;

    private Carrinho() {
    }

    Carrinho(Livro livro, Compra compra) {
        this.livro = livro;
        this.compra = compra;
        this.id = new IDCarrinho(livro.getId(), compra.getId());
    }

    public IDCarrinho getId() {
        return id;
    }

    public void setId(IDCarrinho id) {
        this.id = id;
    }

    Livro getLivro() {
        return livro;
    }

    void setLivro(Livro livro) {
        this.livro = livro;
    }

    Compra getCompra() {
        return compra;
    }

    void setCompra(Compra compra) {
        this.compra = compra;
    }

}
