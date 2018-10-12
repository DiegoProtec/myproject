package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CARTAO")
public class Cartao extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CARTAO";
    private static final long serialVersionUID = 4322041704429697874L;

    @Id
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String numero;

    @NotBlank
    @Column(nullable = false)
    private String titular;

    @NotBlank
    @Column(nullable = false)
    private LocalDate vencimento;

    @NotBlank
    @Column(nullable = false)
    private String autenticador;

    @NotNull
    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Pagamento pagamento;

    @NonNull
    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Cliente> clientes;

}
