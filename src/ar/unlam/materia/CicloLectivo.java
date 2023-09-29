package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	// ID
	private static Integer id = 1;
	private Integer idCiclo;
	// CicloLectivo
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	// Inscripcion
	private LocalDate fechaDeInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	// Cuatrimestre
	private Cuatrimestre cuatri;

	// Constructor pero con ID estatico en incremento
	public CicloLectivo(LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		this.idCiclo=id++;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaDeInicioInscripcion = fechaDeInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatri = cuatri;
	}
	
	// Constructor pero con ID como parametro para los test
	//Para los test el atributo estatico se mantiene
	public CicloLectivo(Integer id,LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioCicloLectivo,
			LocalDate fechaDeInicioInscripcion, LocalDate fechaFinalizacionInscripcion, Cuatrimestre cuatri) {
		this.idCiclo=id;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		
		this.fechaDeInicioInscripcion = fechaDeInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
		this.cuatri = cuatri;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getIdCiclo() {
		return idCiclo;
	}
	
	public void setId(Integer id){
		this.idCiclo=id;
	}

	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaDeInicioInscripcion() {
		return fechaDeInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public Cuatrimestre getCuatri() {
		return cuatri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuatri, fechaDeInicioInscripcion, fechaFinalizacionCicloLectivo,
				fechaFinalizacionInscripcion, fechaInicioCicloLectivo, idCiclo);
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
				|| Objects.equals(idCiclo, other.idCiclo);
	}
	

	@Override
	public String toString() {
		return "CicloLectivo [id=" + idCiclo + ", fechaFinalizacionCicloLectivo=" + fechaFinalizacionCicloLectivo
				+ ", fechaInicioCicloLectivo=" + fechaInicioCicloLectivo + ", fechaDeInicioInscripcion="
				+ fechaDeInicioInscripcion + ", fechaFinalizacionInscripcion=" + fechaFinalizacionInscripcion
				+ ", cuatri=" + cuatri + "]";
	}



}
