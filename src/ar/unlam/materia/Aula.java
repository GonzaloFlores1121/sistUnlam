package ar.unlam.materia;

import java.util.Objects;

public class Aula {
	private static Integer id=0;
	private Integer numero;
	private Integer capacidadActual;
	private final Integer capacidadMax;



	public Aula(Integer numero, Integer capacidadActual, Integer capacidadMax) {
		this.id = ++id;
		this.numero = numero;
		this.capacidadActual = capacidadActual;
		this.capacidadMax = capacidadMax;
	}

	@Override
	public String toString() {
		return "Aula [numero=" + numero + ", capacidadMax=" + capacidadMax + "]";
	}

	public void setCapacidadActual(Integer capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public Integer getCapacidadMax() {
		return capacidadMax;
	}

	public Integer getCapacidadActual() {
		return capacidadActual;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
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
		return Objects.equals(numero, other.numero);
	}

	public Integer getNumero() {
		return numero;
	}

}
