package com.myproject.domains;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente extends BaseEntity<Long> {

    public static final String COD_ID = "COD_CLIENTE";
    private static final long serialVersionUID = 551850766928634728L;

    @Id
    private Long id;

    @Column(nullable = false)
    private String telefone;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = Cartao.COD_ID)
//    @JsonIgnore
//    private Cartao cartao;

    @OneToOne
    @JoinColumn(name = COD_ID, nullable = false)
    @MapsId
    private Usuario usuario;

}
