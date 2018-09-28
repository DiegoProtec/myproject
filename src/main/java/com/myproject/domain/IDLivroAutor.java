package com.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IDLivroAutor implements Serializable {

    public static final long serialVersionUID = 1L;

    @Column(name = "livro_id")
    private Long livro_id;

    @Column(name = "autor_id")
    private Long autor_id;

    public IDLivroAutor() {
    }

    public IDLivroAutor(Long livro_id, Long autor_id) {
        this.livro_id = livro_id;
        this.autor_id = autor_id;
    }

    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }
}
