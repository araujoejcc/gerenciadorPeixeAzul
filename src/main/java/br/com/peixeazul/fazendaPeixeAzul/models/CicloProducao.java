package br.com.peixeazul.fazendaPeixeAzul.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table(name = "ciclo_producao")
public class CicloProducao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O tanque é obrigatório.")
    @ManyToOne
    private Tanque tanque;

    @NotNull(message = "A data de início é obrigatória.")
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @NotNull(message = "A quantidade pescada é obrigatória.")
    @PositiveOrZero(message = "A quantidade pescada deve ser um valor positivo ou zero.")
    private double quantidadePescado;

    @NotNull(message = "A ração gasta é obrigatória.")
    @PositiveOrZero(message = "A ração gasta deve ser um valor positivo ou zero.")
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
