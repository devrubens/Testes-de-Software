package com.example;

import java.time.LocalDate;
import java.time.Period;

public class Eleitor {
    private String nome;
    private LocalDate dataNascimento;

    public Eleitor(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public String verificarVoto() {
        int idade = calcularIdade();
        if (idade < 16) return "Não pode votar";
        if (idade >= 18 && idade < 70) return "Voto obrigatório";
        return "Voto facultativo";
    }
}
