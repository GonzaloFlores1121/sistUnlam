package ar.unlam.materia;

import java.util.Objects;

public class Comision {
	private Integer id;
	private Turno turno;
	private CicloLectivo ciclo;
	private Materia materia;

	public Comision(Integer id,Turno turno, CicloLectivo ciclo, Materia materia) {
		this.id=id;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciclo, materia, turno);
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
		return Objects.equals(ciclo, other.ciclo) && Objects.equals(materia, other.materia) && turno == other.turno;
	}

	@Override
	public String toString() {
		return "Comision [id=" + id + ", turno=" + turno + ", ciclo=" + ciclo + ", materia=" + materia + "]";
	}

	public Materia getMateria() {
		return materia;
	}

	
}
