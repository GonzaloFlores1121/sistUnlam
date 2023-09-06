package ar.unlam.materia;

import java.time.LocalDate;

public class CicloLectivo {

	private LocalDate fechaDeInicio;
	private Cuatrimestre cuatri;

	public CicloLectivo(LocalDate fechaDeInicio, Cuatrimestre cuatri) {
		this.fechaDeInicio = fechaDeInicio;
		this.cuatri = cuatri;
	}

}
