package com.myproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CarrinhoID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private Livro livro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, insertable = false, updatable = false)
    private Compra compra;

    @NotNull
    @Column(name = "data", nullable = false)
    private LocalDate data;

    private Carrinho() {
    }

    Carrinho(@NotNull Livro livro, @NotNull Compra compra) {
        this.livro = livro;
        this.compra = compra;
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
