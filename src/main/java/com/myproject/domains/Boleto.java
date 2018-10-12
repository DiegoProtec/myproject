package com.myproject.domains;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_BOLETO")
public class Boleto extends BaseEntity<Long> {

    public static final String COD_ID = "COD_BOLETO";
    private static final long serialVersionUID = 2551064729867005752L;

    @Id
    private Long id;

    @NotNull
    @Size(min = 8, message = "Mínimo 8 caracteres.")
    @Size(max = 14, message = "Máximo 14 caracteres.")
    @Column(unique = true, nullable = false)
    private String codigo;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate vencimento;

    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Pagamento pagamento;

}
