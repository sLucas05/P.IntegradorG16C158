package org.pintegradorg16c158.Predicciones;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Debes ingresar la ruta de los archivos, primero la del archivo csv partidos y luego el de prediccion");
            return;
        }

        PrintWriter CSVwrite = null;
        Usuario Nombre = null;
        String PrediccionP1R1 = "", PrediccionP2R1 = "";
        String equipo1, equipo2, equipo3, equipo4;
        String Separador = ",";
        String pathPartidos = args[0];
        String pathPrediccion = args[1];
        int Puntos = 0;

        equipo1 = ("Argentina");
        equipo2 = ("Brasil");
        equipo3 = ("Uruguay");
        equipo4 = ("Chile");

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Argentina Programa 4.0 - Desarrollador Java Inicial (UTN)");
            System.out.println("Proyecto Integrador (Predicciones Deportivas)");
            System.out.println("Comision 158 Grupo 16 (Entrega 1)");
            System.out.println("\nLos valores de prediccion son:");
            System.out.println("G1 (Gana el Equipo 1) / E (Empate) / G2 (Gana el Equipo 2)");
            System.out.println("\nIniciar programa de Predicciones Deportivas (press enter)...");
            scanner.nextLine();

            System.out.println("Escriba su nombre de usuario...");
            String NombreUsuario = scanner.nextLine();
            Nombre = new Usuario(NombreUsuario);

            System.out.println("\nPartido [1] de la Ronda [1]");
            System.out.println("(g1)Argentina vs Brasil(g2)");
            System.out.println("\nRealice su prediccion...");
            PrediccionP1R1 = scanner.nextLine();

            Partido partido1 = new Partido(equipo1, equipo2);

            String ganador1 = partido1.jugarPartido(equipo1, equipo2);

            System.out.println("\nSiguiente partido (press enter)...");
            scanner.nextLine();

            System.out.println("Partido [2] de la Ronda [1]");
            System.out.println("(g1)Uruguay vs Chile(g2)");
            System.out.println("\nRealice su prediccion...");
            PrediccionP2R1 = scanner.nextLine();

            Partido partido2 = new Partido(equipo3, equipo4);

            String ganador2 = partido2.jugarPartido(equipo3, equipo4);

            //Una vez jugados los partidos se almacenan los resultados en el archivo csv especificado
            CSVwrite = new PrintWriter(new FileWriter(pathPartidos));

            CSVwrite.print(equipo1 + Separador + partido1.getGolesEquipo1() + Separador
                    + partido1.getGolesEquipo2() + Separador + equipo2 + "\n");

            CSVwrite.print(equipo3 + Separador + partido2.getGolesEquipo1() + Separador
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

        try {

            CSVReader reader = new CSVReader(new FileReader(pathPartidos));

            int contador = 0;

            try {

                List<String[]> filas = reader.readAll();

                for (String[] fila : filas) {

                    equipo1 = fila[0];
                    equipo2 = fila[3];
                    int golesA = Integer.parseInt(fila[1]);
                    int golesB = Integer.parseInt(fila[2]);

                    Partido match = new Partido(equipo1, equipo2);

                    match.setGolesEquipo1(golesA);
                    match.setGolesEquipo2(golesB);

                    System.out.println("");
                    System.out.println("-----------------------------------------------------------");

                    if (contador == 0) {

                        if (golesA > golesB) {

                            System.out.println("El ganador del partido entre " + match.getEquipo1() + " y " + match.getEquipo2()
                                    + " es " + match.getEquipo1() + " con " + match.getGolesEquipo1() + " goles " + " Resultados: " + match.getGolesEquipo1() + "/" + match.getGolesEquipo2());

                            if (PrediccionP1R1.equalsIgnoreCase("g1")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        } else if (golesB > golesA) {

                            System.out.println("El ganador del partido entre " + match.getEquipo1() + " y " + match.getEquipo2() + " es " + match.getEquipo2() + " con " + match.getGolesEquipo2()
                                    + " goles " + " Resultados: " + match.getGolesEquipo1() + "/" + match.getGolesEquipo2());

                            if (PrediccionP1R1.equalsIgnoreCase("g2")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        } else if (golesB == golesA) {

                            System.out.println("El ganador del partido entre " + match.getEquipo1() + " y " + match.getEquipo2() + " es " + "EMPATE" + " Resultados: " + match.getGolesEquipo1()
                                    + "/" + match.getGolesEquipo2());

                            if (PrediccionP1R1.equalsIgnoreCase("e")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        }

                    } else if (contador == 1) {

                        if (golesA > golesB) {

                            System.out.println("El ganador del partido entre " + equipo1 + " y " + equipo2 + " es " + equipo1 + " con " + golesA + " goles " + " Resultados: " + golesA + "/" + golesB);

                            if (PrediccionP2R1.equalsIgnoreCase("g1")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        } else if (golesB > golesA) {

                            System.out.println("El ganador del partido entre " + equipo1 + " y " + equipo2 + " es " + equipo2 + " con " + golesB + " goles " + " Resultados: " + golesA + "/" + golesB);

                            if (PrediccionP2R1.equalsIgnoreCase("g2")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        } else if (golesB == golesA) {

                            System.out.println("El ganador del partido entre " + equipo1 + " y " + equipo2 + " es " + "EMPATE" + " Resultados: " + golesA + "/" + golesB);

                            if (PrediccionP2R1.equalsIgnoreCase("e")) {
                                System.out.println("Correcto, te llevas un punto +1 punto");
                                Puntos++;
                            }

                        }

                    }

                    System.out.println("-----------------------------------------------------------");

                    contador++;

                }
            } catch (CsvValidationException ex) {
                ex.printStackTrace();
            } catch (CsvException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException x) {
            x.printStackTrace();
        }
        System.out.println("\nPrograma de prediccion deportiva terminado\n" + Nombre.getNombre() + " tus puntos ganados son: (" + Puntos + ")");
    }

}
