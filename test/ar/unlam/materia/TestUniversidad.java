package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TestUniversidad {
	// chau pichu
	@Test
	public void queSeCreeLaUniversidad() {
		Universidad unlam = new Universidad();

		assertNotNull(unlam);
		assertNotNull(unlam.getMaterias());
		assertNotNull(unlam.getAlumnos());
		assertNotNull(unlam.getProfes());
		assertNotNull(unlam.getAulas());
		assertNotNull(unlam.getCiclosLectivos());
		assertNotNull(unlam.getComisiones());
		assertNotNull(unlam.getComisionesAlumno());// Se crean cuando se inscribe
		assertNotNull(unlam.getComisionesProfe());// Se crean cuando se inscribe
	}

	@Test
	public void queSeCreeMateriasAlumnosProfesAulasComisionesYCicloLectivo() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		// Yo puedo registrar a un alumno en la facu que no esta cursando?
		unlam.registrarAlumno(alumno);
		////////////////////////////////
		unlam.registrarProfesor(profe);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		Integer ve = 1;
		// Evaluacion

		Integer vo = unlam.getMaterias().size();
		assertEquals(ve, vo);
		vo = unlam.getAlumnos().size();
		assertEquals(ve, vo);
		vo = unlam.getProfes().size();
		assertEquals(ve, vo);
		vo = unlam.getAulas().size();
		assertEquals(ve, vo);
		vo = unlam.getCiclosLectivos().size();
		assertEquals(ve, vo);
		vo = unlam.getComisiones().size();
		assertEquals(ve, vo);
	}

	@Test
	public void queSeCreeAtributosDiferentes() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		Integer dni2 = 124;

		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Integer dniP2 = 124;
		Profesor profe2 = new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		Integer Id_Aula2 = 2;
		Aula aula2 = new Aula(Id_Aula2, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 1;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Integer idCiclo2 = 2;
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2024, 6, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2024, 6, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 7, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		Integer idComision2 = 2;
		Turno turno2 = Turno.TURNO_MAÑANA;
		Dia day2 = Dia.LUNES;
		Comision comision2 = new Comision(idComision2, day2, turno2, ciclo2, materia2, aula2);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		// Yo puedo registrar a un alumno en la facu que no esta cursando?
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno2);
		////////////////////////////////
		unlam.registrarProfesor(profe);
		unlam.registrarProfesor(profe2);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarComision(comision);
		unlam.registrarComision(comision2);

		Integer ve = 2;
		// Evaluacion

		Integer vo = unlam.getMaterias().size();
		assertEquals(ve, vo);
		vo = unlam.getAlumnos().size();
		assertEquals(ve, vo);
		vo = unlam.getProfes().size();
		assertEquals(ve, vo);
		vo = unlam.getAulas().size();
		assertEquals(ve, vo);
		vo = unlam.getCiclosLectivos().size();
		assertEquals(ve, vo);
		vo = unlam.getComisiones().size();
		assertEquals(ve, vo);
	}

	@Test
	public void queSePuedaUbicarDeterminadosAtributos() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		Integer dni2 = 124;

		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Integer dniP2 = 124;
		Profesor profe2 = new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		Integer Id_Aula2 = 2;
		Aula aula2 = new Aula(Id_Aula2, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 1;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Integer idCiclo2 = 2;
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2024, 6, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2024, 6, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 7, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Integer idComision2 = 2;
		Turno turno2 = Turno.TURNO_MAÑANA;
		Dia day2 = Dia.LUNES;
		Comision comision2 = new Comision(idComision2, day2, turno2, ciclo2, materia2, aula2);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		// Yo puedo registrar a un alumno en la facu que no esta cursando?
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno2);
		////////////////////////////////
		unlam.registrarProfesor(profe);
		unlam.registrarProfesor(profe2);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarComision(comision);
		unlam.registrarComision(comision2);

		// Evaluacion
		assertNotNull(unlam.buscarMateria(codigoMateria2));
		assertNotNull(unlam.buscarAlumnoRegistrado(dni));
		assertNotNull(unlam.buscarProfesorRegistrado(dniP2));
		assertNotNull(unlam.buscarAulaPorNumero(Id_Aula2));
		assertNotNull(unlam.buscarCicloLectivoPorID(idCiclo));
		assertNotNull(unlam.buscarComisionPorCodigo(idComision2));
	}

	@Test
	public void queSePuedaRegistrarUnaMateriaCorrelativa() {
		// Preparacio
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);

		Universidad unlam = new Universidad();

		Materia materiaBuscada = null;

		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		Boolean resultado = unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
		materiaBuscada = unlam.buscarMateria(codigoMateria);

		Integer ve = 1;
		Integer vo = materiaBuscada.getCodigoCorrelativa().size();

		// Evaluacion
		assertEquals(materia, materiaBuscada);
		assertEquals(ve, vo);
		assertEquals(materia2.getCodigo_materia(), materiaBuscada.getCodigoCorrelativa().get(0));// compara el codigo de
																									// materia
		assertTrue(resultado);
	}

	@Test
	public void queSePuedaAsignarAulaAUnComision() {
		// Preparacion
		Universidad unlam = new Universidad();

		Integer codigoCurso = 1;
		Comision comision = new Comision(codigoCurso);

		Integer numero = 1;
		Integer capacidadMax = 10;
		Aula aula = new Aula(numero, capacidadMax);

		// Ejecucion
		unlam.registrarComision(comision);
		unlam.registrarAula(aula);
		Boolean resultado = unlam.asignarAulaAComision(codigoCurso, aula);

		// Evaluacion
		assertTrue(resultado);
		assertEquals(aula, comision.getAula());
	}

	@Test
	public void queSePuedaEliminarCorrelativasAMateria() {

		Integer codigoMateria = 1;
		Integer codigoMateriaCorrelativa = 2;
		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
		Universidad unlam = new Universidad();

		unlam.registrarMaterias(tw1);
		unlam.registrarMaterias(pb2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
		int cant = tw1.cantidadCorrelativas();
		Boolean operacion = unlam.eliminarCorrelativaDeMateria(codigoMateria, codigoMateriaCorrelativa);
		int cantidad = tw1.cantidadCorrelativas();

		assertEquals(1, cant);
		assertEquals(0, cantidad);
		assertTrue(operacion);

	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCurso() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		Integer IdDeLaAsignacion = 1;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
				idComision);

		Integer ve = 1;
		Integer vo = comision.getAlumnos().size();
		// Evaluacion
		assertEquals(ve, vo);
		assertTrue(resultado);
	}

	@Test
	public void queNoSePuedaInscribirAlumnoDosVecesAlUnCursoDelMismoCiclo() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		Integer IdDeLaAsignacion = 1;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		Integer dni2 = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
				idComision);
		Boolean resultado2 = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni2, fechaDeInscripcionALaComision,
				idComision);

		Integer ve = 1;
		Integer vo = comision.getAlumnos().size();
		// Evaluacion
		assertEquals(ve, vo);
		assertTrue(resultado);
		assertFalse(resultado2);
	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnaMateriaQueDebeLaCorrelativa() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		Integer IdDeLaAsignacion = 1;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);
		materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia2, aula);

		Universidad unlam = new Universidad();
		Materia materiaBuscada = null;
		Materia materiaBuscada2 = null;
		// Ejecucion

		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		Boolean resultado2 = unlam.agregarCorrelativaAMateria(codigoMateria2,codigoMateria);
		materiaBuscada = unlam.buscarMateria(codigoMateria);
		materiaBuscada2 = unlam.buscarMateria(codigoMateria2);

		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
				idComision);

		Integer ve = 0;
		Integer vo = comision.getAlumnos().size();
		// Evaluacion
		assertTrue(resultado2);
		assertFalse(resultado);
		assertNotNull(materiaBuscada);
		assertNotNull(materiaBuscada2);
		assertEquals(ve, vo);
	}

	@Test
	public void queSeLePuedaEvaluarAUnAlumno() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		Integer IdDeLaAsignacion = 1;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Universidad unlam = new Universidad();
		Materia materiaBuscada = null;

		// Nota
		Double valor = 7.0;
		ClaseDeNota tipo = ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota tipo2 = ClaseDeNota.SEGUNDO_PARCIAL;
		// Ejecucion

		unlam.registrarMaterias(materia);
		materiaBuscada = unlam.buscarMateria(codigoMateria);

		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision, idComision);

		Boolean resultado = unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
		AsignacionComisionAlumno buscado=unlam.buscarAsignacionAlumnoComision(IdDeLaAsignacion);
		ClaseDeNota nota=buscado.getNotas().get(0).getTipoDeNota();
		
		Integer ve = 1;
		Integer vo = comision.getAlumnos().size();
		Integer voAsignacion = unlam.getComisionesAlumno().size();
		// Evaluacion
		assertTrue(resultado);
		assertNotNull(materiaBuscada);
		assertEquals(ve, voAsignacion);
		assertEquals(tipo, nota);
	}
	
	@Test
	public void queSeLePuedaEvaluarElPromedioFinalDeUnAlumno() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		Integer IdDeLaAsignacion = 1;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		materia = new Materia(nombreMateria, codigoMateria);
		
		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		
		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		
		Universidad unlam = new Universidad();
		Materia materiaBuscada = null;
		
		// Nota
		Double valor = 7.0;
		ClaseDeNota tipo = ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota tipo2 = ClaseDeNota.SEGUNDO_PARCIAL;
		// Ejecucion
		
		unlam.registrarMaterias(materia);
		
		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);
		
		unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision, idComision);
		
		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo2);
		AsignacionComisionAlumno buscado=unlam.buscarAsignacionAlumnoComision(IdDeLaAsignacion);
		ClaseDeNota nota=buscado.getNotas().get(0).getTipoDeNota();
		ClaseDeNota nota2=buscado.getNotas().get(1).getTipoDeNota();

		Double ve=7.0;
		Double valorObtenido=unlam.promedioFinal(IdDeLaAsignacion);
		// Evaluacion
		assertEquals(tipo, nota);
		assertEquals(tipo2, nota2);
		assertEquals(ve, valorObtenido);
	}

	@Test
	public void queSePuedaInscribirAlumnoAUnaMateriaQueTengaLaCorrelativaAprobada() {
		// Preparacion
		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
		LocalDate fechaDeInscripcionALaComision2 = LocalDate.of(2025, 3, 11);
		Integer IdDeLaAsignacion = 1;
		Integer IdDeLaAsignacion2 = 2;
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);
		materia = new Materia(nombreMateria, codigoMateria);
		
		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		
		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		
		//ciclo2
		Integer idCiclo2 = 1;
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2025, 3, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2025, 3, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2025, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2025, 7, 16);
		Cuatrimestre cuatri2 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
//		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		Integer idComision2 = 2;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		Comision comision2 = new Comision(idComision2, day, turno, ciclo2, materia2, aula);
		
		Universidad unlam = new Universidad();
		
		//Nota
		Double valor=7.0;
		ClaseDeNota tipo=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota tipo2=ClaseDeNota.SEGUNDO_PARCIAL;
		// Ejecucion
		
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		Boolean resultado = unlam.agregarCorrelativaAMateria(codigoMateria2,codigoMateria);
		
		unlam.registrarAlumno(alumno);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarComision(comision);
		unlam.registrarComision(comision2);
		
		Boolean resultado2 = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
				idComision);
		Integer ve=1;
		Integer vo=unlam.getComisionesAlumno().size();
		
		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo2);
		
		Boolean resultado3 = unlam.inscribirAlumnoComision(IdDeLaAsignacion2, dni, fechaDeInscripcionALaComision2,
				idComision2);
		
		Integer ve2=2;
		Integer vo2=unlam.getComisionesAlumno().size();
	
		// Evaluacion
		assertEquals(ve,vo);
		assertTrue(resultado);
		assertTrue(resultado2);
		assertTrue(resultado3);
		assertEquals(ve2,vo2);
	}

//	@Test
//	public void queSePuedaInscribirAlumnoAUnCursoSiTieneLasCorrelativasAprobadas() {
//		Integer codigoMateria = 2300;
//		Integer codigoMateria1 = 2626;
//		Integer codigoMateria2 = 2500;
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//
//		Integer codigoComision1 = 1;
//		Integer codigoComision2 = 2;
//		Integer codigoComision3 = 3;
//		Integer codigoComision4 = 4;
//
//		Comision comision1 = new Comision(codigoComision1, pb2);
//		Comision comision2 = new Comision(codigoComision2, pw1);
//		Comision comision3 = new Comision(codigoComision3, bdd1);
//		Comision comision4 = new Comision(codigoComision4, tw1);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
//		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
//		Integer idComision1 = comision1.getId();
//		Integer idComision2 = comision2.getId();
//		Integer idComision3 = comision3.getId();
//		Integer idComision4 = comision4.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(tw1);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);
//
//		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcial1, parcial2);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
//				dniAlumno, codigoMateria);
//
//		AsignacionComisionAlumno asign = unlam.buscarAsignacionAlumnoComision(idComision4, codigoComision4, dniAlumno);
//
//		assertNotNull(asign);
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnCursoSiNoTieneLasCorrelativasAprobadas() {
//		Integer codigoMateria = 2300;
//		Integer codigoMateria1 = 2626;
//		Integer codigoMateria2 = 2500;
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//
//		Integer codigoComision1 = 1;
//		Integer codigoComision2 = 2;
//		Integer codigoComision3 = 3;
//		Integer codigoComision4 = 4;
//
//		Comision comision1 = new Comision(codigoComision1, pb2);
//		Comision comision2 = new Comision(codigoComision2, pw1);
//		Comision comision3 = new Comision(codigoComision3, bdd1);
//		Comision comision4 = new Comision(codigoComision4, tw1);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
//		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
//		Nota parcialError = new Nota(2.0, TipoNota.PARCIAL_UNO);// corregir con clases de nota
//		Integer idComision1 = comision1.getId();
//		Integer idComision2 = comision2.getId();
//		Integer idComision3 = comision3.getId();
//		Integer idComision4 = comision4.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(tw1);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);
//
//		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcialError, parcial2);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
//				dniAlumno, codigoMateria);
//
//		assertFalse(operacion);
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnCursoSiEstaDentroDeLaFechaDeInscripcion() {
//
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		LocalDate fechaInscripto = LocalDate.of(2023, 8, 1);
//		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
//		Turno turno = Turno.TURNO_MAÑANA;
//		Integer codigoComision = 5000;
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
//		Integer idComision = comision2.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarComision(comision2);
//		unlam.registrarCicloLectivo(ciclo);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
//				dniAlumno, fechaInscripto);
//
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaFueraDeLaFechaDeInscripcion() {
//
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		LocalDate fechaInscripto = LocalDate.of(2024, 8, 1);
//		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
//		Turno turno = Turno.TURNO_MAÑANA;
//		Integer codigoComision = 5000;
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
//		Integer idComision = comision2.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarComision(comision2);
//		unlam.registrarCicloLectivo(ciclo);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
//				dniAlumno, fechaInscripto);
//
//		assertFalse(operacion);
//
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaElCupoLLeno() {
//		Integer codigoMateria1 = 2626;
//		Integer dniAlumno = 412421;
//		Integer codigoComision = 3000;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Integer numero = 266;
//		Integer capacidadMax = 1;
//
//		Aula aula = new Aula(numero, capacidadMax);
//
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
//		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);
//
//		Universidad unlam = new Universidad();
//		Alumno alm1 = new Alumno(543423333, "F", "G");
//		Alumno alm2 = new Alumno(dniAlumno, "F", "G");
//
//		unlam.registrarAlumno(alm1);
//		unlam.registrarAlumno(alm2);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);
//		unlam.inscribirAlumnoComision(comision.getId(), codigoComision, 543423333);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
//				dniAlumno);
//
//		assertFalse(operacion);
//
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnCursoSiHayCupo() {
//		Integer codigoMateria1 = 2626;
//		Integer dniAlumno = 412421;
//		Integer codigoComision = 3000;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Integer numero = 266;
//		Integer capacidadMax = 50;
//
//		Aula aula = new Aula(numero, capacidadMax);
//
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
//		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
//				dniAlumno);
//
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queNoPuedaInscribirseAUnCursoPorqueSeSuperponeConOtroCursoYSusHorarios() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoComision = 2626;
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pb1 = new Materia("Pb1", 2300);
//
//		Comision comision = new Comision(codigoComision, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision.getId();
//		Comision comision2 = new Comision(2900, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//
//		Universidad unlam = new Universidad();
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision);
//
//		unlam.inscribirAlumnoComision(idComision, codigoComision, 1234);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);
//
//		assertFalse(operacion);
//	}
//
//	@Test
//	public void queSePuedaInscribirAUnCursoPorqueNoSeSuperponeConOtroCursoYSusHorarios() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoComision2 = 2900, codigoComision1 = 2626;
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pb1 = new Materia("Pb1", 2300);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision1.getId();
//
//		Comision comision2 = new Comision(codigoComision2, Dia.MARTES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision2 = comision2.getId();
//		Universidad unlam = new Universidad();
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision1);
//		unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);
//
//		AsignacionComisionAlumno asig = unlam.buscarAsignacionAlumnoComision(idComision2, codigoComision2, 1234);
//
//		assertNotNull(asig);
//		assertTrue(operacion);
//	}

}
