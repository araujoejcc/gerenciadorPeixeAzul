package br.com.peixeazul.gerenciadorPeixeAzul.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CicloProducao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Tanque tanque;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double quantidadePescado;
    private double racaoGasta;

    public CicloProducao() {
    }

    public CicloProducao(Integer id, Tanque tanque, LocalDate dataInicio, LocalDate dataFim, double quantidadePescado, double racaoGasta) {
        this.id = id;
        this.tanque = tanque;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.quantidadePescado = quantidadePescado;
        this.racaoGasta = racaoGasta;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getQuantidadePescado() {
        return quantidadePescado;
    }

    public void setQuantidadePescado(double quantidadePescado) {
        this.quantidadePescado = quantidadePescado;
    }

    public double getRacaoGasta() {
        return racaoGasta;
    }

    public void setRacaoGasta(double racaoGasta) {
        this.racaoGasta = racaoGasta;
    }

    public double calcularFCA() {
        return quantidadePescado > 0 ? racaoGasta / quantidadePescado : 0;
    }
}
