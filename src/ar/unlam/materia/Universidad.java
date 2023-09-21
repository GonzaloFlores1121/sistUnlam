package ar.unlam.materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profes;
	private ArrayList<Aula> aulas;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<AsignacionComisionAlumno> comisionesAlumno;
	private ArrayList<AsignacionComisionProfe> comisionesProfe;

	public Universidad() {
		this.materias = new ArrayList<>();
		this.alumnos = new ArrayList<>();
		this.profes = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisionesAlumno = new ArrayList<>();
		this.comisionesProfe = new ArrayList<>();
	}

	// Metodos para registrar

	public Boolean registrarAsignacionComisionProfe(AsignacionComisionProfe asignacion) {
		Boolean existe = existeAsignacionComisionProfe(asignacion);
		if (!existe) {
			comisionesProfe.add(asignacion);
			return true;
		}
		return false;
	}

	public Boolean registrarAsignacionComisionAlumno(AsignacionComisionAlumno asignacion) {
		Boolean existe = existeAsignacionComisionAlumno(asignacion);
		if (!existe) {
			comisionesAlumno.add(asignacion);
			return true;
		}
		return false;
	}

	public Boolean registrarComision(Comision comision) {
		Boolean existe = existeComision(comision);
//		Boolean verificarCondiciones = verificarQueEsteRegistradoMateriaYCiclo(comision.getMateria(),
//				comision.getCiclo());
		if (!existe) {// verificarCondiciones) {
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

	public Comision buscarComisionPorCodigoYID(Integer codigo_comision, Integer id) {
		for (Comision c : comisiones) {
			if (c.getCodigo_comision().equals(codigo_comision) && c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public ArrayList<Comision> buscarComisionesDeUnAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Comision> comisionesAlumno = new ArrayList<>();
		if (encontrado != null) {

			for (Comision comi : comisiones) {
				if (comi.getAsignacionAlumno().getDniAlumno().equals(dniAlumno)) {
					comisionesAlumno.add(comi);
				}
			}
		}
		return comisionesAlumno;
	}

	public AsignacionComisionAlumno buscarAsignacionAlumnoComision(Integer id, Integer codigoComision,
			Integer dniAlumno) {

		Comision buscada = buscarComisionPorCodigoYID(codigoComision, id);
		if (buscada != null) {
			if (buscada.getAsignacionAlumno().getDniAlumno().equals(dniAlumno)) {
				return buscada.getAsignacionAlumno();
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

	public Boolean asignarAulaAComision(Integer id, Integer codigoComision, Aula aula) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Aula a = buscarAulaPorNumero(aula.getNumero());
		if (comision != null && a != null) {
			comision.setAula(aula);
			return true;
		}
		return false;

	}

	public void evaluarAlumnoComision(Integer idComision, Integer codigoComision, Integer dniAlumno, Nota parcial1,
			Nota parcial2) {
		AsignacionComisionAlumno asignacion = buscarAsignacionAlumnoComision(idComision, codigoComision, dniAlumno);

		if (asignacion != null) {

			asignacion.setParcial1(parcial1);

			asignacion.setParcial2(parcial2);

		}

	}

	private ArrayList<Comision> obtenerListaComisionesAlumno(Integer dni) {
		ArrayList<Comision> com = new ArrayList<>();
		for (Comision comision : comisiones) {
			if (comision.getAsignacionAlumno() != null && comision.getAsignacionAlumno().getDniAlumno().equals(dni)) {

				com.add(comision);
			}
		}
		return com;
	}

	public ArrayList<Materia> listaMateriasAprobadas(Integer dniAlumno) {
		ArrayList<Materia> lista = new ArrayList<>();
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		if (encontrado != null) {
			ArrayList<Comision> listac = obtenerListaComisionesAlumno(dniAlumno);
			for (Comision comision : listac) {
				if (verificarNotasMayorA7(comision.getAsignacionAlumno().getParcial1(),
						comision.getAsignacionAlumno().getParcial2())) {
					lista.add(comision.getMateria());
				}
			}
		}
		return lista;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComision(Integer id, Integer codigoComision, Integer dniAlumno, Integer numeroAula) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		Boolean verificarCapacidadAula = verificarCapacidadAula(numeroAula);
		if (comision != null && alumno != null && verificarCapacidadAula) {
			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(codigoComision, dniAlumno);
			comisionesAlumno.add(asignacion);
			comision.setAsignacionAlumno(asignacion);
			return true;

		}
		return false;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComision(Integer id, Integer codigoComision, Integer dniAlumno,
			LocalDate fechaInscripto) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		Boolean validar = verificarSiFechaEstaDentroDelRango(comision.getCiclo().getFechaDeInicioInscripcion(),
				comision.getCiclo().getFechaFinalizacionInscripcion(), fechaInscripto);
		if (comision != null && alumno != null && validar) {
			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(codigoComision, dniAlumno);
			comisionesAlumno.add(asignacion);
			comision.setAsignacionAlumno(asignacion);
			return true;

		}
		return false;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComision(Integer id, Integer codigoComision, Integer dniAlumno) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		if (comision != null && alumno != null) {
			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(codigoComision, dniAlumno);
			comisionesAlumno.add(asignacion);
			comision.setAsignacionAlumno(asignacion);
			return true;

		}
		return null;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComision(Integer dniAlumno, Integer codigoMateriaInscripcion, Comision comision,
			Integer codigoCurso, LocalDate fechainscripto, Integer numeroAula) {
		Boolean operacion = false;

		Boolean verificarFecha = verificarSiFechaEstaDentroDelRango(comision.getCiclo().getFechaDeInicioInscripcion(),
				comision.getCiclo().getFechaFinalizacionInscripcion(), fechainscripto);
		Boolean verificarMateriasCorrelativas = verificarCorrelativasAprobadas(dniAlumno, codigoMateriaInscripcion);

		Boolean capacidad = verificarCapacidadAula(numeroAula);
		if (verificarMateriasCorrelativas && capacidad && verificarFecha) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(codigoCurso, dniAlumno);
			cursoAlumno.add(asignacion);

			Curso curso = new Curso(codigoCurso, comision, asignacion);
			registrarCurso(curso);
			operacion = true;

		}
		return operacion;
	}

	public Boolean inscribirAlumnoComisionConCorrelativasAprobadas(Integer idComision, Integer codigoComision,
			Integer dniAlumno, Integer codigoMateriaInscripcion) {
		Boolean operacion = false;
		Boolean verificacion = verificarCorrelativasAprobadas(dniAlumno, codigoMateriaInscripcion);
		if (verificacion) {
			Comision buscar = buscarComisionPorCodigoYID(codigoComision, idComision);

			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(codigoComision, dniAlumno);

			comisionesAlumno.add(asignacion);
			buscar.setAsignacionAlumno(asignacion);

			operacion = true;

		}
		return operacion;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComisionSiEstaDentroDeLasFechasInscripcion(Integer dniAlumno, Integer codigoComision,
			Integer idComision, LocalDate fechaInscripcion) {
		Comision buscar = buscarComisionPorCodigoYID(codigoComision, idComision);

		if (buscar != null) {
			Boolean verificar = verificarSiFechaEstaDentroDelRango(buscar.getCiclo().getFechaDeInicioInscripcion(),
					buscar.getCiclo().getFechaFinalizacionInscripcion(), fechaInscripcion);
			if (verificar) {
				AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(codigoComision, dniAlumno);

				comisionesAlumno.add(asignacion);
				buscar.setAsignacionAlumno(asignacion);
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

	private Boolean existeAsignacionComisionProfe(AsignacionComisionProfe asignacion) {
		for (AsignacionComisionProfe asig : comisionesProfe) {
			if (asig.equals(asignacion)) {
				return true;
			}
		}
		return false;
	}

	private Boolean existeAsignacionComisionAlumno(AsignacionComisionAlumno asignacion) {
		for (AsignacionComisionAlumno asig : comisionesAlumno) {
			if (asig.equals(asignacion)) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarNotasMayorA7(Nota parcial1, Nota parcial2) {
		if (parcial1.getValor() > 7 && parcial2.getValor() > 7) {
			return true;
		}
		return false;
	}
}
