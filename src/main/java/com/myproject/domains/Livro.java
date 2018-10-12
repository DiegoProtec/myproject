package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Double preco;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LIVRO_AUTOR",
            joinColumns = @JoinColumn(name = Livro.COD_ID),
            inverseJoinColumns = @JoinColumn(name = Autor.COD_ID)
    )
    private Set<Autor> autores = new HashSet<>();

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LIVRO_CATEGORIA",
            joinColumns = @JoinColumn(name = Livro.COD_ID),
            inverseJoinColumns = @JoinColumn(name = Categoria.COD_ID)
    )
    private Set<Categoria> categorias = new HashSet<>();

    @NonNull
    @OneToMany(mappedBy = "livro", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Carrinho> compras;

}
