package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {
	
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaDeInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private Cuatrimestre cuatri;
	private static Integer idCiclo=0;

	
	

	public CicloLectivo( LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		idCiclo++;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaDeInicioInscripcion = fechaDeInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatri = cuatri;
	}

	public CicloLectivo(Integer id, LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		idCiclo++;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaDeInicioInscripcion = fechaDeInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatri = cuatri;
	}

	
	public LocalDate getFechaDeInicioInscripcion() {
		return fechaDeInicioInscripcion;
	}


	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}


	
	
	@Override
	public int hashCode() {
		return Objects.hash(cuatri, fechaDeInicioInscripcion, fechaFinalizacionCicloLectivo,
				fechaFinalizacionInscripcion, fechaInicioCicloLectivo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CicloLectivo other = (CicloLectivo) obj;
		return cuatri == other.cuatri && Objects.equals(fechaDeInicioInscripcion, other.fechaDeInicioInscripcion)
				&& Objects.equals(fechaFinalizacionCicloLectivo, other.fechaFinalizacionCicloLectivo)
				&& Objects.equals(fechaFinalizacionInscripcion, other.fechaFinalizacionInscripcion)
				&& Objects.equals(fechaInicioCicloLectivo, other.fechaInicioCicloLectivo);
	}

	public Integer getId() {
		return idCiclo;
	}


	@Override
	public String toString() {
		return "CicloLectivo [id=" + idCiclo + ", fechaFinalizacionCicloLectivo=" + fechaFinalizacionCicloLectivo
				+ ", fechaInicioCicloLectivo=" + fechaInicioCicloLectivo + ", fechaDeInicioInscripcion="
				+ fechaDeInicioInscripcion + ", fechaFinalizacionInscripcion=" + fechaFinalizacionInscripcion
				+ ", cuatri=" + cuatri + "]";
	}

}
