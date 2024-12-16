package com.example;

import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AluguelTest {

    private static Aluguel aluguel;

    @BeforeAll
    public static void setUpBeforeAll() {
        System.out.println("Iniciando testes para a classe Aluguel...");
    }

    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("Todos os testes concluídos.");
    }

    @BeforeEach
    public void setUp() {
        aluguel = new Aluguel(LocalDate.of(2024, 6, 10), 1000.0);
        System.out.println("Iniciando um teste...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teste finalizado.");
    }

    @Test
    public void testCalcularValorCom10PorCentoDesconto() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 6, 5));
        assertEquals(900.0, valor, 0.01);
    }

    @Test
    public void testCalcularValorCom5PorCentoDesconto() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 6, 8));
        assertEquals(950.0, valor, 0.01);
    }

    @Test
    public void testCalcularValorIntegral() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 6, 10));
        assertEquals(1000.0, valor, 0.01);
    }

    @Test
    public void testCalcularValorComMultaEAtraso1Mes() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 7, 16));
        assertEquals(1030.0, valor, 0.01); 
    }

    @Test
    public void testCalcularValorPagamentoHoje() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 6, 10));
        assertEquals(1000.0, valor, 0.01); 
    }

    @Test
    public void testCalcularValorPagamentoAtrasadoMasSemMesesCompletos() {
        double valor = aluguel.calcularValor(LocalDate.of(2024, 6, 20));
        assertEquals(1020.0, valor, 0.01); 
    }

}
