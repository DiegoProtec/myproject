package com.myproject.domains;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 4816243829840494960L;

    private Long timestamp;
    private int status;
    private String titulo;
    private String mensagem;

    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public ErrorMessage(Long timestamp, int status, String titulo, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
}
