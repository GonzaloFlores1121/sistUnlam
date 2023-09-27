package ar.unlam.materia;

import java.time.LocalDate;
import java.util.Objects;

public class Profesor {
	
	private Integer dni;
	private String nombre;
	private String apellido;
//	private Double saldo;// REVISAR
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	public Profesor(Integer dni,String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}
//	REVISAR CONSTRUCTORES
//	public Profesor(Integer dni, String nombre, String apellido, Double saldo) {
//		
//		this.dni=dni;
//		this.nombre=nombre;
//		this.apellido=apellido;
//		this.saldo=saldo;
//	}
//	
//	public Profesor(Integer dni, String nombre, String apellido, Double saldo, LocalDate fechaNacimiento,
//			LocalDate fechaIngreso) {
//		
//		this.dni = dni;
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.saldo = saldo;
//		this.fechaNacimiento = fechaNacimiento;
//		this.fechaIngreso = fechaIngreso;
//	}


	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

//	public Double getSaldo() {
//		return saldo;
//	}

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Profesor  dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido +
				", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + "]";
	}
}
