package ar.unlam.materia;

import java.util.Objects;

public class AsignacionCursoProfe {
	private static Integer id = 0;
	private Integer codigo_curso;
	private Integer dniProfesor;

	public AsignacionCursoProfe(Integer codigo_curso, Integer dniProfesor) {
		this.id = ++id;
		this.codigo_curso=codigo_curso;
		this.dniProfesor=dniProfesor;
				
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo_curso, dniProfesor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionCursoProfe other = (AsignacionCursoProfe) obj;
		return Objects.equals(codigo_curso, other.codigo_curso) && Objects.equals(dniProfesor, other.dniProfesor);
	}


	@Override
	public String toString() {
		return "AsignacionCursoProfe [codigo_curso=" + codigo_curso + ", dniProfesor=" + dniProfesor + "]";
	}

}
