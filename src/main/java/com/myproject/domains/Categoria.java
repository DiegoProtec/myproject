package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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
    @Size(min = 2, message = "Mínimo 2 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    @Column(nullable = false)
    private String categoria;

}
