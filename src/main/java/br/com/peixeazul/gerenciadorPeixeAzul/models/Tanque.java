package br.com.peixeazul.gerenciadorPeixeAzul.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
    public class Tanque {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotBlank(message = "O nome do tanque é obrigatório.")
        @Size(max = 255, message = "O nome do tanque deve ter no máximo 255 caracteres.")
        private String nome;

        @NotNull(message = "A capacidade do tanque é obrigatória.")
        @Positive(message = "A capacidade do tanque deve ser um valor positivo.")
        private double capacidade;

        @NotBlank(message = "A localização do tanque é obrigatória.")
        @Size(max = 255, message = "A localização do tanque deve ter no máximo 255 caracteres.")
        private String localizacao;

        @NotBlank(message = "A espécie cultivada é obrigatória.")
        @Size(max = 255, message = "A espécie cultivada deve ter no máximo 255 caracteres.")
        private String especieCultura; // Nova adição


        public Tanque() {
        }

        public Tanque(Integer id, String nome, double capacidade, String localizacao, String especieCultura) {
            this.id = id;
            this.nome = nome;
            this.capacidade = capacidade;
            this.localizacao = localizacao;
            this.especieCultura = especieCultura;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getCapacidade() {
            return capacidade;
        }

        public void setCapacidade(double capacidade) {
            this.capacidade = capacidade;
        }

        public String getLocalizacao() {
            return localizacao;
        }

        public void setLocalizacao(String localizacao) {
            this.localizacao = localizacao;
        }

        public String getEspecieCultura() {
            return especieCultura;
        }

        public void setEspecieCultura(String especieCultura) {
            this.especieCultura = especieCultura;
        }
    }
