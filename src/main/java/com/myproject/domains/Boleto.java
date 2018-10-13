package com.myproject.domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
//@Entity
//@Table(name = "TB_BOLETO")
public class Boleto extends BaseEntity<Long> {

    public static final String COD_ID = "COD_BOLETO";
    private static final long serialVersionUID = 2551064729867005752L;

    //    @Id
    private Long id;

//    @NotNull
//    @Size(min = 8, message = "Mínimo 8 caracteres.")
//    @Size(max = 14, message = "Máximo 14 caracteres.")
//    @Column(unique = true, nullable = false)
//    private String codigo;
//
//    @NotNull
//    @Column(nullable = false)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    private LocalDate vencimento;

//    @NotNull
//    @OneToOne
//    @JoinColumn(name = COD_ID, nullable = false)
//    @MapsId
//    private Pagamento pagamento;

}
