package br.com.peixeazul.fazendaPeixeAzul.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "alimentacao")
public class Alimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O ciclo de produção é obrigatório.")
    @ManyToOne
    private CicloProducao cicloProducao;

    @NotNull(message = "A data é obrigatória.")
    @PastOrPresent(message = "A data deve ser no passado ou presente.")
    private LocalDate data;

    @NotNull(message = "O horário é obrigatório.")
    private LocalTime horario;

    @NotNull(message = "O tipo de ração é obrigatório.")
    @Size(max = 100, message = "O tipo de ração deve ter no máximo 100 caracteres.")
    private String tipoRacao;

    @NotNull(message = "A quantidade é obrigatória.")
    @Positive(message = "A quantidade deve ser um valor positivo.")
    private double quantidade;

    @Size(max = 500, message = "A observação deve ter no máximo 500 caracteres.")
    private String observacao;

    public Alimentacao() {
    }

    public Alimentacao(Integer id, CicloProducao cicloProducao, LocalDate data, LocalTime horario, String tipoRacao, double quantidade, String observacao) {
        this.id = id;
        this.cicloProducao = cicloProducao;
        this.data = data;
        this.horario = horario;
        this.tipoRacao = tipoRacao;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CicloProducao getCicloProducao() {
        return cicloProducao;
    }

    public void setCicloProducao(CicloProducao cicloProducao) {
        this.cicloProducao = cicloProducao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getTipoRacao() {
        return tipoRacao;
    }

    public void setTipoRacao(String tipoRacao) {
        this.tipoRacao = tipoRacao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}