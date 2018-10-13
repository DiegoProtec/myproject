package com.myproject.domains;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_CATEGORIA")
@SequenceGenerator(name = "seqCategoria", sequenceName = "seq_categoria", allocationSize = 1)
public class Categoria extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CATEGORIA";
    private static final long serialVersionUID = -4147556777618015335L;

    @Id
    @GeneratedValue(generator = "seqCategoria", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;

    @Column(nullable = false)
    private String categoria;

}
