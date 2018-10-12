package com.myproject.domains;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario extends BaseEntity<Long> {

    public static final String COD_ID = "COD_FUNCIONARIO";
    private static final long serialVersionUID = 4787155629542489665L;

    @Id
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Usuario usuario;

    public Funcionario() {
    }

    public Funcionario(@NotNull Usuario usuario) {
        this.usuario = usuario;
    }
}
