package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {
	private Integer id;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaDeInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private Cuatrimestre cuatri;

	public CicloLectivo(Integer id, LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		this.id = id;
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
				fechaFinalizacionInscripcion, fechaInicioCicloLectivo, id);
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
				&& Objects.equals(fechaInicioCicloLectivo, other.fechaInicioCicloLectivo)
				|| Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CicloLectivo [id=" + id + ", fechaFinalizacionCicloLectivo=" + fechaFinalizacionCicloLectivo
				+ ", fechaInicioCicloLectivo=" + fechaInicioCicloLectivo + ", fechaDeInicioInscripcion="
				+ fechaDeInicioInscripcion + ", fechaFinalizacionInscripcion=" + fechaFinalizacionInscripcion
				+ ", cuatri=" + cuatri + "]";
	}

}
