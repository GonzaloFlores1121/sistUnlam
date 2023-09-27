package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

	// Datos
	private String nombre;
	private String apellido;
	private Integer dni;

	// Fechas
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	public Alumno(Integer dni,String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	// equals sobreEscrito para que compare Integer DNI
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Alumno   nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + "]";
	}

}