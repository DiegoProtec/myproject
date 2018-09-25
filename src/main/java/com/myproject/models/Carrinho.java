package com.myproject.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CarrinhoID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false)
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false)
    private Compra compra;

    @Column(name = "data")
    private LocalDate data;

    private Carrinho() {
    }

    Carrinho(Livro livro, Compra compra) {
        this.livro = livro;
        this.compra = compra;
        this.id = new CarrinhoID(livro.getId(), compra.getId());
    }

    public CarrinhoID getId() {
        return id;
    }

    public void setId(CarrinhoID id) {
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
