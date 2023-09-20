package ar.unlam.materia;

import java.time.LocalDate;

public class Profesor {
	private static Integer id=0;
	private Integer dni;
	private String nombre;
	private String apellido;
	private Double saldo;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	public Profesor(Integer dni, String nombre, String apellido, Double saldo) {
		id++;
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.saldo=saldo;
	}
	

	public Profesor(Integer dni, String nombre, String apellido, Double saldo, LocalDate fechaNacimiento,
			LocalDate fechaIngreso) {
		id++;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.saldo = saldo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
	}


	public Integer getDni() {
		return dni;
	}


	@Override
	public String toString() {
		return "Profesor [id "+id+" dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", saldo=" + saldo
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + "]";
	}


}
