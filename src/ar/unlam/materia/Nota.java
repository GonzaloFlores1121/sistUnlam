package ar.unlam.materia;

public class Nota {
	private static Integer id = 0;
	private Double valor;
	private ClaseDeNota TipoDeNota;

//	public Nota() {
//		id++;
//		this.valor = 0.0;
//	}
//	
	public Nota() {
		this.valor = 0.0;
		this.TipoDeNota = null;
	}

	public Nota(Double nota, ClaseDeNota tipo) {
		this.valor = nota;
		this.TipoDeNota = tipo;
	}

//	public Nota(Double valor) {
//		id++;
//		this.valor = valor;
//	}

	public Double getValor() {

		return this.valor;
	}

	public ClaseDeNota getTipoDeNota() {
		return TipoDeNota;
	}

	public void asignarValor(Double valor) {

		if (valor >= 1 && valor <= 10)
			this.valor = valor;
	}

	public void asignarTipoDeNota(ClaseDeNota tipoDeNota) {
		TipoDeNota = tipoDeNota;
	}

	public void registrarNota(Double valor, ClaseDeNota tipoDeNota) {

		if (ClaseDeNota.RECUPERATORIO_1 != tipoDeNota && ClaseDeNota.RECUPERATORIO_2 != tipoDeNota) {
			this.asignarValor(valor);
			this.asignarTipoDeNota(tipoDeNota);
		}
	}

	public void recuperarNota(Nota nota, Double nuevoValor) {

		if (nota.getTipoDeNota() == ClaseDeNota.PRIMER_PARCIAL) {
			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_1);
			nota.asignarValor(nuevoValor);
		}
		if (nota.getTipoDeNota() == ClaseDeNota.SEGUNDO_PARCIAL) {
			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_2);
			nota.asignarValor(nuevoValor);
		}
	}

	@Override
	public String toString() {
		return "Nota [ID " + id + " valor=" + valor + "]";
	}

}
