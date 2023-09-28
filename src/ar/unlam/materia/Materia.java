package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {
	
	private Integer codigo_materia;
	private String nombre;
	private ArrayList<Integer> codigoCorrelativa;
	private static int id=1;

	public Materia(String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo_materia = codigo;
		this.codigoCorrelativa = new ArrayList<>();
	}
	
	//Constructor con ID estatico
	public Materia(String nombre) {
		this.codigo_materia = id++;
		this.nombre = nombre;
		this.codigoCorrelativa = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCodigo_materia() {
		return codigo_materia;
	}
	
	public static int getId() {
		return id;
	}

	public void asignarCorrelativa(Integer codigoCorrelativa) {
		
		if(this.codigoCorrelativa.isEmpty()) {
			this.codigoCorrelativa.add(codigoCorrelativa);
			
		}else if(!this.buscarCorrelativaDiego(codigoCorrelativa))
			this.codigoCorrelativa.add(codigoCorrelativa);
		
	}

	//Me devuelve la coleccion de codigos de correlativas
	public ArrayList<Integer> getCodigoCorrelativa() {
		return codigoCorrelativa;
	}
	

	public void setCodigoCorrelativa(ArrayList<Integer> codigoCorrelativa) {
		this.codigoCorrelativa = codigoCorrelativa;
	}

	//Me permite eliminar un codigo de materia de las correlativas
	public void removerCorrelativa(Integer codigoCorrelativa) {
		this.codigoCorrelativa.remove(codigoCorrelativa);
	}

	//Me indica la cantidad de correlativas
	public Integer cantidadCorrelativas() {
		return codigoCorrelativa.size();
	}
	
	public Boolean buscarCorrelativaDiego(Integer codigo_correlativa) {
		Boolean resultado=this.codigoCorrelativa.contains(codigo_correlativa);
		return resultado;
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
