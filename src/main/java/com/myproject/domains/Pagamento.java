package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "seqPagamento", sequenceName = "seq_pagamento", allocationSize = 1)
public class Pagamento extends BaseEntity<Long> {

    public static final String COD_ID = "COD_PAGAMENTO";
    private static final long serialVersionUID = -1820116569576835905L;

    @Id
    @GeneratedValue(generator = "seqPagamento", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;

    @NonNull
    @OneToMany(mappedBy = "pagamento", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<Compra> compras;

}
