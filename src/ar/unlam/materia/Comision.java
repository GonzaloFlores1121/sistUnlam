package ar.unlam.materia;

import java.util.Objects;

public class Comision {
	private Integer id;
	private Dia dia;
	private Turno turno;
	private CicloLectivo ciclo;
	private Materia materia;

	public Comision(Integer id, Turno turno, CicloLectivo ciclo, Materia materia) {
		this.id = id;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	public Comision(Integer id,Materia materia ,Dia dia, Turno turno) {
		this.id = id;
		this.dia = dia;
		this.turno = turno;
	}

	public Comision(Integer id, Materia materia) {
		this.id = id;
		this.materia = materia;
	}

	public Comision(Integer id, CicloLectivo ciclo, Materia materia) {
		this.id = id;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	public Integer getId() {
		return id;
	}

	public Dia getDia() {
		return dia;
	}

	
	public Turno getTurno() {
		return turno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, materia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(id, other.id) && Objects.equals(materia, other.materia);
	}

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	
	

	public Materia getMateria() {
		return materia;
	}

	@Override
	public String toString() {
		return "Comision [id=" + id + ", dia=" + dia + ", turno=" + turno + ", ciclo=" + ciclo + ", materia=" + materia
				+ "]";
	}

}
