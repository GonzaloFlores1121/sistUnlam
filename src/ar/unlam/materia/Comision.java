package ar.unlam.materia;

import java.util.Objects;

public class Comision {
	private Integer codigo;
	private Dia dia;
	private Turno turno;
	private CicloLectivo ciclo;
	private Materia materia;
	private static Integer id = 0;

	public Comision(Integer codigo, Turno turno, CicloLectivo ciclo, Materia materia) {
		id++;
		this.codigo = codigo;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	public Comision(Integer codigo, Materia materia, Dia dia, Turno turno) {
		
		id++;
		this.codigo = codigo;
		this.dia = dia;
		this.turno = turno;
	}

	public Comision(Integer codigo, Materia materia) {
		id++;
		this.codigo = codigo;
		this.materia = materia;
	}

	public Comision(Integer codigo, CicloLectivo ciclo, Materia materia) {
		id++;
		this.codigo= codigo;
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
	

	

	public Integer getCodigo() {
		return codigo;
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
