package ar.unlam.materia;

public class AsignacionCursoAlumno {
	private Integer id;
	private Integer codigo_curso;
	private Integer dniAlumno;
	private Nota parcial1;
	private Nota parcial2;
	private Nota recuperatorio;

	public AsignacionCursoAlumno(Integer id, Integer codigo_curso, Integer dniAlumno) {
		this.id = id;
		this.codigo_curso = codigo_curso;
		this.dniAlumno = dniAlumno;

	}

}
