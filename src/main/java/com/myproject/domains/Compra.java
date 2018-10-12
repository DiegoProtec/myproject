package com.myproject.domains;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_COMPRA")
@SequenceGenerator(name = "seqCompra", sequenceName = "seq_compra", allocationSize = 1)
public class Compra extends BaseEntity<Long>{

    public static final String COD_ID = "COD_COMPRA";
    private static final long serialVersionUID = 8450011012907881260L;

    @Id
    @GeneratedValue(generator = "seqCompra", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @Column(nullable = false)
    private Double valorTotal;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Pagamento.COD_ID, nullable = false)
    private Pagamento pagamento;

    @NonNull
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Carrinho> livros;

}
