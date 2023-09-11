package ar.unlam.materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profes;
	private ArrayList<Curso> cursos;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Aula> aulas;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.aulas = new ArrayList<>();
	}

	// Metodos para registrar

	public Boolean registrarComision(Comision comision) {
		Boolean existe = existeComision(comision);
		Boolean verificarCondiciones = verificarQueEsteRegistradoMateriaYCiclo(comision.getMateria(),
				comision.getCiclo());
		if (!existe && verificarCondiciones) {
			comisiones.add(comision);
			return true;
		}
		return false;
	}

	public Boolean registrarAula(Aula aula) {
		Boolean existe = existeAula(aula);
		if (!existe) {
			aulas.add(aula);
			return true;
		}
		return false;

	}

	public Boolean registrarMaterias(Materia materia) {
		Boolean existeMateria = existeMateria(materia);
		if (!existeMateria) {
			materias.add(materia);
			return true;

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

	public Boolean registrarCicloLectivo(CicloLectivo ciclo) {
		Boolean existe = existeCicloLectivo(ciclo);
		if (!existe)
			return ciclosLectivos.add(ciclo);
		return false;
	}

	public void registrarProfesor(Profesor profe) {
		if (!profes.contains(profe)) {
			profes.add(profe);
		}

	}

	public void registrarCurso(Curso curso) {

		if (!cursos.contains(curso)) {
			cursos.add(curso);
		}

	}

//Metodos para buscaar
	public CicloLectivo buscarCicloLectivoPorID(Integer id) {

		for (CicloLectivo ciclo : ciclosLectivos) {
			if (ciclo.getId().equals(id)) {
				return ciclo;
			}
		}
		return null;
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

	public Curso buscarCursoPorCodigo(Integer codigo_curso) {
		for (Curso c : cursos) {
			if (c.getCodigo_curso().equals(codigo_curso)) {
				return c;
			}
		}
		return null;
	}

	public ArrayList<Curso> buscarCursosDeUnAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Curso> cursoAlumno = new ArrayList<>();
		if (encontrado != null) {

			for (Curso curso : cursos) {
				if (curso.getAsignacionAlumno().getDniAlumno().equals(dniAlumno)) {
					cursoAlumno.add(curso);
				}
			}
		}
		return cursoAlumno;
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

	public Profesor buscarProfesorRegistrado(Integer dni) {

		for (Profesor profe : profes) {
			if (profe.getDni().equals(dni)) {
				return profe;
			}
		}
		return null;
	}

	public Comision buscarComisionPorID(Integer id) {
		for (Comision comi : comisiones) {
			if (comi.getId().equals(id)) {
				return comi;
			}
		}
		return null;
	}

	public Aula buscarAulaPorNumero(Integer numero) {
		Aula encontrada = null;
		for (Aula a : aulas) {
			if (a.getNumero().equals(numero)) {
				encontrada = a;
			}
		}
		return encontrada;
	}

	// Metodos de inserción
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

	public Boolean asignarComisionAUnCurso(Integer codigoCurso, Comision comision) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Comision existe = buscarComisionPorID(comision.getId());
		Boolean verificar = verificarQueEsteRegistradoMateriaYCiclo(comision.getMateria(), comision.getCiclo());

		if (curso != null && existe != null && verificar) {

			curso.setComision(comision);
			return true;
		}
		return false;
	}

	public void asignarAulaACurso(Integer codigoCurso, Aula aula) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Aula a = buscarAulaPorNumero(aula.getNumero());
		if (curso != null && a != null) {
			curso.setAula(aula);
		}

	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoCurso(Integer codigoCurso, Integer dniAlumno, Integer numeroAula) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		Aula aula = buscarAulaPorNumero(numeroAula);
		if (curso != null && alumno != null && aula != null && aula.getCapacidadActual() < aula.getCapacidadMax()) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);
			curso.setAsignacionAlumno(asignacion);
			return true;

		}
		return false;
	}

	public void evaluarAlumnoCurso(Integer codigoCurso, Integer dniAlumno, Double parcialUno, Double parcialDos) {
		AsignacionCursoAlumno asignacion = buscarAsignacionAlumnoCurso(codigoCurso, dniAlumno);

		if (asignacion != null) {

			Nota nota1 = new Nota();
			asignacion.setParcial1(nota1);
			asignacion.calificarParcial1(parcialUno);

			Nota nota2 = new Nota();
			asignacion.setParcial2(nota2);
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

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoCurso(Integer codigoCurso, Integer dniAlumno, Comision comision,
			LocalDate fechaInscripto) {
		Curso curso = buscarCursoPorCodigo(codigoCurso);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		Boolean validar = verificarSiFechaEstaDentroDelRango(comision.getCiclo().getFechaDeInicioInscripcion(),
				comision.getCiclo().getFechaFinalizacionInscripcion(), fechaInscripto);
		if (curso != null && alumno != null && validar) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);
			curso.setAsignacionAlumno(asignacion);
			return true;

		}
		return false;
	}

	// Sobrecargaa de metodos
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

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoCurso(Integer dniAlumno, Integer codigoMateriaInscripcion, Comision comision,
			Integer codigoCurso, LocalDate fechainscripto, Integer numeroAula) {
		Boolean operacion = false;

		Boolean verificarFecha = verificarSiFechaEstaDentroDelRango(comision.getCiclo().getFechaDeInicioInscripcion(),
				comision.getCiclo().getFechaFinalizacionInscripcion(), fechainscripto);
		Boolean verificarMateriasCorrelativas = verificarCorrelativasAprobadas(dniAlumno, codigoMateriaInscripcion);

		Boolean capacidad = verificarCapacidadAula(numeroAula);
		if (verificarMateriasCorrelativas && capacidad && verificarFecha) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);

			Curso curso = new Curso(codigoCurso, comision, asignacion);
			registrarCurso(curso);
			operacion = true;

		}
		return operacion;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoCurso(Integer dniAlumno, Integer codigoMateriaInscripcion, Comision comision,
			Integer codigoCurso) {
		Boolean operacion = false;
		Boolean verificacion = verificarCorrelativasAprobadas(dniAlumno, codigoMateriaInscripcion);
		if (verificacion) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);

			Curso curso = new Curso(codigoCurso, comision, asignacion);
			registrarCurso(curso);
			operacion = true;

		}
		return operacion;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoCurso(Integer dniAlumno, Integer codigoCurso, Curso inscribirse) {
		Curso buscado = buscarCursoPorCodigo(codigoCurso);

		if (buscado != null) {
			Boolean verificar = verificarCursosSuperpuestos(dniAlumno, inscribirse);
			if (!verificar) {
				registrarCurso(inscribirse);
				AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(inscribirse.getCodigo_curso(), dniAlumno);
				inscribirse.setAsignacionAlumno(asignacion);
				return true;

			}
		}
		return false;
	}

	// Verificaciones
	public Boolean verificarSiFechaEstaDentroDelRango(LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion,
			LocalDate fechaInscripto) {

		return VerificadorDeFecha.fechaEnRango(fechaInicioInscripcion, fechaFinInscripcion, fechaInscripto);

	}

	public Boolean verificarCapacidadAula(Integer numero) {

		Aula a = buscarAulaPorNumero(numero);
		if (a != null) {
			Integer capacidadActual = a.getCapacidadActual();
			if (capacidadActual < a.getCapacidadMax()) {
				return true;
			}
		}

		return false;
	}

	public Boolean verificarQueEsteRegistradoMateriaYCiclo(Materia materia, CicloLectivo ciclo) {

		Materia existeMateria = buscarMateria(materia.getCodigo_materia());
		CicloLectivo existeCiclo = buscarCicloLectivoPorID(ciclo.getId());

		return existeMateria != null && existeCiclo != null;
	}

	public Boolean verificarCorrelativasAprobadas(Integer dniAlumno, Integer codigoMateriaInscribir) {
		ArrayList<Materia> lista = listaMateriasAprobadas(dniAlumno);
		Integer cantidad = 0;
		Materia materiaInscripcion = buscarMateria(codigoMateriaInscribir);
		if (lista != null && materiaInscripcion != null) {
			for (Materia materia : lista) {
				cantidad += materiaInscripcion.buscarCorrelativa(materia.getCodigo_materia());
			}

			if (cantidad.equals(materiaInscripcion.cantidadCorrelativas())) {
				return true;
			}
		}
		return false;

	}

	public Boolean verificarCursosSuperpuestos(Integer dniAlumno, Curso inscribirse) {
		ArrayList<Curso> c = buscarCursosDeUnAlumno(dniAlumno);

		if (c != null) {
			for (Curso curso : c) {
				if (curso.getComision().getDia().equals(inscribirse.getComision().getDia())
						&& curso.getComision().getTurno().equals(inscribirse.getComision().getTurno())) {
					return true;
				}
			}
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

	private Boolean existeAula(Aula aula) {
		for (Aula a : aulas) {
			if (a.equals(aula)) {
				return true;
			}
		}
		return false;
	}

	private Boolean existeComision(Comision comision) {
		for (Comision com : comisiones) {
			if (com.equals(comision)) {
				return true;
			}
		}
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

	private Boolean existeAlumno(Alumno alumno) {
		for (Alumno a : alumnos) {
			if (a.equals(alumno)) {
				return true;
			}

		}
		return false;
	}

}
