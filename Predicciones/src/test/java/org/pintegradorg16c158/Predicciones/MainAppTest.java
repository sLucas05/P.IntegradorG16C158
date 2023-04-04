package org.pintegradorg16c158.Predicciones;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainAppTest {

    @Test
    public void verificoElNumeroCorrectoDeCamposYCantidadDeGolesSeaEntero() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Usuario/Documents/entrega2/P.IntegradorG16C158/Predicciones/src/main/resources/Partidos.csv"));
        String linea;
        int NumLinea = 0;
        while ((linea = br.readLine()) != null) {
            NumLinea++;
            String[] campo = Arrays.copyOf(linea.split(","), 4);
            assertEquals("Numero de campos no valido " + NumLinea, 4, campo.length);
            try {
                Integer.parseInt(campo[1]); // verifico que el segundo campo sea un entero
                Integer.parseInt(campo[2]); // verifico que el tercer campo sea un entero
            } catch (NumberFormatException e) {
                fail("El formato del numero no es el correcto: " + NumLinea);
            }
        }
        br.close();
    }
}


