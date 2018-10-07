package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Size(min = 8, message = "Mínimo 8 caracteres.")
    @Size(max = 60, message = "Máximo 60 caracteres.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 6, message = "Mínimo 6 caracteres.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(nullable = false)
    private String senha;

    @NotNull
    @Size(min = 5, message = "Mínimo 5 caracteres.")
    @Size(max = 120, message = "Máximo 120 caracteres.")
    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
    private Funcionario funcionario;

    public Usuario() {
    }

    public Usuario(
            @NotNull @Email @Size(min = 8, message = "Mínimo 8 caracteres.") @Size(max = 60, message = "Máximo 60 caracteres.") String email,
            @NotNull @Size(min = 6, message = "Mínimo 6 caracteres.") @Size(max = 20, message = "Máximo 20 caracteres.") String senha,
            @NotNull @Size(min = 5, message = "Mínimo 5 caracteres.") @Size(max = 120, message = "Máximo 120 caracteres.") String nome,
            Cliente cliente) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cliente = cliente;
    }

    public Usuario(
            @NotNull @Email @Size(min = 8, message = "Mínimo 8 caracteres.") @Size(max = 60, message = "Máximo 60 caracteres.") String email,
            @NotNull @Size(min = 6, message = "Mínimo 6 caracteres.") @Size(max = 20, message = "Máximo 20 caracteres.") String senha,
            @NotNull @Size(min = 5, message = "Mínimo 5 caracteres.") @Size(max = 120, message = "Máximo 120 caracteres.") String nome,
            Funcionario funcionario) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
