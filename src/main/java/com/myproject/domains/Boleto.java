package com.myproject.domains;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
