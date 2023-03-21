package org.pintegradorg16c158.Predicciones;
import java.time.LocalDate;
import com.opencsv.bean.CsvBindByPosition;

public class Columnas {
    
	@CsvBindByPosition(position = 0)
	private String Partidos;
	@CsvBindByPosition(position = 1)
	private String GolesA;
	@CsvBindByPosition(position = 3)
	private String EquipoB;
	@CsvBindByPosition(position = 2)
        private String Empate;

    public String getEmpate() {
        return Empate;
    }

    public void setEmpate(String Empate) {
        this.Empate = Empate;
    }
        @CsvBindByPosition(position = 4)
	private Integer GolesB;

	public String getPartidos() {
		return Partidos;
	}
	
	public void setEquipoA(String equipoA) {
		Partidos = equipoA;
	}

	public String getGolesA() {
		return GolesA;
	}

	public void setGolesA(String golesA) {
		GolesA = golesA;
	}

	public String getEquipoB() {
		return EquipoB;
	}

	public void setEquipoB(String equipoB) {
		EquipoB = equipoB;
	}

	public Integer getGolesB() {
		return GolesB;
	}

	public void setGolesB(Integer golesB) {
		GolesB = golesB;
	}
}
