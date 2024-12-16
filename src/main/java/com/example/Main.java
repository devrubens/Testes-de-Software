package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("=== Sistema de Cálculo de Aluguel ===");

        // Solicita a data de vencimento
        System.out.print("Digite a data de vencimento (yyyy-MM-dd): ");
        LocalDate dataVencimento = LocalDate.parse(scanner.nextLine(), formatter);

        // Solicita a data de pagamento
        System.out.print("Digite a data de pagamento (yyyy-MM-dd): ");
        LocalDate dataPagamento = LocalDate.parse(scanner.nextLine(), formatter);

        // Solicita o valor do aluguel
        System.out.print("Digite o valor do aluguel: ");
        double valorAluguel = scanner.nextDouble();

        // Cria o objeto Aluguel
        Aluguel aluguel = new Aluguel(dataVencimento, valorAluguel);

        // Calcula o valor final
        double valorFinal = aluguel.calcularValor(dataPagamento);

        // Exibe o resultado
        System.out.printf("O valor total a ser pago é: R$ %.2f%n", valorFinal);
    }
}
