package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profes;
	private ArrayList<Curso> cursos;
	private ArrayList<CicloLectivo> ciclosLectivos;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
	}

	public Boolean registrarMaterias(Materia materia) {
		Boolean existeMateria = existeMateria(materia);
		if (!existeMateria) {
			materias.add(materia);
			return true;

		}
		return false;

	}

	private Boolean existeMateria(Materia materia) {

		for (Materia m : materias) {
			if (m.equals(materia)) {
				return true;
			}
		}
		return false;
	}

	public Boolean registrarAlumno(Alumno alumno) {
		Boolean existe = existeAlumno(alumno);
		if (!existe) {
			return alumnos.add(alumno);
		}
		return false;

	}

	private Boolean existeAlumno(Alumno alumno) {
		for (Alumno a : alumnos) {
			if (a.equals(alumno)) {
				return true;
			}

		}
		return false;
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

	public Boolean registrarCicloLectivo(CicloLectivo ciclo) {
		Boolean existe = existeCicloLectivo(ciclo);
		if (!existe)
			return ciclosLectivos.add(ciclo);
		return false;
	}

	private Boolean existeCicloLectivo(CicloLectivo ciclo) {

		for (CicloLectivo ciclos : ciclosLectivos) {
			if (ciclos.equals(ciclo)) {
				return true;
			}

		}
		return false;
	}

	public Boolean agregarCorrelativaAMateria(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Materia materia = buscarMateria(codigoMateria);
		Materia correlativa = buscarMateria(codigoMateriaCorrelativa);

		if (materia != null && correlativa != null) {
			materia.asignarCorrelativa(codigoMateriaCorrelativa);
			return true;
		}
		return false;
	}

	public Boolean eliminarCorrelativaDeMateria(Integer codigoMateria, Integer codigoMateriaCorrelativa) {

		Materia materia = buscarMateria(codigoMateria);
		Materia correlativa = buscarMateria(codigoMateriaCorrelativa);

		if (materia != null && correlativa != null) {
			materia.removerCorrelativa(codigoMateriaCorrelativa);
			return true;
		}
		return null;
	}

	public Boolean inscribirAlumnoCurso(Integer codigoCurso, Integer dniAlumno) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		if (curso != null && alumno != null) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);
			curso.setAsignacionAlumno(asignacion);
			return true;

		}
		return null;
	}

	public AsignacionCursoAlumno buscarAsignacionAlumnoCurso(Integer codigoCurso, Integer dniAlumno) {

		for (Curso c : this.cursos) {
			if (c.getAsignacionAlumno().getCodigo_curso().equals(codigoCurso)
					&& c.getAsignacionAlumno().getDniAlumno().equals(dniAlumno)) {
				return c.getAsignacionAlumno();

			}
		}
		return null;

	}

	public void evaluarAlumnoCurso(Integer codigoCurso, Integer dniAlumno, Double parcialUno, Double parcialDos) {
		AsignacionCursoAlumno asignacion = buscarAsignacionAlumnoCurso(codigoCurso, dniAlumno);

		if (asignacion != null) {
			asignacion.calificarParcial1(parcialUno);
			asignacion.calificarParcial2(parcialDos);
		}

	}

	public ArrayList<Materia> listaMateriasAprobadas(Integer dniAlumno) {
		ArrayList<Materia> lista = new ArrayList<>();
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		if (encontrado != null) {
			for (Curso c : this.cursos) {
				Integer codigoCurso = c.getCodigo_curso();
				AsignacionCursoAlumno asignacion = buscarAsignacionAlumnoCurso(codigoCurso, dniAlumno);
				if (asignacion != null && asignacion.getParcial1().getValor() >= 4
						&& asignacion.getParcial2().getValor() >= 4) {
					lista.add(c.getComision().getMateria());
				}
			}
		}
		return lista;
	}

	public Boolean inscribirAlumnoCursoSiTieneCorrelativasAprobadas(Integer dniAlumno, Integer codigoMateria) {
		ArrayList<Materia> lista = listaMateriasAprobadas(dniAlumno);
		Materia materia = buscarMateria(codigoMateria);

		if (lista != null && materia != null) {
			ArrayList<Integer> codigoCorrelativa = materia.getCodigoCorrelativa();
			int posicion = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getCodigo_materia().equals(codigoCorrelativa.get(posicion))) {
					posicion++;
				}

			}
			if (materia.cantidadCorrelativas() == posicion) {
				Curso curso =new Curso()
			}
		}

		return null;
	}

}
