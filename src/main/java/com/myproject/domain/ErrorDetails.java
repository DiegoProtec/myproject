package com.myproject.domain;

public class ErrorDetails {

    private Long timestamp;
    private Long status;
    private String titulo;
    private String mensagem;

    public ErrorDetails(Long timestamp, Long status, String titulo, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
