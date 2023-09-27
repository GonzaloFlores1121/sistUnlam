package ar.unlam.materia;

import java.util.ArrayList;
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
	private ArrayList<Profesor> profes;
	private ArrayList<Alumno> alumnos;

	public Comision(Integer codigo_comision, Dia dia, Turno turno, CicloLectivo ciclo, Materia materia, Aula aula) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
		this.aula = aula;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigo_comision, Turno turno, CicloLectivo ciclo, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigo_comision, Dia dia, Turno turno, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.materia = materia;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigo_comision, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.materia = materia;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigo_comision, CicloLectivo ciclo, Materia materia) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.ciclo = ciclo;
		this.materia = materia;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigoCurso) {
		this.id = ++idComisiones;
		this.codigo_comision = codigoCurso;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigo_comision, CicloLectivo ciclo, Materia materia, Aula aula) {
		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.ciclo = ciclo;
		this.materia = materia;
		this.aula = aula;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();

	}

	public Aula getAula() {
		return aula;
	}

	public Integer obtenerCantidadDeProfes() {
		return profes.size();
	}

	public Integer obtenerCantidadDeAlumnosInscriptos() {
		return alumnos.size();
	}

	public void inscribirProfesor(Profesor profe) {
		if (!profes.contains(profe)) {
			profes.add(profe);
		}

	}

	public Boolean inscribirAlumno(Alumno alumno) {
		Boolean existe = existeAlumno(alumno);
		if (!existe) {
			return alumnos.add(alumno);
		}
		return false;

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

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Comision [id=" + id + ", codigo_comision=" + codigo_comision + ", dia=" + dia + ", turno=" + turno
				+ ", ciclo=" + ciclo + ", materia=" + materia + ", aula=" + aula + ", profes=" + profes + ", alumnos="
				+ alumnos + "]";
	}

	private Boolean existeAlumno(Alumno alumno) {
		for (Alumno a : alumnos) {
			if (a.equals(alumno)) {
				return true;
			}

		}
		return false;
	}

}
