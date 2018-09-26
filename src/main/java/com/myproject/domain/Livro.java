package com.myproject.domain;

import javax.persistence.*;
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

    @NotNull
    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Double preco;

    @OneToMany(
            mappedBy = "livro",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Carrinho> compras = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autores =  new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "livro_categoria",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    public Livro(){}

    public Livro(@NotNull String titulo, String descricao, @NotNull Double preco, Set<Autor> autores, Set<Categoria> categorias) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.autores = autores;
        this.categorias = categorias;
    }

    Long getId() {
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
