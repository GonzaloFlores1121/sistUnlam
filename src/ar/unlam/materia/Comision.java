package ar.unlam.materia;

import java.util.Objects;

public class Comision {
	private static Integer idComisiones = 0;
	private Integer id;
	private Integer codigo_comision;
	private Dia dia;
	private Turno turno;
	private CicloLectivo ciclo;
	private Materia materia;
	private Aula aula;
	private AsignacionComisionAlumno asignacionAlumno;
	private AsignacionComisionProfe asignacionProfe;

	public Comision(Integer codigo_comision, Dia dia, Turno turno, CicloLectivo ciclo, Materia materia, Aula aula,
			AsignacionComisionAlumno asignacionAlumno, AsignacionComisionProfe asignacionProfe) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
		this.aula = aula;
		this.asignacionAlumno = asignacionAlumno;
		this.asignacionProfe = asignacionProfe;
	}

	public Comision(Integer codigo_comision, Turno turno, CicloLectivo ciclo, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	public Comision(Integer codigo_comision, Dia dia, Turno turno, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.materia = materia;
	}

	public Comision(Integer codigo_comision, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.materia = materia;
	}

	public Comision(Integer codigo_comision, CicloLectivo ciclo, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.ciclo = ciclo;
		this.materia = materia;
	}

	public Comision(Integer codigoCurso) {
		this.id = ++idComisiones;
		this.codigo_comision=codigoCurso;
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

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	public Materia getMateria() {
		return materia;
	}

	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public AsignacionComisionAlumno getAsignacionAlumno() {
		return asignacionAlumno;
	}

	public void setAsignacionAlumno(AsignacionComisionAlumno asignacionAlumno) {
		this.asignacionAlumno = asignacionAlumno;
	}

	public AsignacionComisionProfe getAsignacionProfe() {
		return asignacionProfe;
	}

	public void setAsignacionProfe(AsignacionComisionProfe asignacionProfe) {
		this.asignacionProfe = asignacionProfe;
	}
	

	public void setAula(Aula aula) {
		this.aula = aula;
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
		return "Comision [codigo_comision=" + codigo_comision + ", dia=" + dia + ", turno=" + turno + ", ciclo=" + ciclo
				+ ", materia=" + materia + ", aula=" + aula + ", asignacionAlumno=" + asignacionAlumno
				+ ", asignacionProfe=" + asignacionProfe + "]";
	}

}
