package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Objects;

public class AsignacionComisionAlumno {
	private Integer idComision;
	private Integer codigo_comision;
	private Integer dniAlumno;
	// ideal usar el array de notas
	private ArrayList<Nota> notas;
	// pongo los parciales de una para hacer mas facil los test que ya tenia
	private Nota parcial1;
	private Nota parcial2;

	public AsignacionComisionAlumno(Integer idComision, Integer codigo_comision, Integer dniAlumno) {
		this.idComision = idComision;
		this.codigo_comision = codigo_comision;
		this.dniAlumno = dniAlumno;
		this.notas = new ArrayList<>();
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Nota getParcial1() {
		return parcial1;
	}

	public Nota getParcial2() {
		return parcial2;
	}

	// Creado para testear solamente
	public void setParcial1(Nota parcial1) {
		this.parcial1 = parcial1;
	}

	// Creado para testear solamente
	public void setParcial2(Nota parcial2) {
		this.parcial2 = parcial2;
	}

	public void calificarParcial1(Double nota) {

		this.parcial1.asignarValor(nota);
	}

	public void calificarParcial2(Double nota) {

		this.parcial2.asignarValor(nota);

	}

	
	public Boolean agregarParcial(Nota nota) {
		
		if (obtenerNota(nota.getTipo())==null) {
			if (nota.getValor() >= 1 && nota.getValor() <= 10) {
				notas.add(nota);
				return true;
			}
		}
		return false;
	}

	public Nota obtenerNota(TipoNota tipo) {
		for (Nota notas : notas) {
			if (notas.getTipo().equals(tipo)) {
				return notas;
			}

		}
		return null;
	}

	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public void setCodigo_comision(Integer codigo_comision) {
		this.codigo_comision = codigo_comision;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_comision, dniAlumno, idComision);
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
				&& Objects.equals(idComision, other.idComision);
	}

	@Override
	public String toString() {
		return "AsignacionComisionAlumno [idComision=" + idComision + ", codigo_comision=" + codigo_comision
				+ ", dniAlumno=" + dniAlumno + ", notas=" + notas + ", parcial1=" + parcial1 + ", parcial2=" + parcial2
				+ "]";
	}

}
