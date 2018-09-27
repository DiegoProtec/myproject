package com.myproject.handler;

public class ErrorDetails {

    private Long time;
    private String mensagem;
    private String detalhes;

    ErrorDetails(Long time, String mensagem, String detalhes) {
        super();
        this.time = time;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
