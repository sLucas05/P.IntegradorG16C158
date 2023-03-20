package org.pintegradorg16c158.Predicciones;
import java.time.LocalDate;
import com.opencsv.bean.CsvBindByPosition;
public class Columnas {
	@CsvBindByPosition(position = 0)
	private String EquipoA;
	@CsvBindByPosition(position = 1)
	private String GolesA;
	@CsvBindByPosition(position = 3)
	private LocalDate EquipoB;
	@CsvBindByPosition(position = 2)
	private Integer GolesB;

	public String getEquipoA() {
		return EquipoA;
	}
	
	public void setEquipoA(String equipoA) {
		EquipoA = equipoA;
	}

	public String getGolesA() {
		return GolesA;
	}

	public void setGolesA(String golesA) {
		GolesA = golesA;
	}

	public LocalDate getEquipoB() {
		return EquipoB;
	}

	public void setEquipoB(LocalDate equipoB) {
		EquipoB = equipoB;
	}

	public Integer getGolesB() {
		return GolesB;
	}

	public void setGolesB(Integer golesB) {
		GolesB = golesB;
	}
}
