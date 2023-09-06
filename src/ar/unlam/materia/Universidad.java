package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profes;
	private ArrayList<Curso> cursos;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.cursos = new ArrayList<>();
	}

	public void registrarMaterias(Materia materia) {
		if (!materias.contains(materia)) {
			materias.add(materia);
		}

	}

	public void registrarAlumno(Alumno alumno) {
		if (!alumnos.contains(alumno)) {
			alumnos.add(alumno);
		}
	}

	public Alumno buscarAlumnoRegistrado(Integer dni) {
		Alumno encontrado = null;
		for (Alumno alumno : alumnos) {
			if (alumno != null && alumno.getDni().equals(dni)) {
				encontrado = alumno;
				break;
			}
		}
		return encontrado;

	}

	public Materia buscarMateria(Integer codigo_materia) {
		Materia m = null;

		for (Materia materia : materias) {
			if (materia != null && materia.getCodigo_materia().equals(codigo_materia)) {
				m = materia;
				break;
			}
		}
		return m;
	}

	public void registrarProfesor(Profesor profe) {
		if (!profes.contains(profe)) {
			profes.add(profe);
		}

	}

	public Profesor buscarProfesorRegistrado(Integer dni) {

		for (Profesor profe : profes) {
			if (profe.getDni().equals(dni)) {
				return profe;
			}
		}
		return null;
	}

	public void registrarCurso(Curso curso) {
		if (!cursos.contains(curso)) {
			cursos.add(curso);
		}

	}

	public Curso buscarCursoPorCodigo(Integer codigo_curso) {
		for (Curso c : cursos) {
			if (c.getCodigo_curso().equals(codigo_curso)) {
				return c;
			}
		}
		return null;
	}

}
