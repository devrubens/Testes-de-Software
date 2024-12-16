package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class EleitorTest {

    @Test
    public void testVerificarVotoNaoPodeVotarExatamente15Anos() {
        Eleitor eleitor = new Eleitor("Lucas", LocalDate.of(2009, 6, 5));
        assertEquals("Não pode votar", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoFacultativoExatamente16Anos() {
        Eleitor eleitor = new Eleitor("Clara", LocalDate.of(2008, 6, 5));
        assertEquals("Voto facultativo", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoObrigatorioExatamente18Anos() {
        Eleitor eleitor = new Eleitor("Rafael", LocalDate.of(2006, 6, 5));
        assertEquals("Voto obrigatório", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoObrigatorioExatamente69Anos() {
        Eleitor eleitor = new Eleitor("Juliana", LocalDate.of(1955, 6, 5));
        assertEquals("Voto obrigatório", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoFacultativoExatamente70Anos() {
        Eleitor eleitor = new Eleitor("Marcos", LocalDate.of(1954, 6, 5));
        assertEquals("Voto facultativo", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoFacultativoAcima70Anos() {
        Eleitor eleitor = new Eleitor("Beatriz", LocalDate.of(1950, 6, 5));
        assertEquals("Voto facultativo", eleitor.verificarVoto());
    }

    @Test
    public void testVerificarVotoNaoPodeVotarRecemNascido() {
        Eleitor eleitor = new Eleitor("RecemNascido", LocalDate.now());
        assertEquals("Não pode votar", eleitor.verificarVoto());
    }
}
