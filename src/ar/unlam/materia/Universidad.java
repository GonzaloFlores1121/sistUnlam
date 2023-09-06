package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();

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

}
