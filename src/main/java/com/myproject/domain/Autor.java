package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @OneToMany(
            mappedBy = "autor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private List<LivroAutor> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(@NotNull String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<LivroAutor> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroAutor> livros) {
        this.livros = livros;
    }
}
