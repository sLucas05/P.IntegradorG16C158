package org.pintegradorg16c158.Predicciones;
import com.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.io.BufferedReader;
public class MainApp {
	public static void main(String[] args) throws IOException, CsvException {
		if (args.length < 2) {
			System.out.println(
					"\nDebe ingresar la ruta de los archivos [Partidos.csv - Prediccion.csv] en ese orden\n(El nombre de los archivos puede ser modificados pero no la extension .csv)");
			return;
		}
		ArrayList<String> equipos = new ArrayList<String>();
		equipos.add("Argentina");
		equipos.add("Chile");
		equipos.add("Uruguay");
		equipos.add("Paraguay");
		equipos.add("Colombia");
		equipos.add("Ecuador");
		equipos.add("Brasil");
		equipos.add("Mexico");
		equipos.add("Portugal");
		equipos.add("Francia");
		equipos.add("Inglaterra");
		equipos.add("Alemania");
		equipos.add("Polonia");
		equipos.add("Marruecos");
		equipos.add("Croacia");
		equipos.add("Senegal");

		Scanner scanner = new Scanner(System.in);
		PrintWriter EscritorPart = null;
		PrintWriter EscritorPredi = null;
		Usuario Nombre = null;
		String equipo1, equipo2;
		String Prediccion = "";
		String Separador = ",";
		String Seguir = "Si";
		String Jugar = "1";
		String pathPartidos = args[0];
		String pathPrediccion = args[1];
		FileWriter PuntajeClear = new FileWriter("Puntajes.txt");
		PuntajeClear.write("");
		PuntajeClear.close();

		System.out.println("\nArgentina Programa 4.0 - Desarrollador Java Inicial (UTN)");
		System.out.println("Proyecto Integrador (Predicciones Deportivas)");
		System.out.println("Comision 158 Grupo 16 (Entrega 2)");
		System.out.println("\nLos valores de prediccion son:");
		System.out.println("G1 (Gana el Equipo 1) / E (Empate) / G2 (Gana el Equipo 2)");
		System.out.println("\nIniciar programa de Predicciones Deportivas (press enter)...");
		scanner.nextLine();

		while (Jugar.equalsIgnoreCase("1")) {
			Jugar = "";
			System.out.println("Escriba su nombre de usuario...");
			String NombreUsuario = scanner.nextLine();
			Nombre = new Usuario(NombreUsuario);
			System.out.println("\n¿Cuantos partidos desea que se jueguen por ronda?");
			String PartxRond = scanner.nextLine();

			Random random = new Random();
			EscritorPart = new PrintWriter(new FileWriter(pathPartidos));
			EscritorPredi = new PrintWriter(new FileWriter(pathPrediccion));
			int Puntos = 0;
			int PartNum = 1;
			int RondNum = 1;
			while (Seguir.equalsIgnoreCase("Si")) {
				int randomA = (random.nextInt(8));
				int randomB = (random.nextInt(8) + 8);
				equipo1 = equipos.get(randomA);
				equipo2 = equipos.get(randomB);
				try {
					System.out.println("\nPartido [" + PartNum + "] de la Ronda [" + RondNum + "]");
					System.out.println("(1)" + equipo1 + " vs " + equipo2 + "(2)");
					System.out.println("\nRealice su prediccion...");
					Prediccion = scanner.nextLine();
					Partido partido = new Partido(equipo1, equipo2);
					String ganador = partido.jugarPartido(equipo1, equipo2);
					EscritorPart.print(equipo1 + Separador + partido.getGolesEquipo1() + Separador
							+ partido.getGolesEquipo2() + Separador + equipo2 + "\n");
					if (Prediccion.equalsIgnoreCase("G1")) {
						EscritorPredi.print(equipo1 + Separador + "X" + Separador + " " + Separador + " " + Separador
								+ equipo2 + "\n");
					} else if (Prediccion.equalsIgnoreCase("G2")) {
						EscritorPredi.print(equipo1 + Separador + " " + Separador + " " + Separador + "X" + Separador
								+ equipo2 + "\n");
					} else if (Prediccion.equalsIgnoreCase("E")) {
						EscritorPredi.print(equipo1 + Separador + " " + Separador + "X" + Separador + " " + Separador
								+ equipo2 + "\n");
					}
					System.out.println("\n¿Desea predecir otro partido? (SI/NO)");
					Seguir = scanner.nextLine();
					if (PartNum == Integer.parseInt(PartxRond)) {
						PartNum = 1;
						RondNum++;
					} else {
						PartNum++;
					}
				} catch (Exception x) {
					x.printStackTrace();
				} finally {
				}
			}

			EscritorPart.close();
			EscritorPredi.close();

			try {
				CSVReader PartidosRead = new CSVReader(new FileReader(pathPartidos));
				try {
					List<String[]> filas = PartidosRead.readAll();
					for (String[] fila : filas) {
						equipo1 = fila[0];
						equipo2 = fila[3];
						int golesA = Integer.parseInt(fila[1]);
						int golesB = Integer.parseInt(fila[2]);
						Partido match = new Partido(equipo1, equipo2);
						match.setGolesEquipo1(golesA);
						match.setGolesEquipo2(golesB);
						{
							if (golesA > golesB) {
								System.out.println("\n[" + match.getGolesEquipo1() + "]" + match.getEquipo1() + " - "
										+ match.getEquipo2() + "[" + match.getGolesEquipo2() + "] // Gano ["
										+ match.getEquipo1() + "]");
								if (Prediccion.equalsIgnoreCase("g1")) {
									System.out.println("Tu prediccion fue correcta, +1 punto.");
									Puntos++;
								}
							} else if (golesB > golesA) {
								System.out.println("\n[" + match.getGolesEquipo1() + "]" + match.getEquipo1() + " - "
										+ match.getEquipo2() + "[" + match.getGolesEquipo2() + "] // Gano ["
										+ match.getEquipo2() + "]");
								if (Prediccion.equalsIgnoreCase("g2")) {
									System.out.println("Tu prediccion fue correcta, +1 punto.");
									Puntos++;
								}
							} else if (golesB == golesA) {
								System.out.println("\n[" + match.getGolesEquipo1() + "]" + match.getEquipo1() + " - "
										+ match.getEquipo2() + "[" + match.getGolesEquipo2() + "] // Empate");
								if (Prediccion.equalsIgnoreCase("e")) {
									System.out.println("Tu prediccion fue correcta, +1 punto.");
									Puntos++;
								}
							}
						}
					}
				} catch (CsvValidationException z) {
					z.printStackTrace();
				} catch (CsvException y) {
					Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, y);
				}
			} catch (IOException x) {
				x.printStackTrace();
			}
			System.out.println("\n" + Nombre.getNombre() + " tus puntos ganados son: (" + Puntos
					+ ")\n---------------------------\n[1] Jugar con otro Usuario\n[2] Ver tabla de puntajes\n[3] Finalizar programa");
			FileWriter Puntajes = new FileWriter("Puntajes.txt", true);
			BufferedWriter EscritorPuntajes = new BufferedWriter(Puntajes);
			EscritorPuntajes.write("[Usuario]: " + Nombre.getNombre() + "\n[Puntos]: " + Puntos + "\n\n");
			EscritorPuntajes.close();
			Jugar = scanner.nextLine();
			if (Jugar.equalsIgnoreCase("1")) {
				Seguir = "Si";
				Puntos = 0;
				PartNum = 1;
				RondNum = 1;
				System.out.println("");
			} else if (Jugar.equalsIgnoreCase("2")) {
				try {
					System.out.println("");
					FileReader Tabla = new FileReader("Puntajes.txt");
					BufferedReader ReadTabla = new BufferedReader(Tabla);
					String Resultados;
					while ((Resultados = ReadTabla.readLine()) != null) {
						System.out.println(Resultados);
					}
					ReadTabla.close();
					System.out.println(
							"(Archivo 'Puntajes.txt' generado exitosamente en la carpeta raiz de tu usuario)\n\n¡Gracias por utilizar nuestro programa de predicciones deportivas!\nCerrando...");
				} catch (IOException x) {
					x.printStackTrace();
				}
			} else if (Jugar.equalsIgnoreCase("3")) {
				System.out.println("\n¡Gracias por utilizar nuestro programa de predicciones deportivas!\nCerrando...");
			}
		}
	}
}
