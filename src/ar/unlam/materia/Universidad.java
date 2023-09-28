package ar.unlam.materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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

	public Double promedioFinal(Integer idDeLaAsignacion) {
		Double promedioFinal = 0.0;
		AsignacionComisionAlumno buscado = this.buscarAsignacionAlumnoComision(idDeLaAsignacion);

		if (buscado != null) {
			promedioFinal = buscado.obtenerPromedioFinal();
		}
		return promedioFinal;
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

	public ArrayList<Materia> listaMateriasAprobadas(Integer dniAlumno) {
		Alumno encontrado = buscarAlumnoRegistrado(dniAlumno);
		ArrayList<Materia> lista = new ArrayList<>();
		if (encontrado != null) {
			ArrayList<AsignacionComisionAlumno> asign = obtenerListaDeAsignacionesComisionAlumno(dniAlumno);

			for (AsignacionComisionAlumno curso : asign) {
				if (curso.obtenerPromedioFinal() >= 4.0) {
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
	// No lo entendi
	public Boolean agregarAlumnoALaComision(Comision comision, AsignacionComisionAlumno asignacion, Integer dniAlumno) {
		Alumno buscado = buscarAlumnoRegistrado(dniAlumno);
		if (comision.inscribirAlumno(buscado)) {
			comisionesAlumno.add(asignacion);
			return true;
		}
		return false;
	}

	// Sobrecargaa de metodos para testear lo basico
	public Boolean inscribirAlumnoComision(Integer codigoComision, Integer dniAlumno, LocalDate fechaDeInscripcion,
			Integer idComisionAlumno) {

		Comision comision = buscarComisionPorCodigo(codigoComision);
		Alumno alumno = buscarAlumnoRegistrado(dniAlumno);
		// Condiciones
//		Boolean resultadoFechas=this.seRegistroDentroDelRangoDeFechas(fechaDeInscripcion,codigoComision );
		Boolean horariosDisponibles = this.alumnoTieneHorariosDisponible(dniAlumno, codigoComision);
		Boolean espacioEnLacomision = comision.getAlumnos().size() < comision.getAula().getCapacidadMax();
		Boolean estaEnLaComision = comision.getAlumnos().contains(alumno);
		Boolean tieneLasCorrelativasAprobadas = this.siTieneLasCorrelativasAprobadas(codigoComision, dniAlumno);
		Boolean resultado = false;

		if (comision != null && alumno != null && resultadoFechas(fechaDeInscripcion, codigoComision)
				&& horariosDisponibles && espacioEnLacomision && !estaEnLaComision && tieneLasCorrelativasAprobadas) {
			comision.inscribirAlumno(alumno);
			{
				AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(idComisionAlumno, codigoComision,
						dniAlumno);
				comisionesAlumno.add(asignacion);
				resultado = true;
			}
		}
		return resultado;
	}

	private Boolean resultadoFechas(LocalDate fechaDeInscripcion, Integer codigoComision) {
		Boolean resultadoFechas = this.seRegistroDentroDelRangoDeFechas(fechaDeInscripcion, codigoComision);
		return resultadoFechas;
	}

	private Boolean siTieneLasCorrelativasAprobadas(Integer codigoComision, Integer dniAlumno) {
		Boolean tieneLasMateriasAprobadas = true;
		Comision comision = buscarComisionPorCodigo(codigoComision);
		ArrayList<Materia> lista = listaMateriasAprobadas(dniAlumno);
		Materia materia = comision.getMateria();
		Boolean tieneCorrelativas = materia.cantidadCorrelativas() != 0;

		if (comision != null && tieneCorrelativas) {
			Integer cant = materia.cantidadCorrelativas();
			Integer i = 0;
			for (Integer codCorrelativa : materia.getCodigoCorrelativa()) {
				for (Materia materias : lista) {
					if (codCorrelativa.equals(materias.getCodigo_materia())) {
						i++;
					}
				}
			}
			if (i != cant) {
				tieneLasMateriasAprobadas = false;
			}
		}
		return tieneLasMateriasAprobadas;
	}

	public Boolean alumnoTieneHorariosDisponible(Integer dniAlumno, Integer codigoComision) {
		Comision comision = this.buscarComisionPorCodigo(codigoComision);
		Boolean tieneTiempo = false;
		if (comision != null) {
			ArrayList<Comision> comisionDelAlumno = obtenerListaComisionesDeUnAlumno(dniAlumno);
			if (comisionDelAlumno.size() != 0) {
				for (Comision comisionAlumno : comisionDelAlumno) {
					if (comisionAlumno.getCiclo() != comision.getCiclo() || (comisionAlumno.getDia() != comision.getDia()
									|| comisionAlumno.getTurno() != comision.getTurno())) {
						tieneTiempo = true;
					}
				}
			} else if (comisionDelAlumno.isEmpty()) {
				tieneTiempo = true;
			}
		}
		return tieneTiempo;
	}

	public Boolean seRegistroDentroDelRangoDeFechas(LocalDate fechaDeInscripcionAlumno, Integer codigoComision) {
		Comision comision = this.buscarComisionPorCodigo(codigoComision);
		Boolean resultado = false;

		if (comision != null) {
			LocalDate fechaDeInscripcionComisionInicio = comision.getCiclo().getFechaDeInicioInscripcion();
			LocalDate fechaDeInscripcionComisionFin = comision.getCiclo().getFechaFinalizacionInscripcion();

			if (VerificadorDeFecha.fechaEnRango(fechaDeInscripcionComisionInicio, fechaDeInscripcionComisionFin,
					fechaDeInscripcionAlumno)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public Boolean verificarSiFechaEstaDentroDelRango(LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion,
			LocalDate fechaInscripto) {

		return VerificadorDeFecha.fechaEnRango(fechaInicioInscripcion, fechaFinInscripcion, fechaInscripto);
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
		if (parcial1 != null && parcial2 != null) {
			if (parcial1.getValor() > 7 && parcial2.getValor() > 7) {
				return true;
			}
		}
		return false;
	}

	public Boolean registrarNota(Integer idComision, Integer codigoComisionAlumno, Integer dni, Nota nota) {
		Boolean resultado = false;
		// Se busca la comision para obtener la materia
		Comision comision = buscarComisionPorCodigo(idComision);
		AsignacionComisionAlumno asignacion = buscarAsignacionAlumnoComision(codigoComisionAlumno);

		if (comision != null && buscarMateria(comision.getMateria().getCodigo_materia()) != null) {
			ArrayList<Integer> correlativas = comision.getMateria().getCodigoCorrelativa();

			// Si la materia no tiene correlativas entra en este if

			if (correlativas.size() == 0) {

				if (asignacion != null) {

					resultado = agregarParcial(asignacion, nota);
				}
			} else {
				// si tiene mas correlativas que busque y vea si estan aprobadas
				if (!verificarCorrelativasAprobadas(dni, comision.getMateria().getCodigo_materia())) {

					// Si no tiene las correlativas aprobadas,las condiciones paraa sus notas seran
					// ded 1-6,si es >6 su nota se seteara en 6
					// Si la nota es <,se seteara la correspondiente
					resultado = agregarParcialCondicionCorrelativa(asignacion, nota);
				} else {
					resultado = agregarParcial(asignacion, nota);
				}
			}

		}
		return resultado;

	}

	public Boolean agregarParcial(AsignacionComisionAlumno asignacion, Nota nota) {
		Boolean operacion = false;
		switch (nota.getTipo()) {
		case PARCIAL_UNO:
			asignacion.setParcial1(nota);
			operacion = true;
			break;

		case PARCIAL_DOS:
			asignacion.setParcial2(nota);
			operacion = true;
			break;
		case RECUPERATORIO:
			if (nota.getEsParcial1()) {
				asignacion.setParcial1(nota);
				operacion = true;
			} else {
				asignacion.setParcial2(nota);
				operacion = true;
			}
			break;
		}
		return operacion;
	}

	public Boolean agregarParcialCondicionCorrelativa(AsignacionComisionAlumno asignacion, Nota nota) {
		Boolean operacion = false;
		switch (nota.getTipo()) {
		case PARCIAL_UNO:
			if (nota.getValor() > 6) {
				nota.setValor(6.0);
				asignacion.setParcial1(nota);
				operacion = true;
			} else {
				asignacion.setParcial1(nota);
				operacion = true;
			}
			break;

		case PARCIAL_DOS:
			if (nota.getValor() > 6) {
				nota.setValor(6.0);
				asignacion.setParcial2(nota);
				operacion = true;
			} else {
				asignacion.setParcial2(nota);
				operacion = true;
			}
			break;
		case RECUPERATORIO:
			if (nota.getEsParcial1()) {
				if (nota.getValor() > 6) {
					nota.setValor(6.0);

					asignacion.setParcial1(nota);
					operacion = true;
				} else {
					asignacion.setParcial1(nota);
					operacion = true;
				}
			} else {
				if (nota.getValor() > 6) {
					nota.setValor(6.0);
					asignacion.setParcial2(nota);
					operacion = true;
				} else {
					asignacion.setParcial2(nota);
					operacion = true;
				}
			}

		}
		return operacion;
	}

	public void inscribirProfesoresAComision(Integer idComision, Integer codigoComision) {
		Random rand = new Random();
		Comision comision = buscarComisionPorCodigo(codigoComision);
		if (comision != null) {
			Integer cantidadAlumnos = 45;
			Integer cantidadProfes = cantidadAlumnos / 20;
			ArrayList<Profesor> profe = profes;

			while (cantidadProfes > 0 || profe.size() == 0) {
				int indiceAleatorio = rand.nextInt(profe.size());
				comision.inscribirProfesor(profe.get(indiceAleatorio));
				profe.remove(indiceAleatorio);
				cantidadProfes--;

			}
		}

	}

	public ArrayList<Materia> obtenerListaMateriasPorCursar(ArrayList<Materia> planDeEstudio, Integer dniAlumno) {
		ArrayList<Materia> mAlumno = listaMateriasAprobadas(dniAlumno);

	planDeEstudio.removeAll(mAlumno);
	return planDeEstudio;
		
		
	}
	
	public Comision buscarComisionPorCodigoYID(Integer codigo_comision, Integer id) {
		for (Comision c : comisiones) {
			if (c != null && c.getCodigo_comision().equals(codigo_comision) && c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
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
		
		public Boolean verificarCapacidadAula(Comision comision) {
			Integer capacidadActual = comision.obtenerCantidadDeAlumnosInscriptos();
			if (capacidadActual < comision.getAula().getCapacidadMax()) {
				return true;
			}

			return false;
		}
}
