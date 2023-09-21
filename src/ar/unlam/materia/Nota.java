package ar.unlam.materia;

public class Nota {

	private Double valor;
	private TipoNota tipo;

	public Nota() {

		this.valor = 0.0;
	}

	public Nota(Double valor) {

		this.valor = valor;
	}

	public Nota(Double valor, TipoNota tipo) {
		this.valor = valor;
		this.tipo = tipo;
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
		return "Nota [valor=" + valor + ", tipo=" + tipo + "]";
	}

}
