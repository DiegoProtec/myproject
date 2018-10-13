package com.myproject.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "seqUsuario", sequenceName = "seq_usuario", allocationSize = 1)
public class Usuario extends BaseEntity<Long> {

    public static final String COD_ID = "COD_USUARIO";
    private static final long serialVersionUID = 259772693574501877L;

    @Id
    @GeneratedValue(generator = "seqUsuario", strategy = GenerationType.SEQUENCE)
    @Column(name = COD_ID)
    private Long id;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Funcionario funcionario;

}
