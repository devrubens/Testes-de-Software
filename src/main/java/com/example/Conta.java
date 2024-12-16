package com.example;

import java.time.LocalDate;

public class Conta {
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private double total;
    private double multa = 0.2; // 20%

    public Conta(LocalDate dataPagamento, LocalDate dataVencimento, double total) {
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.total = total;
    }

    public double calcularTotal() {
        if (dataPagamento.isAfter(dataVencimento)) {
            return total + (total * multa);
        }
        return total;
    }
}
