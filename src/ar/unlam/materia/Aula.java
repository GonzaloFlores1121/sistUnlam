package ar.unlam.materia;

public class Aula {

	private Integer numero;
	private Integer capacidadMax;

	public Aula(Integer numero, Integer capacidadMax) {
		this.numero = numero;
		this.capacidadMax = capacidadMax;
	}

	@Override
	public String toString() {
		return "Aula [numero=" + numero + ", capacidadMax=" + capacidadMax + "]";
	}
	
}
