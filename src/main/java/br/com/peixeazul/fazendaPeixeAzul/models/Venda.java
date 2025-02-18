package br.com.peixeazul.fazendaPeixeAzul.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotBlank(message = "O tanque é obrigatório.")
    private Tanque tanque;

    @NotNull(message = "A quantidade de pescado é obrigatória.")
    @PositiveOrZero(message = "A quantidade de pescado deve ser um valor positivo ou zero.")
    private double quantidadePescado;

    @NotNull(message = "O valor da venda é obrigatório.")
    @PositiveOrZero(message = "O valor da venda deve ser um valor positivo ou zero.")
    private double valorTotal;

    @NotNull(message = "A data é obrigatória.")
    @PastOrPresent(message = "A data deve ser no passado ou presente.")
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

