package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

	//Datos
	private String nombre;
	private String apellido;
	private Integer dni;
	//IDs
	private static Integer id = 0;
	private Integer indicador = 0;
	//Fechas
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	// Constructor innecesario
//	public Alumno(Integer dni, String apellido, String nombre) {
//		id++;
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.dni = dni;
//	}

	//ID estatico
	public Alumno(String nombre, String apellido, Integer dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		id++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}
	
	//Id por parametro
	public Alumno(Integer indicador,String nombre, String apellido, Integer dni, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		this.indicador=indicador;
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

	public Integer getIndicador() {
		return indicador;
	}

	public void setIndicador(Integer indicador) {
		this.indicador = indicador;
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
