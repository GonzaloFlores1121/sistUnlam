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
		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Ejecucion

		// Evaluacion
	}

	@Test
	public void queSePuedaRegistrarUnaMateriaYEncontrarlaPorCodigo() {
		Integer codigo_materia = 2623;
		Materia materia = new Materia("PB2", codigo_materia);
		Universidad unlam = new Universidad();
		Materia esperada = null;

		unlam.registrarMaterias(materia);
		esperada = unlam.buscarMateria(codigo_materia);

		assertEquals(materia, esperada);
	}

	@Test
	public void queSePuedaRegistrarUnProfesor() {
		Integer dni = 444;
		String nombre = "A", apellido = "B";
		Double saldo = 9999.999;
		Profesor profe = new Profesor(dni, nombre, apellido, saldo);
		Universidad unlam = new Universidad();
		Profesor esperado = null;

		unlam.registrarProfesor(profe);
		esperado = unlam.buscarProfesorRegistrado(dni);

		assertEquals(esperado, profe);
	}

	@Test
	public void queNoSePuedaRegistrarDosMateriasConMismoCodigo() {
		Integer codigo_materia = 2623;
		Materia materia = new Materia("PB2", codigo_materia);
		Materia materiaError = new Materia("TW1", codigo_materia);
		Boolean operacion = false;
		Boolean operacion1 = false;
		Universidad unlam = new Universidad();

		operacion1 = unlam.registrarMaterias(materia);
		operacion = unlam.registrarMaterias(materiaError);

		assertTrue(operacion1);
		assertFalse(operacion);
	}

	@Test
	public void queSePuedaRegistrarUnAlumnoYEncontrarloPorDni() {
		Integer dni = 777;
		Alumno alm = new Alumno(dni, "F", "G");
		Universidad unlam = new Universidad();
		Alumno esperada = null;

		unlam.registrarAlumno(alm);
		esperada = unlam.buscarAlumnoRegistrado(dni);

		assertEquals(alm, esperada);
	}

	@Test
	public void queNoSePuedaRegistrarUnAlumnoConMismoDni() {
		Integer dni = 777;
		Alumno alm = new Alumno(dni, "F", "G");
		Alumno alm1 = new Alumno(dni, "A", "Z");
		Universidad unlam = new Universidad();
		Boolean op1 = false;
		Boolean op2 = false;

		op1 = unlam.registrarAlumno(alm);
		op2 = unlam.registrarAlumno(alm1);

		assertTrue(op1);
		assertFalse(op2);
	}

	@Test
	public void queNoSePuedaRegistrarCicloLectivoDondeFechasSeSuperpongan() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Universidad unlam = new Universidad();
		Boolean operacion = false;
		Boolean operacion1 = false;
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);

		operacion = unlam.registrarCicloLectivo(ciclo);
		operacion1 = unlam.registrarCicloLectivo(ciclo2);

		assertTrue(operacion);
		assertFalse(operacion1);

	}

	@Test
	public void queSePuedaRegistrarUnProfesorYEncontrarloPorDni() {
		Integer dni = 777;
		Double saldo = 0.0;
		Profesor profe = new Profesor(dni, "F", "G", saldo);
		Universidad unlam = new Universidad();
		Profesor esperado = null;

		unlam.registrarProfesor(profe);
		esperado = unlam.buscarProfesorRegistrado(dni);

		assertEquals(profe, esperado);
	}

	@Test
	public void queSePuedaRegistrarUnaComisionYEncontrarloPorCodigoYID() {
		Integer numero = 999, capacidadMax = 50, dniAlumno = 777, dniProfesor = 8888, codigoComision = 2900;

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Turno turno = Turno.TURNO_MAÑANA;
		Dia dia = Dia.LUNES;

		Materia tw1 = new Materia("TALLER WEB1", 2300);

		Aula aula = new Aula(numero, capacidadMax);
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Profesor profe = new Profesor(dniProfesor, "F", "G", 0.0);
		Comision comision = new Comision(codigoComision, dia, turno, ciclo, tw1, aula);

		Integer id_comision = comision.getId();

		Comision esperada = null;
		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alm);
		unlam.registrarProfesor(profe);
		unlam.registrarMaterias(tw1);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		esperada = unlam.buscarComisionPorCodigoYID(codigoComision, id_comision);

		assertEquals(esperada, comision);

	}

	@Test
	public void queSePuedaAsignarAulaAUnComision() {
		Universidad unlam = new Universidad();
		Integer codigoCurso = 1;
		Comision comision = new Comision(codigoCurso);
		Integer numero = 416;
		Integer capacidadMax = 50;
		Integer idComision = comision.getId();

		Aula aula = new Aula(numero, capacidadMax);
		unlam.registrarComision(comision);
		unlam.registrarAula(aula);
		Boolean resultado = unlam.asignarAulaAComision(idComision, codigoCurso, aula);

		assertTrue(resultado);
	}

///////////////////////////////////
	@Test
	public void queSePuedaAsignarCorrelativasAMateria() {

		Integer codigoMateria = 2900;
		Integer codigoMateriaCorrelativa = 3000;
		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
		Universidad unlam = new Universidad();
		Boolean operacion = false;

		unlam.registrarMaterias(tw1);
		unlam.registrarMaterias(pb2);

		operacion = unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
		assertTrue(operacion);
	}

	@Test
	public void queSePuedaEliminarCorrelativasAMateria() {

		Integer codigoMateria = 2900;
		Integer codigoMateriaCorrelativa = 3000;
		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
		Universidad unlam = new Universidad();
		Boolean operacion = false;

		unlam.registrarMaterias(tw1);
		unlam.registrarMaterias(pb2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
		operacion = unlam.eliminarCorrelativaDeMateria(codigoMateria, codigoMateriaCorrelativa);
		int cantidad = tw1.cantidadCorrelativas();

		assertTrue(operacion);
		assertEquals(cantidad, 0);

	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCurso() {
		Integer dniAlumno = 412421, codigoComision = 1;
		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Comision comision = new Comision(codigoComision);
		Integer idComision = comision.getId();

		unlam.registrarAlumno(alm);
		unlam.registrarComision(comision);

		Boolean exitoso = unlam.inscribirAlumnoComision(idComision, codigoComision, dniAlumno);

		assertTrue(exitoso);
	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCursoSiTieneLasCorrelativasAprobadas() {
		Integer codigoMateria = 2300;
		Integer codigoMateria1 = 2626;
		Integer codigoMateria2 = 2500;
		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pw1 = new Materia("Pw1", codigoMateria2);
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);

		Integer codigoComision1 = 1;
		Integer codigoComision2 = 2;
		Integer codigoComision3 = 3;
		Integer codigoComision4 = 4;

		Comision comision1 = new Comision(codigoComision1, pb2);
		Comision comision2 = new Comision(codigoComision2, pw1);
		Comision comision3 = new Comision(codigoComision3, bdd1);
		Comision comision4 = new Comision(codigoComision4, tw1);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");

		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
		Integer idComision1 = comision1.getId();
		Integer idComision2 = comision2.getId();
		Integer idComision3 = comision3.getId();
		Integer idComision4 = comision4.getId();

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(tw1);
		unlam.registrarComision(comision1);
		unlam.registrarComision(comision2);
		unlam.registrarComision(comision3);
		unlam.registrarComision(comision4);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);

		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcial1, parcial2);

		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
				dniAlumno, codigoMateria);

		AsignacionComisionAlumno asign = unlam.buscarAsignacionAlumnoComision(idComision4, codigoComision4, dniAlumno);

		assertNotNull(asign);
		assertTrue(operacion);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnCursoSiNoTieneLasCorrelativasAprobadas() {
		Integer codigoMateria = 2300;
		Integer codigoMateria1 = 2626;
		Integer codigoMateria2 = 2500;
		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pw1 = new Materia("Pw1", codigoMateria2);
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);

		Integer codigoComision1 = 1;
		Integer codigoComision2 = 2;
		Integer codigoComision3 = 3;
		Integer codigoComision4 = 4;

		Comision comision1 = new Comision(codigoComision1, pb2);
		Comision comision2 = new Comision(codigoComision2, pw1);
		Comision comision3 = new Comision(codigoComision3, bdd1);
		Comision comision4 = new Comision(codigoComision4, tw1);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");

		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
		Nota parcialError = new Nota(2.0, TipoNota.PARCIAL_UNO);// corregir con clases de nota
		Integer idComision1 = comision1.getId();
		Integer idComision2 = comision2.getId();
		Integer idComision3 = comision3.getId();
		Integer idComision4 = comision4.getId();

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(tw1);
		unlam.registrarComision(comision1);
		unlam.registrarComision(comision2);
		unlam.registrarComision(comision3);
		unlam.registrarComision(comision4);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);

		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcialError, parcial2);

		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
				dniAlumno, codigoMateria);

		assertFalse(operacion);
	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCursoSiEstaDentroDeLaFechaDeInscripcion() {

		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		LocalDate fechaInscripto = LocalDate.of(2023, 8, 1);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Turno turno = Turno.TURNO_MAÑANA;
		Integer codigoComision = 5000;
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
		Integer idComision = comision2.getId();

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(bdd1);
		unlam.registrarComision(comision2);
		unlam.registrarCicloLectivo(ciclo);

		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
				dniAlumno, fechaInscripto);

		assertTrue(operacion);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaFueraDeLaFechaDeInscripcion() {

		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		LocalDate fechaInscripto = LocalDate.of(2024, 8, 1);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Turno turno = Turno.TURNO_MAÑANA;
		Integer codigoComision = 5000;
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
		Integer idComision = comision2.getId();

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(bdd1);
		unlam.registrarComision(comision2);
		unlam.registrarCicloLectivo(ciclo);

		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
				dniAlumno, fechaInscripto);

		assertFalse(operacion);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaElCupoLLeno() {
		Integer codigoMateria1 = 2626;
		Integer dniAlumno = 412421;
		Integer codigoComision = 3000;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Integer numero = 266;
		Integer capacidadMax = 1;

		Aula aula = new Aula(numero, capacidadMax);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);

		Universidad unlam = new Universidad();
		Alumno alm1 = new Alumno(543423333, "F", "G");
		Alumno alm2 = new Alumno(dniAlumno, "F", "G");

		unlam.registrarAlumno(alm1);
		unlam.registrarAlumno(alm2);
		unlam.registrarMaterias(pb2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);
		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);
		unlam.inscribirAlumnoComision(comision.getId(), codigoComision, 543423333);

		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
				dniAlumno);

		assertFalse(operacion);

	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCursoSiHayCupo() {
		Integer codigoMateria1 = 2626;
		Integer dniAlumno = 412421;
		Integer codigoComision = 3000;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Integer numero = 266;
		Integer capacidadMax = 50;

		Aula aula = new Aula(numero, capacidadMax);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);
		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);

		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
				dniAlumno);

		assertTrue(operacion);

	}

	@Test
	public void queNoPuedaInscribirseAUnCursoPorqueSeSuperponeConOtroCursoYSusHorarios() {
		Alumno alumno = new Alumno(1234, "f", "g");
		Integer codigoMateria1 = 2500, codigoComision = 2626;
		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pb1 = new Materia("Pb1", 2300);

		Comision comision = new Comision(codigoComision, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
		Integer idComision = comision.getId();
		Comision comision2 = new Comision(2900, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);

		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pb1);
		unlam.registrarComision(comision);

		unlam.inscribirAlumnoComision(idComision, codigoComision, 1234);

		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);

		assertFalse(operacion);
	}

	@Test
	public void queSePuedaInscribirAUnCursoPorqueNoSeSuperponeConOtroCursoYSusHorarios() {
		Alumno alumno = new Alumno(1234, "f", "g");
		Integer codigoMateria1 = 2500, codigoComision2 = 2900, codigoComision1 = 2626;
		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pb1 = new Materia("Pb1", 2300);

		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
		Integer idComision = comision1.getId();

		Comision comision2 = new Comision(codigoComision2, Dia.MARTES, Turno.TURNO_MAÑANA, pb2);
		Integer idComision2 = comision2.getId();
		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pb1);
		unlam.registrarComision(comision1);
		unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);

		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);

		AsignacionComisionAlumno asig = unlam.buscarAsignacionAlumnoComision(idComision2, codigoComision2, 1234);

		assertNotNull(asig);
		assertTrue(operacion);
	}

}
