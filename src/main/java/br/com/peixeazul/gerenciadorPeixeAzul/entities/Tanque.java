package br.com.peixeazul.gerenciadorPeixeAzul.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class Tanque {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private double capacidade;
        private String localizacao;
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
