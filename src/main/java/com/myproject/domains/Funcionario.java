package com.myproject.domains;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario extends BaseEntity<Long> {

    public static final String COD_ID = "COD_FUNCIONARIO";
    private static final long serialVersionUID = 4787155629542489665L;

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Usuario usuario;

}
