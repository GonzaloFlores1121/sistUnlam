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

	// Getters

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public ArrayList<Profesor> getProfes() {
		return profes;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public ArrayList<CicloLectivo> getCiclosLectivos() {
		return ciclosLectivos;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}

	public ArrayList<AsignacionComisionAlumno> getComisionesAlumno() {
		return comisionesAlumno;
	}

	public ArrayList<AsignacionComisionProfe> getComisionesProfe() {
		return comisionesProfe;
	}

	// Metodos para registrar

	public Boolean registrarMaterias(Materia materia) {
		Boolean existe = false;
		if (!existeMateria(materia)) {
			materias.add(materia);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarAlumno(Alumno alumno) {
		Boolean existe = false;
		if (!existeAlumno(alumno)) {
			alumnos.add(alumno);
			existe = true;
		}
		return existe;

	}

	public Boolean registrarProfesor(Profesor profe) {
		Boolean existe = false;
		if (!profes.contains(profe)) {
			profes.add(profe);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarAula(Aula aula) {
		Boolean existe = false;
		if (!this.aulas.contains(aula)) {
			aulas.add(aula);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarCicloLectivo(CicloLectivo ciclo) {
		Boolean existe = false;
		if (!this.ciclosLectivos.contains(ciclo)) {
			this.ciclosLectivos.add(ciclo);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarComision(Comision comision) {
		Boolean existe = false;
		if (!this.comisiones.contains(comision)) {
			comisiones.add(comision);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarAsignacionComisionAlumno(AsignacionComisionAlumno asignacion) {
		Boolean existe = false;
		if (!this.comisionesAlumno.contains(asignacion)) {
			comisionesAlumno.add(asignacion);
			existe = true;
		}
		return existe;
	}

	public Boolean registrarAsignacionComisionProfe(AsignacionComisionProfe asignacion) {
		Boolean existe = false;
		if (!this.comisionesProfe.contains(asignacion)) {
			comisionesProfe.add(asignacion);
			existe = true;
		}
		return existe;
	}

	// Metodos para buscar
	public Materia buscarMateria(Integer codigo_materia) {
		Materia m = null;
		for (Materia materia : materias) {
			if (materia.getCodigo_materia().equals(codigo_materia)) {
				m = materia;
				return m;
			}
		}
		return m;
	}

	public Alumno buscarAlumnoRegistrado(Integer dni) {
		Alumno encontrado = null;
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				encontrado = alumno;
				return encontrado;
			}
		}
		return encontrado;
	}

	public Profesor buscarProfesorRegistrado(Integer dni) {
		Profesor encontrado = null;
		for (Profesor profe : profes) {
			if (profe.getDni().equals(dni)) {
				encontrado = profe;
				return encontrado;
			}
		}
		return encontrado;
	}

	public Aula buscarAulaPorNumero(Integer numero) {
		Aula encontrada = null;
		for (Aula a : aulas) {
			if (a.getNumero().equals(numero)) {
				encontrada = a;
				return encontrada;
			}
		}
		return encontrada;
	}

	public CicloLectivo buscarCicloLectivoPorID(Integer id) {
		CicloLectivo ciclo = null;
		for (CicloLectivo cicloLectivo : ciclosLectivos) {
			if (cicloLectivo.getId().equals(id)) {
				ciclo = cicloLectivo;
				return ciclo;
			}
		}
		return ciclo;
	}

	public Comision buscarComisionPorCodigo(Integer codigo_comision) {
		Comision comision = null;
		for (Comision c : comisiones) {
			if (c.getCodigo_comision().equals(codigo_comision)) {
				comision = c;
				return comision;
			}
		}
		return comision;
	}

	public AsignacionComisionAlumno buscarAsignacionAlumnoComision(Integer idComisionAlumno) {
		AsignacionComisionAlumno encontrado = null;
		for (AsignacionComisionAlumno asignacion : comisionesAlumno) {
			if (asignacion.getIdComisionAlumno().equals(idComisionAlumno)) {
				encontrado = asignacion;
				return encontrado;
			}
		}
		return encontrado;
	}

	public AsignacionComisionProfe buscarAsignacionProfeComision(Integer idComisionProfe) {
		AsignacionComisionProfe encontrado = null;
		for (AsignacionComisionProfe asignacion : comisionesProfe) {
			if (asignacion.getIdComision().equals(idComisionProfe)) {
				encontrado = asignacion;
				return encontrado;
			}
		}
		return encontrado;
	}

	// Metodos de inserción
	public Boolean agregarCorrelativaAMateria(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Materia materia = buscarMateria(codigoMateria);
		Materia correlativa = buscarMateria(codigoMateriaCorrelativa);
		Boolean sePudo = false;

		if (materia != null && correlativa != null) {
			materia.asignarCorrelativa(codigoMateriaCorrelativa);
			sePudo = true;
		}
		return sePudo;
	}

	public Boolean eliminarCorrelativaDeMateria(Integer codigoMateria, Integer codigoMateriaCorrelativa) {
		Materia materia = buscarMateria(codigoMateria);
		Materia correlativa = buscarMateria(codigoMateriaCorrelativa);
		Boolean sePudo = false;

		if (materia != null && correlativa != null) {
			materia.removerCorrelativa(codigoMateriaCorrelativa);
			sePudo = true;
		}
		return sePudo;
	}

	public Boolean asignarAulaAComision(Integer codigoComision, Aula aula) {
		Comision comision = buscarComisionPorCodigo(codigoComision);
		Aula a = buscarAulaPorNumero(aula.getNumero());
		Boolean sePudo = false;

		if (comision != null && a != null) {
			comision.setAula(aula);
			sePudo = true;
		}
		return sePudo;
	}

	public Boolean evaluarAlumnoComision(Integer idComisionAlumno, Double nota, ClaseDeNota tipo) {
		AsignacionComisionAlumno asignacion = buscarAsignacionAlumnoComision(idComisionAlumno);
		Boolean resultado = false;
		if (asignacion != null) {
			resultado = asignacion.registrarNota(nota, tipo);
		}
		return resultado;
	}

	public ArrayList<Comision> obtenerListaComisionesDeUnAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Comision> comisionesAlumno = new ArrayList<>();
		if (encontrado != null) {
			for (AsignacionComisionAlumno asignaciones : this.comisionesAlumno) {
				if (asignaciones.getDniAlumno().equals(dniAlumno)) {
					Comision encontrada = buscarComisionPorCodigo(asignaciones.getCodigo_comision());
					comisionesAlumno.add(encontrada);
				}
			}
		}
		return comisionesAlumno;
	}

	public ArrayList<AsignacionComisionAlumno> obtenerListaDeAsignacionesComisionAlumno(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<AsignacionComisionAlumno> asign = new ArrayList<>();
		if (encontrado != null) {
			for (AsignacionComisionAlumno asignaciones : this.comisionesAlumno) {
				if (asignaciones.getDniAlumno().equals(dniAlumno)) {
					asign.add(asignaciones);
				}
			}
		}
		return asign;
	}
	// No interesa la comision si las notas se guardan en la
	// asignacionComisionAlumno

	public ArrayList<Materia> listaMateriasAprobadas(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Materia> lista = new ArrayList<>();
		if (encontrado != null) {
			ArrayList<AsignacionComisionAlumno> asign = obtenerListaDeAsignacionesComisionAlumno(dniAlumno);

			for (AsignacionComisionAlumno curso : asign) {
				if (curso.obtenerPromedioFinal()>=7.0) {
					Comision buscar = buscarComisionPorCodigo(curso.getCodigo_comision());
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
	
	////////////////////////////////////// ACA ME QUEDE
	//No lo entendi
	public Boolean agregarAlumnoALaComision(Comision comision, AsignacionComisionAlumno asignacion, Integer dniAlumno) {
		Alumno buscado = buscarAlumnoRegistrado(dniAlumno);
		if (comision.inscribirAlumno(buscado)) {
			comisionesAlumno.add(asignacion);
			return true;
		}
		return false;
	}

	// Sobrecargaa de metodos para testear lo basico
	public Boolean inscribirAlumnoComision(Integer id, Integer codigoComision, Integer dniAlumno) {
		Comision comision = buscarComisionPorCodigo(codigoComision);
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
		Comision comision = buscarComisionPorCodigo(codigoComision);
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
