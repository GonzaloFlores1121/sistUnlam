package ar.unlam.materia;

public class Nota {
	private static Integer idNota=0;
	private Integer id;
	private Double valor;
	private TipoNota tipo;
	private Boolean esParcial1;

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


	public Nota(Double valor, TipoNota tipo, Boolean esParcial1) {
		id=++idNota;
		this.valor = valor;
		this.tipo = tipo;
		this.esParcial1 = esParcial1;
	}
	

	public Boolean getEsParcial1() {
		return esParcial1;
	}

	public void setEsParcial1(Boolean esParcial1) {
		this.esParcial1 = esParcial1;
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
	

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", valor=" + valor + ", tipo=" + tipo + "]";
	}

	

}
