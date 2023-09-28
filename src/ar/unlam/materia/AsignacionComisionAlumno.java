package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Objects;

public class AsignacionComisionAlumno {
	
	private static int id=1;
	private static int cantidadDeParciales=2;
	
	private Integer idComisionAlumno;
	private Integer codigo_comision;
	private Integer dniAlumno;
//	 ideal usar el array de notas
	private ArrayList<Nota> notas;
	// pongo los parciales de una para hacer mas facil los test que ya tenia
	private Nota parcial1;
	private Nota parcial2;
	private Integer idComision;

	
	public AsignacionComisionAlumno(Integer idComisionAlumno,Integer codigo_comision, Integer dniAlumno) {
		this.idComisionAlumno=idComisionAlumno;
		this.codigo_comision = codigo_comision;
		this.dniAlumno = dniAlumno;
		this.notas = new ArrayList<>();
	}
	//Constructor conID estatico
	public AsignacionComisionAlumno(Integer codigo_comision, Integer dniAlumno) {
			this.idComisionAlumno=id++;
			this.codigo_comision = codigo_comision;
			this.dniAlumno = dniAlumno;
			this.notas = new ArrayList<>();
		}
	
	
	public Integer getIdComisionAlumno() {
		return idComisionAlumno;
	}
	
	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	public Boolean registrarNota(Double valor, ClaseDeNota clase) {
		Boolean seCargo=false;
		Nota nueva=new Nota();
		
		if(this.notas.isEmpty() && !(ClaseDeNota.RECUPERATORIO_1.equals(clase) || ClaseDeNota.RECUPERATORIO_2.equals(clase))) {
			nueva.registrarNota(valor, clase);
			this.notas.add(nueva);
			seCargo=true;
		}else if( !this.existe(clase) && this.notas.size()<cantidadDeParciales && !(ClaseDeNota.RECUPERATORIO_1.equals(clase) || ClaseDeNota.RECUPERATORIO_2.equals(clase))) {
			nueva.registrarNota(valor, clase);
			this.notas.add(nueva);
			seCargo=true;
		}
		return seCargo;
	}
	
	
	public void recuperarNota(ClaseDeNota notaAnterior,Double valorDeNota) {

		if(!this.notas.isEmpty() && this.existe(notaAnterior) && !this.noHayaRecuperado()) {
			this.obtenerElemento(notaAnterior).recuperarNota(valorDeNota);;
		}
	}
	
	public boolean noHayaRecuperado() {
		Boolean recupero=false;

		for (Nota nota : notas) {
			if(nota.getTipoDeNota().equals(ClaseDeNota.RECUPERATORIO_1) || nota.getTipoDeNota().equals(ClaseDeNota.RECUPERATORIO_2)) {
				recupero=true;
			}
		}
		return recupero;
	}
	public Nota obtenerElemento(ClaseDeNota notaAnterior) {
		Nota buscada=null;
		
		for (Nota nota : notas) {
			if(nota.getTipoDeNota().equals(notaAnterior)) {
				buscada=nota;
			}
		}
		return buscada;
	}
	
	public boolean existe(ClaseDeNota clase) {
		Boolean existe=false;

		for (Nota nota : notas) {
			if(nota.getTipoDeNota().equals(clase))
			existe=true;
		}
		return existe;
	}
	
	public Double obtenerPromedioFinal() {
		Double nota=0.0;
		if(this.notas.size()==2) {
			Double nota1=this.notas.get(0).getValor();
			Double nota2=this.notas.get(1).getValor(); 
			nota=(double) Math.floor((nota1+nota2)/2.0); 
		}
		return nota;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo_comision, dniAlumno, idComisionAlumno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionComisionAlumno other = (AsignacionComisionAlumno) obj;
		return Objects.equals(codigo_comision, other.codigo_comision) && Objects.equals(dniAlumno, other.dniAlumno)
				|| Objects.equals(idComisionAlumno, other.idComisionAlumno);
	}

	@Override
	public String toString() {
		return "AsignacionComisionAlumno [idComisionAlumno=" + idComisionAlumno + ", codigo_comision=" + codigo_comision
				+ ", dniAlumno=" + dniAlumno + ", notas=" + notas + "]";
	}
	public Nota getParcial1() {
		return parcial1;
	}

	public Nota getParcial2() {
		return parcial2;
	}

	public void setParcial1(Nota parcial1) {

		this.parcial1 = parcial1;

	}

	public void setParcial2(Nota parcial2) {

		this.parcial2 = parcial2;

	}

	public void calificarParcial1(Double nota) {

		this.parcial1.asignarValor(nota);
	}

	public void calificarParcial2(Double nota) {

		this.parcial2.asignarValor(nota);

	}
	
	public Integer getIdComision() {
		return idComision;
	}

}
