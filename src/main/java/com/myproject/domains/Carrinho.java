package com.myproject.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_LIVRO_COMPRA")
public class Carrinho extends BaseEntity<Long> {

    private static final long serialVersionUID = -6075800777155406529L;

    @EmbeddedId
    private IDCarrinho id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Livro.COD_ID, nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Compra.COD_ID, nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Compra compra;


    @Column(nullable = false)
    private Integer quantidade;


    @Column(nullable = false)
    private Double valorTotalItem;

    @Override
    public Serializable getId() {
        return null;
    }
}
