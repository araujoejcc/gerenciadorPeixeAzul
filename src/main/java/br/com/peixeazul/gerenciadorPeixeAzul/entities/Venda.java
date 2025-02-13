package br.com.peixeazul.gerenciadorPeixeAzul.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Tanque tanque;
    private double quantidadePescado;
    private double valorTotal;
    private LocalDate data;

    public Venda() {
    }

    public Venda(Integer id, Tanque tanque, double quantidadePescado, double valorTotal, LocalDate data) {
        this.id = id;
        this.tanque = tanque;
        this.quantidadePescado = quantidadePescado;
        this.valorTotal = valorTotal;
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

    public double getQuantidadePescado() {
        return quantidadePescado;
    }

    public void setQuantidadePescado(double quantidadePescado) {
        this.quantidadePescado = quantidadePescado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

