package br.com.peixeazul.gerenciadorPeixeAzul.models;

import br.com.peixeazul.gerenciadorPeixeAzul.enums.TipoCompra;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O valor da compra é obrigatório.")
    @PositiveOrZero(message = "O valor da compra deve ser um valor positivo ou zero.")
    private double valor;

    @NotNull(message = "A data é obrigatória.")
    @PastOrPresent(message = "A data deve ser no passado ou presente.")
    private LocalDate data;

    @NotNull(message = "O tipo da compra é obrigatório.")
    @Enumerated(EnumType.STRING) // Armazena o valor do enum como String no banco de dados
    private TipoCompra tipo;

    public Compra() {
    }

    public Compra(Integer id, String descricao, double valor, LocalDate data, TipoCompra tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoCompra getTipo() {
        return tipo;
    }

    public void setTipo(TipoCompra tipo) {
        this.tipo = tipo;
    }
}
