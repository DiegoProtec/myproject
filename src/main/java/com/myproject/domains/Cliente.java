package com.myproject.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
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

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Cartao.COD_ID)
    @JsonIgnore
    private Cartao cartao;

    @NotNull
    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(@NotBlank @Size(min = 11, message = "Mínimo 11 caracteres.") @Size(max = 11, message = "Máximo 11 caracteres.") String telefone, @NotNull Usuario usuario) {
        this.telefone = telefone;
        this.usuario = usuario;
    }
}
