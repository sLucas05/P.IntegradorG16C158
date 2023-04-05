package org.pintegradorg16c158.Predicciones;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PuntajeTest {

    public int calcularPuntaje(String[] prediccion, String resultadoReal) {
        String prediccionUsuario = prediccion[3];
        int puntaje = 0;
        if (prediccionUsuario.equalsIgnoreCase(resultadoReal)) {
            puntaje += 1;
        }
        return puntaje;
    }

    @Test
    public void calculoElPuntajeDeLaPersonaEnDosRondasConsecutivas() {
        String[] prediccion = {"Equipo1", "1", "2", "G2"};
        String resultadoReal = "G2";
        int puntajeEsperado = 1;

        int puntajeObtenido = calcularPuntaje(prediccion, resultadoReal);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
}