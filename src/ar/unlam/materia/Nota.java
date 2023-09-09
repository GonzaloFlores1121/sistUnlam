package ar.unlam.materia;

public class Nota {

	private Double valor;
	
	public Nota () {
		this.valor=0.0;
	}
	public Nota(Double valor) {
		this.valor=valor;
	}

	public Double getValor() {
		// TODO Auto-generated method stub
		return this.valor;
	}

	public void asignarValor(Double valor) {
	
		if(valor >=1 && valor<=10)
		     this.valor=valor;
	}
	@Override
	public String toString() {
		return "Nota [valor=" + valor + "]";
	}
	

	

}
