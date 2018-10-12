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
@Table(name = "TB_AUTOR")
@SequenceGenerator(name = "seqAutor", sequenceName = "seq_autor", allocationSize = 1)
public class Autor extends BaseEntity<Long> {

    public static final String COD_ID = "COD_AUTOR";
    private static final long serialVersionUID = 5401724076990722203L;

    @Id
    @GeneratedValue(generator = "seqAutor", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;

    @NotBlank
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 150, message = "Máximo 150 caracteres.")
    @Column(nullable = false)
    private String nome;

}
