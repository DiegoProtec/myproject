package com.myproject.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_LIVRO_COMPRA")
public class Carrinho extends BaseEntity<Long> {

    private static final long serialVersionUID = -6075800777155406529L;

    @EmbeddedId
    private IDCarrinho id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Livro.COD_ID, nullable = false)
    private Livro livro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Compra.COD_ID, nullable = false)
    private Compra compra;

    @NotNull
    @NumberFormat
    @Column(nullable = false)
    private Integer quantidade;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @Column(nullable = false)
    private Double valorTotalItem;

    @Override
    public Serializable getId() {
        return null;
    }
}