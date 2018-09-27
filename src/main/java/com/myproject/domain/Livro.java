package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Carrinho> compras = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonIgnore
    private Set<Autor> autores =  new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonIgnore
    private Set<Categoria> categorias = new HashSet<>();

    public Livro(){}

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

    public List<Carrinho> getCompras() {
        return compras;
    }

    public void setCompras(List<Carrinho> compras) {
        this.compras = compras;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
        autor.getLivros().add(this);
    }

    public void removeAutor(Autor autor) {
        autores.remove(autor);
        autor.getLivros().remove(this);
    }

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.getLivros().add(this);
    }

    public void removeCategoria(Categoria categoria) {
        categorias.remove(categoria);
        categoria.getLivros().remove(this);
    }
}
