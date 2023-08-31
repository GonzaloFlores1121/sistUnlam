package ar.unlam.materia;

public class Materia {
	private Integer codigo_materia;
	private String nombre;
	private Integer[] codigo_materias_correlativas;

	public Materia(String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo_materia = codigo;
	}

	public Materia(Integer codigo_materia, String nombre, Integer[] codigo_materias) {
		this.codigo_materia = codigo_materia;
		this.nombre = nombre;
		this.codigo_materias_correlativas = codigo_materias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo_materia() {
		return codigo_materia;
	}

	public void setCodigo_materia(Integer codigo_materia) {
		this.codigo_materia = codigo_materia;
	}

	public Integer[] getCodigo_materias_correlativas() {
		return codigo_materias_correlativas;
	}

	public void setCodigo_materias_correlativas(Integer[] codigo_materias_correlativas) {
		this.codigo_materias_correlativas = codigo_materias_correlativas;
	}

}
