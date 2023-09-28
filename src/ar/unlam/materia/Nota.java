package ar.unlam.materia;

public class Nota {
	private Double valor;
	private ClaseDeNota TipoDeNota;

	private static Integer idNota = 0;
	private Integer id;
	private TipoNota tipo;
	private Boolean esParcial1;

	public Nota(Double valor) {
		id = ++idNota;
		this.valor = valor;
	}

	public Nota(Double valor, TipoNota tipo) {
		id = ++idNota;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Nota(Double valor, TipoNota tipo, Boolean esParcial1) {
		id = ++idNota;
		this.valor = valor;
		this.tipo = tipo;
		this.esParcial1 = esParcial1;
	}

	public Nota() {
		this.valor = 0.0;
		this.TipoDeNota = null;
	}

	public Nota(Double nota, ClaseDeNota tipo) {
		this.valor = nota;
		this.TipoDeNota = tipo;
	}

	public Double getValor() {
		return this.valor;
	}

	public ClaseDeNota getTipoDeNota() {
		return TipoDeNota;
	}

	public void asignarValor(Double valor) {
		this.valor = valor;
	}

	public void asignarTipoDeNota(ClaseDeNota tipoDeNota) {
		TipoDeNota = tipoDeNota;
	}

	public void registrarNota(Double valor, ClaseDeNota tipoDeNota) {

		if (ClaseDeNota.RECUPERATORIO_1 != tipoDeNota && ClaseDeNota.RECUPERATORIO_2 != tipoDeNota && tipoDeNota != null
				&& valor >= 1 && valor <= 10) {
			this.asignarValor(valor);
			this.asignarTipoDeNota(tipoDeNota);
		}
	}

	public void recuperarNota(Double nuevoValor) {

		if (this.TipoDeNota == ClaseDeNota.PRIMER_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10
				&& this.TipoDeNota != null) {
			this.TipoDeNota = ClaseDeNota.RECUPERATORIO_1;
			this.valor = nuevoValor;
		}
		if (this.TipoDeNota == ClaseDeNota.SEGUNDO_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10
				&& this.TipoDeNota != null) {
			this.TipoDeNota = ClaseDeNota.RECUPERATORIO_2;
			this.valor = nuevoValor;
		}
	}

	// Evaluar su uso
	public void recuperarNota(Nota nota, Double nuevoValor) {

		if (nota.getTipoDeNota() == ClaseDeNota.PRIMER_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10) {
			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_1);
			nota.asignarValor(nuevoValor);
		}
		if (nota.getTipoDeNota() == ClaseDeNota.SEGUNDO_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10) {
			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_2);
			nota.asignarValor(nuevoValor);
		}
	}

	@Override
	public String toString() {
		return "Nota [valor=" + valor + ", tipo=" + TipoDeNota + "]";
	}
	
	public Boolean getEsParcial1() {
		return esParcial1;
	}

	public void setEsParcial1(Boolean esParcial1) {
		this.esParcial1 = esParcial1;
	}
	
	
	public TipoNota getTipo() {
		return tipo;
	}
	

	public void setValor(Double valor) {
		this.valor = valor;
	}


	


}
