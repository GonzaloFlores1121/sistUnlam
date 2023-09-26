package ar.unlam.materia;

public class Nota {
	private static Integer idNota=0;
	private Integer id;
	private Double valor;
	private TipoNota tipo;

	public Nota() {
		id=++idNota;
		this.valor = 0.0;
	}

	public Nota(Double valor) {
		id=++idNota;
		this.valor = valor;
	}

	public Nota(Double valor, TipoNota tipo) {
		id=++idNota;
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

	
	public TipoNota getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

	

}
