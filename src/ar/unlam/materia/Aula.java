package ar.unlam.materia;

import java.util.Objects;

public class Aula {
	private static Integer id=0;
	
	private Integer numeroDeAula;
	private Integer capacidadActual;
	private final Integer CAPACIDADMAX;

	public Aula(Integer numeroDeAula, Integer capacidadActual, Integer capacidadMax) {
		id++;
		this.numeroDeAula = numeroDeAula;
		this.capacidadActual = capacidadActual;
		this.CAPACIDADMAX = capacidadMax;
	}
	//Constructor Diego
	public Aula(Integer numeroDeAula, Integer capacidadMax) {
		this.numeroDeAula = numeroDeAula;
//		this.capacidadActual = capacidadActual;
		this.CAPACIDADMAX = capacidadMax;
	}

	public Integer getNumero() {
		return numeroDeAula;
	}

	public Integer getCapacidadMax() {
		return CAPACIDADMAX;
	}
	
	public void setCapacidadActual(Integer capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public Integer getCapacidadActual() {
		return capacidadActual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDeAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(numeroDeAula, other.numeroDeAula);
	}

	@Override
	public String toString() {
		return "Aula [numeroDeAula=" + numeroDeAula + ", capacidadMax=" + CAPACIDADMAX + "]";
	}


}
