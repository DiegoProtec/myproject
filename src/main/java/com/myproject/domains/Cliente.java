package com.myproject.domains;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CLIENTE";
    private static final long serialVersionUID = 551850766928634728L;

    @Id
    private Long id;

    @NotBlank
    @Size(min = 11, message = "Mínimo 11 caracteres.")
    @Size(max = 11, message = "Máximo 11 caracteres.")
    @Column(nullable = false)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Cliente.COD_ID)
    private Cartao cartao;

    @NotNull
    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Usuario usuario;

}
