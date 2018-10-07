package com.myproject.domain;

import javax.validation.Valid;
import java.io.Serializable;

public class UsuarioFuncionario implements Serializable {

    public static final long serialVersionUID = 1L;

    @Valid
    private Usuario usuario;

    @Valid
    private Funcionario funcionario;

    public UsuarioFuncionario() {
    }

    public UsuarioFuncionario(Usuario usuario, Funcionario funcionario) {
        this.usuario = usuario;
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
