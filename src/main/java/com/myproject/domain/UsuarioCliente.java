package com.myproject.domain;

import java.io.Serializable;

public class UsuarioCliente implements Serializable {

    public static final long serialVersionUID = 1L;

    private Usuario usuario;
    private Cliente cliente;

    public UsuarioCliente() {
    }

    public UsuarioCliente(Usuario usuario, Cliente cliente) {
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
