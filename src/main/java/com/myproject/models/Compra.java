package com.myproject.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precoTotal;

    @OneToMany(
            mappedBy = "compra",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Carrinho> livros = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Pagamento pagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Compra() {}

    public Compra(Double precoTotal, List<Carrinho> livros, Pagamento pagamento, Cliente cliente) {
        this.precoTotal = precoTotal;
        this.livros = livros;
        this.pagamento = pagamento;
        this.cliente = cliente;
    }

    Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<Carrinho> getLivros() {
        return livros;
    }

    public void setLivros(List<Carrinho> livros) {
        this.livros = livros;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addLivro(Livro livro) {
        Carrinho carrinho = new Carrinho(livro, this);
        livros.add(carrinho);
        livro.getCompras().add(carrinho);
    }

    public void removeLivro(Livro livro) {
        for (Iterator<Carrinho> iterator = livros.iterator();
             iterator.hasNext(); ) {
            Carrinho carrinho = iterator.next();

            if (carrinho.getCompra().equals(this) &&
                    carrinho.getLivro().equals(livro)) {
                iterator.remove();
                carrinho.getLivro().getCompras().remove(carrinho);
                carrinho.setCompra(null);
                carrinho.setLivro(null);
            }
        }
    }
}
