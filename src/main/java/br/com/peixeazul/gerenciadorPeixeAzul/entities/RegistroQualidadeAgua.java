package br.com.peixeazul.gerenciadorPeixeAzul.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RegistroQualidadeAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Tanque tanque;
    private double temperatura;
    private double pH;
    private double oxigenacao;
    private LocalDate data;

    public RegistroQualidadeAgua() {
    }

    public RegistroQualidadeAgua(Integer id, Tanque tanque, double temperatura, double pH, double oxigenacao, LocalDate data) {
        this.id = id;
        this.tanque = tanque;
        this.temperatura = temperatura;
        this.pH = pH;
        this.oxigenacao = oxigenacao;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(double oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

