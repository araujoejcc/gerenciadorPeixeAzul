package br.com.peixeazul.fazendaPeixeAzul.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "registro_qualidade_agua")
public class RegistroQualidadeAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O tanque é obrigatório.")
    @ManyToOne
    private Tanque tanque;

    @DecimalMin(value = "0.0", message = "A temperatura deve ser maior ou igual a 0.")
    private double temperatura;

    @NotNull(message = "O pH é obrigatório.")
    @DecimalMin(value = "0.0", message = "O pH deve ser maior ou igual a 0.")
    @DecimalMax(value = "14.0", message = "O pH deve ser menor ou igual a 14.")
    private double ph;

    @NotNull(message = "A oxigenação é obrigatória.")
    @PositiveOrZero(message = "A oxigenação deve ser um valor positivo ou zero.")
    private double oxigenacao;

    @NotNull(message = "A data é obrigatória.")
    @PastOrPresent(message = "A data deve ser no passado ou presente.")
    private LocalDate data;

    public RegistroQualidadeAgua() {
    }

    public RegistroQualidadeAgua(Integer id, Tanque tanque, double temperatura, double ph, double oxigenacao, LocalDate data) {
        this.id = id;
        this.tanque = tanque;
        this.temperatura = temperatura;
        this.ph = ph;
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

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
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

