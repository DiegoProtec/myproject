package com.myproject.domains;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
