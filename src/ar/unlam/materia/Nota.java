package ar.unlam.materia;

public class Nota {
	private static Integer id=0;
	private Double valor;

	public Nota() {
		id++;
		this.valor = 0.0;
	}

	public Nota(Double valor) {
		id++;
		this.valor = valor;
	}

	public Double getValor() {

		return this.valor;
	}

	public void asignarValor(Double valor) {

		if (valor >= 1 && valor <= 10)
			this.valor = valor;
	}

	@Override
	public String toString() {
		return "Nota [ID "+id+ " valor=" + valor + "]";
	}

}
