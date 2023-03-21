package org.pintegradorg16c158.Predicciones;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.Random;

public class MainApp {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Debes ingresar la ruta de los archivos, primero la del archivo csv partidos y luego el de prediccion");
            return;
        }

        int Puntos = 0;
        Scanner scanner = new Scanner(System.in);
        String pathPartidos = args[0];
        String pathPrediccion = args[1];
        String Separador = ";";

        System.out.println("Argentina Programa 4.0 - Desarrollador Java Inicial (UTN)");
        System.out.println("Proyecto Integrador (Predicciones Deportivas)");
        System.out.println("Comision 158 Grupo 16 (Entrega 1)");
        System.out.println("\nLos valores de prediccion son:");
        System.out.println("G1 (Gana el Equipo 1) / E (Empate) / G2 (Gana el Equipo 2)");
        System.out.println("\nIniciar programa de Predicciones Deportivas (press enter)...");
        scanner.nextLine();

        System.out.println("Escriba su nombre de usuario...");
        String NombreUsuario = scanner.nextLine();
        Usuario Nombre = new Usuario(NombreUsuario);

        System.out.println("\nPartido [1] de la Ronda [1]");
        System.out.println("(g1)Argentina vs Brasil(g2)");
        System.out.println("\nRealice su prediccion...");
        String PrediccionP1R1 = scanner.nextLine();

        System.out.println("\nSiguiente partido (press enter)...");
        scanner.nextLine();

        System.out.println("Partido [2] de la Ronda [1]");
        System.out.println("(g1)Uruguay vs Chile(g2)");
        System.out.println("\nRealice su prediccion...");
        String PrediccionP2R1 = scanner.nextLine();

        String equipo1 = ("Argentina");
        String equipo2 = ("Brasil");
        String equipo3 = ("Uruguay");
        String equipo4 = ("Chile");

        PrintWriter CSVwrite = null;

        try {
            CSVwrite = new PrintWriter(new FileWriter(pathPartidos));

            Partido partido1 = new Partido(equipo1, equipo2);

            String ganador1 = partido1.jugarPartido(equipo1, equipo2);

            Partido partido2 = new Partido(equipo3, equipo4);

            String ganador2 = partido2.jugarPartido(equipo3, equipo4);

            CSVwrite.print(equipo1 + Separador + partido1.getGolesEquipo1() + Separador // genera un número aleatorio entre 1 y 3
                    + partido1.getGolesEquipo2() + Separador + equipo2 + "\n");

            CSVwrite.print(equipo3 + Separador + partido2.getGolesEquipo1() + Separador // genera un número aleatorio entre 1 y 3
                    + partido2.getGolesEquipo2() + Separador + equipo4 + "\n");

        } catch (IOException x) {
            x.printStackTrace();
        } finally {
            if (CSVwrite != null) {
                CSVwrite.close();
            }
        }

        //Se almacenan las predicciones en el archivo correspondiente para luego ser leidos y comparados con los resultados
        CSVwrite = null;
        try {
            CSVwrite = new PrintWriter(new FileWriter(pathPrediccion));
            if (PrediccionP1R1.equalsIgnoreCase("G1")) {
                CSVwrite.print("Argentina" + Separador + "X" + Separador + " " + Separador + " " + Separador + "Brasil"
                        + "\n");
            } else if (PrediccionP1R1.equalsIgnoreCase("G2")) {
                CSVwrite.print("Argentina" + Separador + " " + Separador + " " + Separador + "X" + Separador + "Brasil"
                        + "\n");
            } else if (PrediccionP1R1.equalsIgnoreCase("E")) {
                CSVwrite.print("Argentina" + Separador + " " + Separador + "X" + Separador + " " + Separador + "Brasil"
                        + "\n");
            }
            if (PrediccionP2R1.equalsIgnoreCase("G1")) {
                CSVwrite.print(
                        "Uruguay" + Separador + "X" + Separador + " " + Separador + " " + Separador + "Chile" + "\n");
            } else if (PrediccionP2R1.equalsIgnoreCase("G2")) {
                CSVwrite.print(
                        "Uruguay" + Separador + " " + Separador + " " + Separador + "X" + Separador + "Chile" + "\n");
            } else if (PrediccionP2R1.equalsIgnoreCase("E")) {
                CSVwrite.print(
                        "Uruguay" + Separador + " " + Separador + "X" + Separador + " " + Separador + "Chile" + "\n");
            }
        } catch (IOException x) {
            x.printStackTrace();
        } finally {
            if (CSVwrite != null) {
                CSVwrite.close();
            }
        }

        //Se lee el archivo de predicciones y se comparan con los resultados
        List<Columnas> partidos;

        try {
            partidos = new CsvToBeanBuilder(new FileReader(pathPartidos))
                    .withType(Columnas.class).build().parse();
            System.out.print("\nResultados:");

            int contador = 0;

            for (Columnas Resultado : partidos) {
                String[] ColumnasRes = Resultado.getPartidos().split(";");

                equipo1 = ColumnasRes[0];
                equipo2 = ColumnasRes[3];
                int golesA = Integer.parseInt(ColumnasRes[1]);
                int golesB = Integer.parseInt(ColumnasRes[2]);

                if (contador == 0) {

                    if (golesA > golesB) {

                        if (PrediccionP1R1.equalsIgnoreCase("g1")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                    } else if (golesB > golesA) {

                        if (PrediccionP1R1.equalsIgnoreCase("g2")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                    } else if (golesB == golesA) {

                        if (PrediccionP1R1.equalsIgnoreCase("e")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                        System.out.println("empate");
                    }

                } else if (contador == 1) {

                    if (golesA > golesB) {

                        if (PrediccionP2R1.equalsIgnoreCase("g1")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                    } else if (golesB > golesA) {

                        if (PrediccionP2R1.equalsIgnoreCase("g2")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                    } else if (golesB == golesA) {

                        if (PrediccionP2R1.equalsIgnoreCase("e")) {
                            System.out.println("Correcto, te llevas un punto +1 punto");
                            Puntos++;
                        }

                        System.out.println("empate");
                    }

                }

                contador++;
            }

        } catch (IOException x) {
            x.printStackTrace();
        }
        System.out.println("\nPrograma de prediccion deportiva terminado\n" + Nombre.getNombre() + " tus puntos ganados son: (" + Puntos + ")");
    }

}
