package com.myproject.domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
//@Entity
//@Table(name = "TB_CARTAO")
public class Cartao extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CARTAO";
    private static final long serialVersionUID = 4322041704429697874L;

    //    @Id
    private Long id;

//
//    @Column(unique = true, nullable = false)
//    private String numero;
//
//
//    @Column(nullable = false)
//    private String titular;
//
//
//    @Column(nullable = false)
//    private LocalDate vencimento;
//
//
//    @Column(nullable = false)
//    private String autenticador;

//    @OneToOne
//    @JoinColumn(name = COD_ID, nullable = false)
//    @MapsId
//    private Pagamento pagamento;

//    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
//    private List<Cliente> clientes;

}
