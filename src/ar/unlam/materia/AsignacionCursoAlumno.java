package ar.unlam.materia;

import java.util.Objects;

public class AsignacionCursoAlumno {
	private static Integer id = 0;
	private Integer codigo_curso;
	private Integer dniAlumno;
	private Nota parcial1;
	private Nota parcial2;
	private Nota recuperatorio;

	public AsignacionCursoAlumno(Integer codigo_curso, Integer dniAlumno) {
		id++;
		this.codigo_curso = codigo_curso;
		this.dniAlumno = dniAlumno;

	}

	public void calificarParcial1(Double nota) {

		this.parcial1.asignarValor(nota);
	}

	public void calificarParcial2(Double nota) {

		this.parcial2.asignarValor(nota);

	}

	@Override
	public String toString() {
		return "AsignacionCursoAlumno  [ID " + id + " codigo_curso=" + codigo_curso + ", dniAlumno=" + dniAlumno
				+ ", parcial1=" + parcial1 + ", parcial2=" + parcial2 + ", recuperatorio=" + recuperatorio + "]";
	}

	public void setParcial1(Nota parcial1) {
		this.parcial1 = parcial1;
	}

	public void setParcial2(Nota parcial2) {
		this.parcial2 = parcial2;
	}

	public Integer getCodigo_curso() {
		return codigo_curso;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public Nota getParcial1() {
		return parcial1;
	}

	public Nota getParcial2() {
		return parcial2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_curso, dniAlumno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionCursoAlumno other = (AsignacionCursoAlumno) obj;
		return Objects.equals(codigo_curso, other.codigo_curso) && Objects.equals(dniAlumno, other.dniAlumno);
	}

}
