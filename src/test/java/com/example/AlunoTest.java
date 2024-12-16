package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoTest {

    @Test
    public void testCalcularMediaValoresPositivos() {
        Aluno aluno = new Aluno(8.0, 7.5, 9.0, 10.0);
        assertEquals(8.625, aluno.calcularMedia(), 0.001);
    }

    @Test
    public void testCalcularMediaValoresIguais() {
        Aluno aluno = new Aluno(5.0, 5.0, 5.0, 5.0);
        assertEquals(5.0, aluno.calcularMedia(), 0.001);
    }

    @Test
    public void testCalcularMediaValoresExtremos() {
        Aluno aluno = new Aluno(0.0, 10.0, 0.0, 10.0);
        assertEquals(5.0, aluno.calcularMedia(), 0.001);
    }

    @Test
    public void testCalcularMediaValoresDecimais() {
        Aluno aluno = new Aluno(1.2, 2.4, 3.6, 4.8);
        assertEquals(3.0, aluno.calcularMedia(), 0.001);
    }

    @Test
    public void testCalcularMediaValoresMisturados() {
        Aluno aluno = new Aluno(6.0, 7.0, 8.0, 5.0);
        assertEquals(6.5, aluno.calcularMedia(), 0.001);
    }
}
