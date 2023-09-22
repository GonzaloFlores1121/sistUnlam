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
			if (ciclo != null && ciclo.getId().equals(id)) {
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
			if (c != null && c.getCodigo_comision().equals(codigo_comision) && c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public AsignacionComisionAlumno buscarAsignacionAlumnoComision(Integer id, Integer codigoComision,
			Integer dniAlumno) {

		for (AsignacionComisionAlumno asignacion : comisionesAlumno) {
			if (asignacion != null && asignacion.getIdComision().equals(id)
					&& asignacion.getCodigo_comision().equals(codigoComision)
					&& asignacion.getDniAlumno().equals(dniAlumno)) {
				return asignacion;
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
			if (profe != null && profe.getDni().equals(dni)) {
				return profe;
			}
		}
		return null;
	}

	public Aula buscarAulaPorNumero(Integer numero) {
		Aula encontrada = null;
		for (Aula a : aulas) {
			if (a != null && a.getNumero().equals(numero)) {
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

	public ArrayList<Comision> obtenerListaComisionesDeUnAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Comision> comisionesAlumno = new ArrayList<>();
		if (encontrado != null) {
			for (AsignacionComisionAlumno asignaciones : this.comisionesAlumno) {
				if (asignaciones != null && asignaciones.getDniAlumno().equals(dniAlumno)) {
					Comision encontrada = buscarComisionPorCodigoYID(asignaciones.getCodigo_comision(),
							asignaciones.getIdComision());
					comisionesAlumno.add(encontrada);
				}
			}
		}
		return comisionesAlumno;
	}

	public ArrayList<AsignacionComisionAlumno> obtenerListaDeAsignacionesComisionAlumno(Integer dniAlumno) {
		ArrayList<AsignacionComisionAlumno> asign = new ArrayList<>();

		for (AsignacionComisionAlumno asignaciones : this.comisionesAlumno) {
			if (asignaciones != null && asignaciones.getDniAlumno().equals(dniAlumno)) {
				asign.add(asignaciones);
			}
		}
		return asign;
	}
	// No interesa la comision si las notas se guardan en la
	// asignacionComisionAlumno

	public ArrayList<Materia> listaMateriasAprobadas(Integer dniAlumno) {
		ArrayList<Materia> lista = new ArrayList<>();
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		if (encontrado != null) {
			ArrayList<AsignacionComisionAlumno> asign = obtenerListaDeAsignacionesComisionAlumno(dniAlumno);

			for (AsignacionComisionAlumno aCA : asign) {

				if (aCA != null && verificarNotasMayorA7(aCA.getParcial1(), aCA.getParcial2())) {
					Comision buscar = buscarComisionPorCodigoYID(aCA.getCodigo_comision(), aCA.getIdComision());
					lista.add(buscar.getMateria());
				}
			}
		}
		return lista;
	}

	// Metodo que se utiliza para añadir al array de alumno de la comision solamente
	// si no estaba ya en el array.
	// Tambien registra la asignacion de ComisionAlumno en el array que tiene
	// universidad si es que se pudo inscribir.
	public Boolean agregarAlumnoALaComision(Comision comision, AsignacionComisionAlumno asignacion, Integer dniAlumno) {
		Alumno buscado = buscarAlumnoRegistrado(dniAlumno);
		if (comision.inscribirAlumno(buscado) == true) {
			comisionesAlumno.add(asignacion);
			return true;
		}
		return false;
	}

	// Sobrecargaa de metodos para testear lo basico
	public Boolean inscribirAlumnoComision(Integer id, Integer codigoComision, Integer dniAlumno) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		if (comision != null && alumno != null) {
			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(id, codigoComision, dniAlumno);

			if (agregarAlumnoALaComision(comision, asignacion, dniAlumno)) {
				return true;
			}

		}
		return false;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComisionVerificandoCapacidadAula(Integer id, Integer codigoComision,
			Integer dniAlumno) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		if (comision != null && alumno != null) {
			if (verificarCapacidadAula(comision)) {
				AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(comision.getId(), codigoComision,
						dniAlumno);

				if (agregarAlumnoALaComision(comision, asignacion, dniAlumno)) {
					return true;
				}

			}
		}

		return false;
	}

	// Sobrecargaa de metodos
	public Boolean inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(Integer id, Integer codigoComision,
			Integer dniAlumno, LocalDate fechaInscripto) {
		Comision comision = buscarComisionPorCodigoYID(codigoComision, id);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		Boolean validar = verificarSiFechaEstaDentroDelRango(comision.getCiclo().getFechaDeInicioInscripcion(),
				comision.getCiclo().getFechaFinalizacionInscripcion(), fechaInscripto);
		if (comision != null && alumno != null && validar) {
			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(comision.getId(), codigoComision,
					dniAlumno);

			if (agregarAlumnoALaComision(comision, asignacion, dniAlumno)) {
				return true;
			}

		}
		return false;
	}

	public Boolean inscribirAlumnoComisionConCorrelativasAprobadas(Integer idComision, Integer codigoComision,
			Integer dniAlumno, Integer codigoMateriaInscripcion) {
		Boolean operacion = false;
		Boolean verificacion = verificarCorrelativasAprobadas(dniAlumno, codigoMateriaInscripcion);
		if (verificacion) {
			Comision buscar = buscarComisionPorCodigoYID(codigoComision, idComision);

			AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(buscar.getId(), codigoComision,
					dniAlumno);
			if (agregarAlumnoALaComision(buscar, asignacion, dniAlumno)) {
				operacion = true;
			}

		}
		return operacion;
	}

	public Boolean inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(Integer dniAlumno, Comision comision) {

		if (comision != null) {
			Boolean verificar = verificarCursosSuperpuestos(dniAlumno, comision);
			if (!verificar) {
				registrarComision(comision);
				AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(comision.getId(),
						comision.getCodigo_comision(), dniAlumno);
				if (agregarAlumnoALaComision(comision, asignacion, dniAlumno)) {
					return true;
				}

			}
		}
		return false;
	}

	// Verificaciones
	public Boolean verificarCursosSuperpuestos(Integer dniAlumno, Comision inscribirse) {
		ArrayList<Comision> c = obtenerListaComisionesDeUnAlumno(dniAlumno);

		if (c != null) {
			for (Comision comision : c) {
				if (comision.getDia().equals(inscribirse.getDia())
						&& comision.getTurno().equals(inscribirse.getTurno())) {
					return true;
				}
			}
		}
		return false;

	}

	public Boolean verificarSiFechaEstaDentroDelRango(LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion,
			LocalDate fechaInscripto) {

		return VerificadorDeFecha.fechaEnRango(fechaInicioInscripcion, fechaFinInscripcion, fechaInscripto);

	}

	public Boolean verificarCapacidadAula(Comision comision) {
		Integer capacidadActual = comision.obtenerCantidadDeAlumnosInscriptos();
		if (capacidadActual < comision.getAula().getCapacidadMax()) {
			return true;
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
