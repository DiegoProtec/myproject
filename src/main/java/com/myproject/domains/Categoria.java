package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    @Column(nullable = false)
    private String categoria;

}
