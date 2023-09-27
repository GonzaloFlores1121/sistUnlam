package ar.unlam.materia;
public class Nota {
	private Double valor;
	private ClaseDeNota TipoDeNota;

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

		if (ClaseDeNota.RECUPERATORIO_1 != tipoDeNota && ClaseDeNota.RECUPERATORIO_2 != tipoDeNota && tipoDeNota!=null && valor >= 1 && valor <= 10) {
			this.asignarValor(valor);
			this.asignarTipoDeNota(tipoDeNota);
		}
	}

	public void recuperarNota(Double nuevoValor) {
		
		if (this.TipoDeNota == ClaseDeNota.PRIMER_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10 && this.TipoDeNota!=null) {
//			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_1);
			this.TipoDeNota=ClaseDeNota.RECUPERATORIO_1;
			this.valor=nuevoValor;
//			nota.asignarValor(nuevoValor);
		}
		if (this.TipoDeNota == ClaseDeNota.SEGUNDO_PARCIAL && nuevoValor >= 1 && nuevoValor <= 10 && this.TipoDeNota!=null) {
//			nota.asignarTipoDeNota(ClaseDeNota.RECUPERATORIO_2);
//			nota.asignarValor(nuevoValor);
			this.TipoDeNota=ClaseDeNota.RECUPERATORIO_2;
			this.valor=nuevoValor;
		}
	}
	
	//Evaluar su uso
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
//		return "Nota [ID " + id + " valor=" + valor + "]";
		return "Nota [valor=" + valor + ", tipo=" + TipoDeNota + "]";
	}

}
