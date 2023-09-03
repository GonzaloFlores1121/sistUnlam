package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Cursada> cursadas;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.cursadas = new ArrayList<>();
	}

	public boolean registrarMaterias(Materia materia) {

		return materias.add(materia);

	}

	public boolean registrarAlumno(Alumno alumno) {
		return alumnos.add(alumno);

	}

	public boolean inscripcionCursada(Cursada cursada) {

		return cursadas.add(cursada);

	}
	/*
	 * obtener promdio calificacione
	 * 
	 * 
	 * obtener materias aprobadas alumno no se pueda inscribir si no tiene las
	 * correlativas aprobadas
	 * 
	 * 
	 * metodo(cod_materia,alumno) --- esta promocionado? ARRAY CORRELATIVAS = COD
	 * MATERIA
	 */

	public void evaluar(Integer cod_materia,Integer dni, Double nota) {
		Cursada buscada = buscarAlumnoCursada(cod_materia,dni);
		if (buscada != null) {
			buscada.calificar(nota);
		}
	}

	public Cursada buscarAlumnoCursada(Integer cod_materia, Integer dni) {

		Cursada encontrada = null;

		ArrayList<Cursada> cursadasMateria = buscarCursadasPorMateria(cod_materia);
		if (cursadasMateria != null) {
			for (Cursada cursada : cursadasMateria) {
				if (cursada.getAlumno().getDni().equals(dni)) {
					encontrada = cursada;
				}

			}
		}
		return encontrada;

	}

	public ArrayList<Cursada> buscarCursadasPorMateria(Integer cod_materia) {
		ArrayList<Cursada> cursada = new ArrayList<>();

		for (Cursada cursada2 : cursadas) {
			if (cursada2.getMateria().getCodigo_materia().equals(cod_materia)) {
				cursada.add(cursada2);
			}
		}

		return cursada;
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

	public boolean inscripcionCursadaSiTieneLasCorrelativasAprobadas(Integer dni, Materia materia) {
		ArrayList<Materia> materiasAlumnoAprobada = obtengaUnaListaDeMateriasAprobadasDeUnAlumno(dni);
		Integer[] correlativas = materia.getCodigo_materias_correlativas();

		boolean resultado = false;
		int posicion = 0;
		if (correlativas != null && !materiasAlumnoAprobada.isEmpty()) {
			for (Materia materias : materiasAlumnoAprobada) {
				if (materias.getCodigo_materia().equals(correlativas[posicion])) {
					posicion++;
				}
			}

			if (posicion == correlativas.length) {
				Alumno encontrado = buscarAlumnoRegistrado(dni);
				Cursada cursada = new Cursada(encontrado, materia);
				inscripcionCursada(cursada);
				resultado = true;
			}
		}
		return resultado;
	}

	public Double obtenerPromedioCalificacionesDeUnaCursada(Integer cod_materia) {
		ArrayList<Cursada> cursada = buscarCursadasPorMateria(cod_materia);
		Double promedio = 0.0;
		Double resultado = 0.0;
		if (cursada != null) {
			for (Cursada cursada2 : cursada) {
				promedio += cursada2.getNota().getValor();

			}

		}

		resultado = (Double) promedio / cursada.size();
		return resultado;
	}

	public ArrayList<Cursada> buscarCursadasDeUnAlumno(Integer dni) {
		ArrayList<Cursada> cursada = new ArrayList<>();
		if (!cursadas.isEmpty()) {
			for (Cursada cursada2 : cursadas) {
				if (cursada2.getAlumno().getDni().equals(dni)) {
					cursada.add(cursada2);
				}

			}
		}
		return cursada;

	}

	public ArrayList<Materia> obtengaUnaListaDeMateriasAprobadasDeUnAlumno(Integer dni) {
		ArrayList<Cursada> cursadasAlumno = buscarCursadasDeUnAlumno(dni);
		ArrayList<Materia> materiasLista = new ArrayList<>();

		if (!cursadasAlumno.isEmpty()) {
			for (Cursada cursada : cursadasAlumno) {
				if (cursada.getNota().getValor() >= 7) {
					materiasLista.add(cursada.getMateria());
				}
			}

		}
		return materiasLista;
	}
}
