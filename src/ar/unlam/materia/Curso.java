package ar.unlam.materia;

public class Curso {

	private Integer codigo_curso;
	private Materia materia;
	private Aula aula;
	private CicloLectivo ciclo;
	private Horario horario;
	private AsignacionCursoAlumno asignacionAlumno;
	private AsignacionCursoProfe asignacionProfe;

	public Curso(Integer codigo_curso, Materia tw1, Aula aula, CicloLectivo ciclo, Horario horario,
			AsignacionCursoAlumno asignacionAlumno, AsignacionCursoProfe asignacionProfe) {

		this.codigo_curso = codigo_curso;
		this.materia = tw1;
		this.aula = aula;
		this.ciclo = ciclo;
		this.horario = horario;
		this.asignacionAlumno = asignacionAlumno;
		this.asignacionProfe = asignacionProfe;
	}

	public Integer getCodigo_curso() {
		return codigo_curso;
	}
	
}
