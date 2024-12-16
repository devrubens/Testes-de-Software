package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class ContaTest {

    @Test
    public void testCalcularTotalSemMultaAntesDoVencimento() {
        Conta conta = new Conta(LocalDate.of(2024, 6, 5), LocalDate.of(2024, 6, 10), 200.0);
        assertEquals(200.0, conta.calcularTotal(), 0.001);
    }

    @Test
    public void testCalcularTotalNoVencimento() {
        Conta conta = new Conta(LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 10), 150.0);
        assertEquals(150.0, conta.calcularTotal(), 0.001);
    }

    @Test
    public void testCalcularTotalComMultaUmDiaAposVencimento() {
        Conta conta = new Conta(LocalDate.of(2024, 6, 11), LocalDate.of(2024, 6, 10), 100.0);
        assertEquals(120.0, conta.calcularTotal(), 0.001);
    }

    @Test
    public void testCalcularTotalComMultaMuitosDiasAtrasado() {
        Conta conta = new Conta(LocalDate.of(2024, 6, 20), LocalDate.of(2024, 6, 10), 300.0);
        assertEquals(360.0, conta.calcularTotal(), 0.001); // 20% de multa
    }

    @Test
    public void testCalcularTotalSemMultaMuitoAntesDoVencimento() {
        Conta conta = new Conta(LocalDate.of(2024, 5, 1), LocalDate.of(2024, 6, 10), 500.0);
        assertEquals(500.0, conta.calcularTotal(), 0.001);
    }

    @Test
    public void testCalcularTotalComTotalZero() {
        Conta conta = new Conta(LocalDate.of(2024, 6, 12), LocalDate.of(2024, 6, 10), 0.0);
        assertEquals(0.0, conta.calcularTotal(), 0.001);
    }
}
