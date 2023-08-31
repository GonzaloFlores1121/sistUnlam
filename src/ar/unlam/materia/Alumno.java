package ar.unlam.materia;

public class Alumno {
	private Integer codigo_alumno;
	private String nombre;
	private String apellido;
	private Integer dni;

	public Alumno(Integer codigo_alumno,Integer dni, String apellido, String nombre) {
		this.codigo_alumno=codigo_alumno;
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}

	public String  getNombre() {
		// TODO Auto-generated method stub
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

	public Integer getCodigo_alumno() {
		return codigo_alumno;
	}

	public void setCodigo_alumno(Integer codigo_alumno) {
		this.codigo_alumno = codigo_alumno;
	}

}
