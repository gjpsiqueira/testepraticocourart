package com.teste.courart.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    @NotNull
    private String descricao;
    @Column(length = 4)
    @NotNull
    private String ano;
    @NotNull
    private double consumoMedioKm;
    @NotNull
    private int qtdPassageiro;

    public Modelo() {}

    public Modelo(@NotNull String descricao, @NotNull String ano, @NotNull double consumoMedioKm, @NotNull int qtdPassageiro) {
        this.descricao = descricao;
        this.ano = ano;
        this.consumoMedioKm = consumoMedioKm;
        this.qtdPassageiro = qtdPassageiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getConsumoMedioKm() {
        return consumoMedioKm;
    }

    public void setConsumoMedioKm(double consumoMedioKm) {
        this.consumoMedioKm = consumoMedioKm;
    }

    public int getQtdPassageiro() {
        return qtdPassageiro;
    }

    public void setQtdPassageiro(int qtdPassageiro) {
        this.qtdPassageiro = qtdPassageiro;
    }
}
