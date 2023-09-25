package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {
	
	private Integer codigo_materia;
	private String nombre;
	private ArrayList<Integer> codigoCorrelativa;

	public Materia(String nombre, Integer codigo) {
		
		this.nombre = nombre;
		this.codigo_materia = codigo;
		this.codigoCorrelativa = new ArrayList<>();

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

	public void asignarCorrelativa(Integer codigoCorrelativa) {
		this.codigoCorrelativa.add(codigoCorrelativa);
	}

	public ArrayList<Integer> getCodigoCorrelativa() {
		return codigoCorrelativa;
	}

	public void removerCorrelativa(Integer codigoCorrelativa) {
		this.codigoCorrelativa.remove(codigoCorrelativa);
	}

	public Integer cantidadCorrelativas() {
		return codigoCorrelativa.size();

	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_materia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(codigo_materia, other.codigo_materia);
	}

	@Override
	public String toString() {
		return "Materia  codigo_materia=" + codigo_materia + ", nombre=" + nombre + ", codigoCorrelativa="
				+ codigoCorrelativa + "]";
	}

	public void setCodigoCorrelativa(ArrayList<Integer> codigoCorrelativa) {
		this.codigoCorrelativa = codigoCorrelativa;
	}

	public Integer buscarCorrelativa(Integer codigo_materia2) {
		Integer operacion = 0;

		for (Integer integer : codigoCorrelativa) {
			if (integer.equals(codigo_materia2)) {
				operacion = 1;
				return operacion;
			}
		}
		return operacion;
	}

}
