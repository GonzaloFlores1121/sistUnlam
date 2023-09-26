package ar.unlam.materia;

import java.util.Objects;

public class Aula {

	private Integer numeroDeAula;
	private final Integer capacidadMax;

	public Aula(Integer numeroDeAula, Integer capacidadMax) {
		this.numeroDeAula = numeroDeAula;
		this.capacidadMax = capacidadMax;
	}

	public Integer getNumero() {
		return numeroDeAula;
	}

	public Integer getCapacidadMax() {
		return capacidadMax;
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
		return "Aula [numeroDeAula=" + numeroDeAula + ", capacidadMax=" + capacidadMax + "]";
	}


}
