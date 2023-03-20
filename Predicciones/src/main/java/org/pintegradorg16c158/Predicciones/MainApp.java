package org.pintegradorg16c158.Predicciones;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.opencsv.bean.CsvToBeanBuilder;
public class MainApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String pathPartidos = "src/main/resources/Partidos.csv";
		String pathPrediccion = "src/main/resources/Prediccion.csv";
		String Separador = ";";
		int Puntos = 0;

		PrintWriter CSVwrite = null;
		try {
			CSVwrite = new PrintWriter(new FileWriter(pathPartidos));
			CSVwrite.print("Argentina" + Separador + (int) (Math.random() * 3 + 1) + Separador
					+ (int) (Math.random() * 3 + 1) + Separador + "Brasil" + "\n");
			CSVwrite.print("Uruguay" + Separador + (int) (Math.random() * 3 + 1) + Separador
					+ (int) (Math.random() * 3 + 1) + Separador + "Chile" + "\n");
		} catch (IOException x) {
			x.printStackTrace();
		} finally {
			if (CSVwrite != null) {
				CSVwrite.close();
			}
		}

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
		System.out.println("(1)Argentina vs Brasil(2)");
		System.out.println("\nRealice su prediccion...");
		String PrediccionP1R1 = scanner.nextLine();
		try {
			System.out.println("\nEl partido se esta jugando...");
			Thread.sleep(3000);
			System.out.println("Partido finalizado");
		} catch (InterruptedException ex) {
		}

		System.out.println("\nSiguiente partido (press enter)...");
		scanner.nextLine();

		System.out.println("Partido [2] de la Ronda [1]");
		System.out.println("(1)Uruguay vs Chile(2)");
		System.out.println("\nRealice su prediccion...");
		String PrediccionP2R1 = scanner.nextLine();

		try {
			System.out.println("\nEl partido se esta jugando...");
			Thread.sleep(3000);
			System.out.println("Partido finalizado");
		} catch (InterruptedException ex) {
		}

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

		List<Columnas> Resultados;
		try {
			Resultados = new CsvToBeanBuilder(new FileReader("src/main/resources/Partidos.csv"))
					.withType(Columnas.class).build().parse();
			System.out.print("\nResultados:");
			for (Columnas Resultado : Resultados) {
				String[] ColumnasRes = Resultado.getEquipoA().split(";");
				if (Integer.parseInt(ColumnasRes[1]) > Integer.parseInt(ColumnasRes[2])) {
					System.out.println("\n[" + ColumnasRes[1] + "]" + ColumnasRes[0] + " - " + ColumnasRes[3] + "["
							+ ColumnasRes[2] + "] // Gano [" + ColumnasRes[0] + "]");
					if (PrediccionP1R1.equalsIgnoreCase("G1")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					} else if (PrediccionP2R1.equalsIgnoreCase("G1")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					}
				} else if (Integer.parseInt(ColumnasRes[1]) < Integer.parseInt(ColumnasRes[2])) {
					System.out.println("\n[" + ColumnasRes[1] + "]" + ColumnasRes[0] + " - " + ColumnasRes[3] + "["
							+ ColumnasRes[2] + "] // Gano [" + ColumnasRes[3] + "]");
					if (PrediccionP1R1.equalsIgnoreCase("G2")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					} else if (PrediccionP2R1.equalsIgnoreCase("G2")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					}
				} else if (Integer.parseInt(ColumnasRes[1]) == Integer.parseInt(ColumnasRes[2])) {
					System.out.println("\n[" + ColumnasRes[1] + "]" + ColumnasRes[0] + " - " + ColumnasRes[3] + "["
							+ ColumnasRes[2] + "] // Empate");
					if (PrediccionP1R1.equalsIgnoreCase("E")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					} else if (PrediccionP2R1.equalsIgnoreCase("E")) {
						System.out.println("Tu prediccion fue correcta, +1 punto.");
						Puntos++;
					}
				}
			}
		} catch (IOException x) {
			x.printStackTrace();
		}
		System.out.println("\nPrograma de prediccion deportiva terminado\n"+Nombre.getNombre()+" tus puntos ganados son: (" + Puntos + ")");
	}
}
