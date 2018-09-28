package com.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IDLivroCategoria implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "livro_id")
    private Long livro_id;

    @Column(name = "categoria_id")
    private Long categoria_id;

    public IDLivroCategoria() {
    }

    public IDLivroCategoria(Long livro_id, Long categoria_id) {
        this.livro_id = livro_id;
        this.categoria_id = categoria_id;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
