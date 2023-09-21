package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	// CicloLectivo
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioCicloLectivo;
	// Inscripcion
	private LocalDate fechaDeInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	// Cuatrimestre
	private Cuatrimestre cuatri;
	// ID
	private static Integer id = 0;

//	//ID provisorio, atributo inncesario por el id de arriba
	private Integer idCiclo;// atributo provisorio

	// Constructor pero con ID estatico en incremento
	public CicloLectivo(LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		idCiclo = ++id;
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

	public Integer getId() {
		return id;
	}

	public Integer getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Integer idCiclo) {
		this.idCiclo = idCiclo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuatri, fechaDeInicioInscripcion, fechaFinalizacionCicloLectivo,
				fechaFinalizacionInscripcion, fechaInicioCicloLectivo);
	}

	@Override
//	Compara fechas de inscripcion y fechas de inicio y fin de ciclo
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

	@Override
	public String toString() {
		return "CicloLectivo [id=" + idCiclo + ", fechaFinalizacionCicloLectivo=" + fechaFinalizacionCicloLectivo
				+ ", fechaInicioCicloLectivo=" + fechaInicioCicloLectivo + ", fechaDeInicioInscripcion="
				+ fechaDeInicioInscripcion + ", fechaFinalizacionInscripcion=" + fechaFinalizacionInscripcion
				+ ", cuatri=" + cuatri + "]";
	}

}
