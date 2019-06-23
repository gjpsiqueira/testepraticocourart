package com.teste.courart.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 12)
    @NotNull
    private String usuario;

    @Column(length = 12)
    @NotNull
    private  String senha;

    @OneToOne
    @JoinColumn(name = "pessoa_id",referencedColumnName = "id")
    private Pessoa pessoa;

    public Usuario() {}

    public Usuario(@NotNull String usuario, @NotNull String senha, Pessoa pessoa) {
        this.usuario = usuario;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
