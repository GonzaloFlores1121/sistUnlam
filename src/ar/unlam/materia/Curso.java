package ar.unlam.materia;

public class Curso {
	private static Integer id = 0;
	private Integer codigo_curso;
	private Comision comision;
	private Aula aula;
	private AsignacionCursoAlumno asignacionAlumno;
	private AsignacionCursoProfe asignacionProfe;

	public Curso(Integer codigo_curso) {
		this.id = ++id;
		this.codigo_curso = codigo_curso;
	}

	public Curso(Integer codigo_curso, Comision comision, AsignacionCursoAlumno asignacionAlumno) {
		this.id = ++id;
		this.codigo_curso = codigo_curso;
		this.comision = comision;
		this.asignacionAlumno = asignacionAlumno;
	}

	public Curso(Integer codigo_curso, Comision comision) {
		this.id = ++id;
		this.codigo_curso = codigo_curso;
		this.comision = comision;
	}

	public Curso(Integer codigo_curso, Comision comision, Aula aula) {
		this.id = ++id;
		this.codigo_curso = codigo_curso;
		this.comision = comision;
		this.aula = aula;

	}

	public Curso(Integer codigo_curso, Comision comision, Aula aula, AsignacionCursoAlumno asignacionAlumno,
			AsignacionCursoProfe asignacionProfe) {
		this.id = ++id;
		this.comision = comision;
		this.codigo_curso = codigo_curso;
		this.aula = aula;
		this.asignacionAlumno = asignacionAlumno;
		this.asignacionProfe = asignacionProfe;
	}

	public Integer getCodigo_curso() {
		return codigo_curso;
	}

	public void setAsignacionAlumno(AsignacionCursoAlumno asignacionAlumno) {
		this.asignacionAlumno = asignacionAlumno;
	}

	public void setAsignacionProfe(AsignacionCursoProfe asignacionProfe) {
		this.asignacionProfe = asignacionProfe;
	}

	@Override
	public String toString() {
		return "Curso [codigo_curso=" + codigo_curso + ", comision=" + comision + ", aula=" + aula
				+ ", asignacionAlumno=" + asignacionAlumno + ", asignacionProfe=" + asignacionProfe + "]";
	}

	public AsignacionCursoAlumno getAsignacionAlumno() {
		return asignacionAlumno;
	}

	public Comision getComision() {
		return comision;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public AsignacionCursoProfe getAsignacionProfe() {
		return asignacionProfe;
	}

	public void setCodigo_curso(Integer codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}
	

}
