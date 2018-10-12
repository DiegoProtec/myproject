package com.myproject.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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

    @NotBlank
    @Email
    @Size(min = 8, message = "Mínimo 8 caracteres.")
    @Size(max = 60, message = "Máximo 60 caracteres.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(nullable = false)
    private String senha;

    @NotBlank
    @Size(min = 5, message = "Mínimo 5 caracteres.")
    @Size(max = 120, message = "Máximo 120 caracteres.")
    @Column(nullable = false)
    private String nome;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Cliente cliente;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Funcionario funcionario;

}
