package com.teste.courart.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    @NotNull
    private String placa;
    @Column(length = 40)
    @NotNull
    private String chassi;
    @NotNull
    private boolean ativo;
    @Column(length = 4)
    @NotNull
    private String anoFabricacao;

    @Column(length = 20)
    private String cor;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDesativacao;

    @OneToOne
    @JoinColumn(name = "modelo_id",referencedColumnName = "id")
    private Modelo modelo;

    public Veiculo() {}

    public Veiculo(@NotNull String placa, @NotNull String chassi,String cor, @NotNull boolean ativo, @NotNull String anoFabricacao, Date dataCadastro, Date dataDesativacao, Modelo modelo) {
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.ativo = ativo;
        this.anoFabricacao = anoFabricacao;
        this.dataCadastro = dataCadastro;
        this.dataDesativacao = dataDesativacao;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", chassi='" + chassi + '\'' +
                ", ativo=" + ativo +
                ", anoFrabricacao='" + anoFabricacao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataDesativacao=" + dataDesativacao +
                ", modelo=" + modelo.getId() +
                '}';
    }
}
