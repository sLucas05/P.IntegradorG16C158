package org.pintegradorg16c158.Predicciones;

import java.util.Random;
import com.opencsv.bean.CsvBindByPosition;

public class Partido {

    @CsvBindByPosition(position = 0)
    private String equipo1;
    @CsvBindByPosition(position = 1)
    private int golesEquipo1;
    @CsvBindByPosition(position = 2)
    private String empate;
    @CsvBindByPosition(position = 3)
    private int golesEquipo2;
    @CsvBindByPosition(position = 4)
    private String equipo2;

    

        public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }
    
    
    private String equipoGanador;

    public String getGanador() {
        return equipoGanador;
    }

    public void setGanador(String ganador) {
        this.equipoGanador = ganador;
    }

    public Partido(String equipo1, String equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public String jugarPartido(String equipo1, String equipo2) {

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

        if (equipo1 == null || equipo2 == null) {
            System.out.println("No se puede jugar un partido sin dos equipos");
            return null;
        }

        Random random = new Random(); // crea un generador de números aleatorios
        int golesA = (random.nextInt(3) + 1);
        int golesB = (random.nextInt(3) + 1);

        this.golesEquipo1 = golesA;
        this.golesEquipo2 = golesB;

        if (golesEquipo1 > golesEquipo2) {
            equipoGanador = equipo1;
        } else if (golesEquipo2 > golesEquipo1) {
            equipoGanador = equipo2;
        } else {
            equipoGanador = "Empate";
        }

        try {
            System.out.println("\nEl partido se esta jugando...");
            Thread.sleep(3000);
            System.out.println("Partido finalizado");
        } catch (InterruptedException ex) {
        }

        return equipoGanador;
    }

}
