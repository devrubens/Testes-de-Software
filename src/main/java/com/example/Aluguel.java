package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel {
    private LocalDate dataVencimento;
    private double valorContrato;

    public Aluguel(LocalDate dataVencimento, double valorContrato) {
        this.dataVencimento = dataVencimento;
        this.valorContrato = valorContrato;
    }

    public double calcularValor(LocalDate dataPagamento) {
    long diasDiferenca = ChronoUnit.DAYS.between(dataVencimento, dataPagamento);

    if (diasDiferenca <= -5) {
        return arredondar(valorContrato * 0.9); // 10% de desconto
    } else if (diasDiferenca <= -1) {
        return arredondar(valorContrato * 0.95); // 5% de desconto
    } else if (diasDiferenca >= 0 && diasDiferenca <= 5) {
        return arredondar(valorContrato); // Valor integral
    } else {
        // Multa de 2% + Juros de 1% ao mês
        long mesesAtraso = (diasDiferenca / 30); // Atraso convertido para meses completos
        double multa = valorContrato * 0.02; // 2% de multa
        double juros = valorContrato * 0.01 * mesesAtraso; // 1% por mês
        return arredondar(valorContrato + multa + juros);
    }
}

    private double arredondar(double valor) {
        return BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
}
