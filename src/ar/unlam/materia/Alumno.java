package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

	private String nombre;
	private String apellido;
	private Integer dni;
	private static Integer id = 0;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

//	public Alumno(Integer dni, String apellido, String nombre) {
//		id++;
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.dni = dni;
//	}

	public Alumno(String nombre, String apellido, Integer dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		id++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombre() {

		return this.nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static Integer getId() {
		return id;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public static void setId(Integer id) {
		Alumno.id = id;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
		return "Alumno [ID " + id + " nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + "]";
	}

}
