package ar.unlam.materia;

import java.util.Objects;

public class Aula {
<<<<<<< HEAD
	private static Integer id=0;
	
	private Integer numeroDeAula;
	private Integer capacidadActual;
	private final Integer CAPACIDADMAX;
=======

	private Integer numeroDeAula;
	private final Integer capacidadMax;
>>>>>>> main

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
<<<<<<< HEAD
	
=======
>>>>>>> main

	public Integer getNumero() {
		return numeroDeAula;
	}

	public Integer getCapacidadMax() {
<<<<<<< HEAD
		return CAPACIDADMAX;
	}
	
	public void setCapacidadActual(Integer capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public Integer getCapacidadActual() {
		return capacidadActual;
=======
		return capacidadMax;
>>>>>>> main
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
<<<<<<< HEAD
		return "Aula [ID "+id+ " numero=" + numeroDeAula + ", capacidadMax=" + CAPACIDADMAX + "]";
=======
		return "Aula [numeroDeAula=" + numeroDeAula + ", capacidadMax=" + capacidadMax + "]";
>>>>>>> main
	}


}
