package com.myproject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Column
    @ElementCollection(targetClass=Autor.class)
    private Set<Autor> autores;

    @Column
    @ElementCollection(targetClass=Categoria.class)
    private Set<Categoria> categorias;

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Carrinho> compras = new ArrayList<>();

    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank String descricao, @NotNull Double preco, Set<Autor> autores, Set<Categoria> categorias, List<Carrinho> compras) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.autores = autores;
        this.categorias = categorias;
        this.compras = compras;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id")
    )
    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    )
    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
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

    List<Carrinho> getCompras() {
        return compras;
    }

    public void setCompras(List<Carrinho> compras) {
        this.compras = compras;
    }
}
