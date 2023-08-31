package ar.unlam.materia;

public class Universidad {
	private Materia[] materias;
	private Alumno[] alumnos;
	private Cursada[] cursadas;

	public Universidad() {
		this.materias = new Materia[100];
		this.alumnos = new Alumno[100];
		this.cursadas = new Cursada[100];
	}

	public boolean registrarMaterias(Materia materia) {
		for (int i = 0; i < materias.length; i++) {
			if (materias[i] == null) {
				materias[i] = materia;
				return true;
			}
		}
		return false;
	}

	public boolean registrarAlumno(Alumno alumno) {
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i] == null) {
				alumnos[i] = alumno;
				return true;
			}

		}
		return false;

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

	public void evaluar(Alumno codigoAlumno, Materia codigoMateria, Double nota) {
		Cursada buscada = buscarAlumnoCursada(codigoMateria.getCodigo_materia(), codigoAlumno.getCodigo_alumno());
		if (buscada != null) {
			buscada.calificar(nota);
		}
	}

	public Cursada buscarAlumnoCursada(Integer cod_materia, Integer cod_alumno) {

		Cursada encontrada = null;
		Cursada[] cursadasMateria = buscarCursadasPorMateria(cod_materia);
		if (cursadasMateria != null) {
			for (int i = 0; i < cursadasMateria.length; i++) {
				if (cursadasMateria[i] != null
						&& cursadasMateria[i].getAlumno().getCodigo_alumno().equals(cod_alumno)) {
					encontrada = cursadasMateria[i];
				}
			}
		}
		return encontrada;
	}

	public Cursada[] buscarCursadasPorMateria(Integer cod_materia) {
		Cursada[] cursadasMateria = new Cursada[cursadas.length];
		int posicion = 0;
		for (int i = 0; i < cursadas.length; i++) {
			if (cursadas[i] != null && cursadas[i].getMateria().getCodigo_materia().equals(cod_materia)) {
				cursadasMateria[posicion++] = cursadas[i];
			}
		}
		return cursadasMateria;
	}

	public Alumno buscarAlumnoRegistrado(Integer codigo_alumno) {
		Alumno encontrado = null;
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i] != null && alumnos[i].getCodigo_alumno().equals(codigo_alumno)) {
				encontrado = alumnos[i];
				break;
			}
		}
		return encontrado;
	}

	public Materia buscarMateria(Integer codigo_materia) {
		Materia m = null;
		for (int i = 0; i < materias.length; i++) {
			if (materias[i] != null && materias[i].getCodigo_materia().equals(codigo_materia)) {
				m = materias[i];
				break;
			}
		}
		return m;
	}

	public boolean inscripcionCursadaSiTieneLasCorrelativasAprobadas(Integer codigo_alumno, Materia materia) {
		Materia[] cursadasAlumnoAprobada = obtengaUnaListaDeMateriasAprobadasDeUnAlumno(codigo_alumno);
		Integer[] correlativas = materia.getCodigo_materias_correlativas();

		boolean resultado = false;
		int posicion = 0;
		if (correlativas != null && cursadasAlumnoAprobada != null) {

			for (int i = 0; i < cursadasAlumnoAprobada.length; i++) {
				if (cursadasAlumnoAprobada[i] != null
						&& cursadasAlumnoAprobada[i].getCodigo_materia().equals(correlativas[posicion])) {
					posicion++;

				}
			}

			if (posicion == correlativas.length) {
				Alumno encontrado = buscarAlumnoRegistrado(codigo_alumno);
				Cursada cursada = new Cursada(encontrado, materia);
				inscripcionCursada(cursada);
				resultado = true;
			}
		}
		return resultado;
	}

	public boolean inscripcionCursada(Cursada cursada) {

		for (int i = 0; i < cursadas.length; i++) {
			if (cursadas[i] == null) {
				cursadas[i] = cursada;
				return true;
			}
		}
		return false;
	}

	public Double obtenerPromedioCalificacionesDeUnaCursada(Integer cod_materia) {
		Cursada[] cursadasEncontradas = buscarCursadasPorMateria(cod_materia);
		Double promedio = 0.0;
		Double resultado = 0.0;
		int cantidad = 0;
		if (cursadasEncontradas != null) {
			for (int i = 0; i < cursadasEncontradas.length; i++) {
				if (cursadasEncontradas[i] != null) {
					promedio += cursadasEncontradas[i].getNota().getValor();
					cantidad++;
				}

			}
		}
		resultado = (Double) promedio / cantidad;
		return resultado;
	}

	public Cursada[] buscarCursadasDeUnAlumno(Integer cod_alumno) {
		Cursada[] cursadasAlumno = new Cursada[cursadas.length];
		int posicion = 0;
		for (int i = 0; i < cursadas.length; i++) {
			if (cursadas[i] != null && cursadas[i].getAlumno().getCodigo_alumno().equals(cod_alumno)) {
				cursadasAlumno[posicion++] = cursadas[i];
			}
		}
		return cursadasAlumno;
	}

	public Materia[] obtengaUnaListaDeMateriasAprobadasDeUnAlumno(Integer cod_alumno) {
		Cursada[] cursadasAlumno = buscarCursadasDeUnAlumno(cod_alumno);
		Materia[] materiasAprobadas = new Materia[materias.length];
		int posicion = 0;
		if (cursadasAlumno != null) {
			for (int i = 0; i < cursadasAlumno.length; i++) {
				if (cursadasAlumno[i] != null && cursadasAlumno[i].getNota().getValor() >= 7) {
					materiasAprobadas[posicion++] = cursadasAlumno[i].getMateria();
				}
			}
		}
		return materiasAprobadas;
	}
}
