package com.myproject.domains;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
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

    @Column(nullable = false)
    private String nome;

}
