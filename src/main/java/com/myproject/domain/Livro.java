package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Double preco;

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private List<LivroAutor> autores = new ArrayList<>();

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private List<LivroCategoria> categorias = new ArrayList<>();

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private List<Carrinho> compras = new ArrayList<>();

    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank String descricao, @NotNull Double preco) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<LivroAutor> getAutores() {
        return autores;
    }

    public void setAutores(List<LivroAutor> autores) {
        this.autores = autores;
    }

    public List<LivroCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<LivroCategoria> categorias) {
        this.categorias = categorias;
    }

    public List<Carrinho> getCompras() {
        return compras;
    }

    public void setCompras(List<Carrinho> compras) {
        this.compras = compras;
    }
}
