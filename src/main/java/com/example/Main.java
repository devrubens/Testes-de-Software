package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Testando a classe Aluno
        System.out.println("### Teste da Classe Aluno ###");
        Aluno aluno = new Aluno(8.0, 7.5, 9.0, 10.0);
        System.out.println("Média do aluno: " + aluno.calcularMedia());
        System.out.println();

        // Testando a classe Conta
        System.out.println("### Teste da Classe Conta ###");
        LocalDate dataVencimento = LocalDate.of(2024, 6, 10);
        LocalDate dataPagamentoAtrasado = LocalDate.of(2024, 6, 15);
        LocalDate dataPagamentoNoPrazo = LocalDate.of(2024, 6, 9);

        Conta conta1 = new Conta(dataPagamentoNoPrazo, dataVencimento, 100.0);
        Conta conta2 = new Conta(dataPagamentoAtrasado, dataVencimento, 100.0);

        System.out.println("Conta paga no prazo: " + conta1.calcularTotal());
        System.out.println("Conta paga com atraso: " + conta2.calcularTotal());
        System.out.println();

        // Testando a classe Eleitor
        System.out.println("### Teste da Classe Eleitor ###");
        Eleitor eleitor1 = new Eleitor("João", LocalDate.of(2010, 6, 5)); // Menor de 16 anos
        Eleitor eleitor2 = new Eleitor("Maria", LocalDate.of(1990, 6, 5)); // Obrigatório
        Eleitor eleitor3 = new Eleitor("Pedro", LocalDate.of(2008, 6, 5)); // Facultativo (16-18 anos)
        Eleitor eleitor4 = new Eleitor("Ana", LocalDate.of(1950, 6, 5)); // Facultativo (+70 anos)

        System.out.println(eleitor1.verificarVoto());
        System.out.println(eleitor2.verificarVoto());
        System.out.println(eleitor3.verificarVoto());
        System.out.println(eleitor4.verificarVoto());
    }
}
