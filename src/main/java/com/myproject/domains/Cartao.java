package com.myproject.domains;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_CARTAO")
public class Cartao extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CARTAO";
    private static final long serialVersionUID = 4322041704429697874L;

    @Id
    private Long id;

    @NotBlank
    @Size(min = 12, message = "Mínimo 12 caracteres.")
    @Size(max = 12, message = "Máximo 12 caracteres.")
    @Column(unique = true, nullable = false)
    private String numero;

    @NotBlank
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    @Column(nullable = false)
    private String titular;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "MM/yy")
    private LocalDate vencimento;

    @NotBlank
    @Size(min = 3, message = "Mínimo 3 caracteres.")
    @Size(max = 3, message = "Máximo 3 caracteres.")
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
