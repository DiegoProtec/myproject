package com.myproject.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class IDCarrinho extends BaseEntity<Long>{

    private static final long serialVersionUID = 2219599428297571445L;

    @Column(name = Livro.COD_ID)
    private Long livro;

    @Column(name = Compra.COD_ID)
    private Long compra;

    @Override
    public Serializable getId() {
        return null;
    }
}