package ar.unlam.materia;

public class Profesor {

	private Integer dni;
	private String nombre;
	private String apellido;
	private Double saldo;

	public Profesor(Integer dni, String nombre, String apellido, Double saldo) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.saldo=saldo;
	}

	public Integer getDni() {
		return dni;
	}

}
