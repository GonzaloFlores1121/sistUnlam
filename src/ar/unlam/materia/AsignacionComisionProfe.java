package ar.unlam.materia;

import java.util.Objects;

public class AsignacionComisionProfe {
	private static Integer id = 0;
	private Integer codigo_comision;
	private Integer dniProfesor;

	public AsignacionComisionProfe(Integer codigo_comision, Integer dniProfesor) {
		this.codigo_comision = codigo_comision;
		this.dniProfesor = dniProfesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_comision, dniProfesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionComisionProfe other = (AsignacionComisionProfe) obj;
		return Objects.equals(codigo_comision, other.codigo_comision) && Objects.equals(dniProfesor, other.dniProfesor);
	}

	@Override
	public String toString() {
		return "AsignacionCursoProfe ID " + id + " codigo_comision=" + codigo_comision + ", dniProfesor=" + dniProfesor
				+ "]";
	}

}
