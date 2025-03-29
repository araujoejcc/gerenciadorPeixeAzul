package br.com.peixeazul.fazendaPeixeAzul.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "alerta_parametro")
public class AlertaParametro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do parâmetro é obrigatório.")
    private String parametro;

    private double valorMinimo;
    private double valorMaximo;

    @NotNull(message = "O nível de criticidade é obrigatório.")
    @Min(value = 1, message = "O nível de criticidade deve ser pelo menos 1.")
    @Max(value = 3, message = "O nível de criticidade deve ser no máximo 3.")
    private Integer nivelCriticidade;

    @NotBlank(message = "A mensagem de alerta é obrigatória.")
    @Size(max = 255, message = "A mensagem de alerta deve ter no máximo 255 caracteres.")
    private String mensagem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Integer getNivelCriticidade() {
        return nivelCriticidade;
    }

    public void setNivelCriticidade(Integer nivelCriticidade) {
        this.nivelCriticidade = nivelCriticidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}