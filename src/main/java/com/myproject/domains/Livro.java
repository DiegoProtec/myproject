package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_LIVRO")
@SequenceGenerator(name = "seqLivro", sequenceName = "seq_livro", allocationSize = 1)
public class Livro extends BaseEntity<Long> {

    public static final String COD_ID = "COD_LIVRO";
    private static final long serialVersionUID = -2147913200479916421L;

    @Id
    @GeneratedValue(generator = "seqLivro", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LIVRO_AUTOR",
            joinColumns = @JoinColumn(name = Livro.COD_ID),
            inverseJoinColumns = @JoinColumn(name = Autor.COD_ID)
    )
    private Set<Autor> autores = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LIVRO_CATEGORIA",
            joinColumns = @JoinColumn(name = Livro.COD_ID),
            inverseJoinColumns = @JoinColumn(name = Categoria.COD_ID)
    )
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "livro", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Carrinho> compras;

}
