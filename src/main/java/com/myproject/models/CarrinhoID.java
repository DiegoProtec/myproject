package com.myproject.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CarrinhoID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "livro_id")
    private Long livro_id;

    @Column(name = "compra_id")
    private Long compra_id;

    public CarrinhoID() {}

    CarrinhoID(Long livro_id, Long compra_id) {
        this.livro_id = livro_id;
        this.compra_id = compra_id;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Long getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(Long compra_id) {
        this.compra_id = compra_id;
    }
}