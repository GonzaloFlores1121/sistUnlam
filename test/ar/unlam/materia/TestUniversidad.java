package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TestUniversidad {

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
	public void queNoSePuedaGenerarDosComisionesIguales() {
		Integer id_ciclolectivo = 1, id_comision = 999;
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Turno turno = Turno.TURNO_MAÑANA;
		Materia tw1 = new Materia("TALLER WEB1", 2300);

		CicloLectivo ciclo1 = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo1,
				fechaInicioCicloLectivo1, fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Comision comi = new Comision(id_comision, turno, ciclo1, tw1);
		Comision comi1 = new Comision(id_comision, turno, ciclo1, tw1);
		Universidad unlam = new Universidad();
		Boolean operacion1 = false;
		Boolean operacion2 = false;

		unlam.registrarMaterias(tw1);

		unlam.registrarCicloLectivo(ciclo1);
		operacion1 = unlam.registrarComision(comi);
		operacion2 = unlam.registrarComision(comi1);

		assertTrue(operacion1);
		assertFalse(operacion2);

	}

	@Test
	public void queNoSePuedaGenerarComisionPorqueNoEstaRegistradaLaMateriaNiElCiclo() {
		Integer id_ciclolectivo = 1, id_comision = 999;
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Turno turno = Turno.TURNO_MAÑANA;
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		CicloLectivo ciclo1 = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo1,
				fechaInicioCicloLectivo1, fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Comision comi = new Comision(id_comision, turno, ciclo1, tw1);

		Universidad unlam = new Universidad();
		Boolean operacion1 = false;

		operacion1 = unlam.registrarComision(comi);

		assertFalse(operacion1);

	}

	@Test
	public void queSePuedaGenerarComisionPorqueEstaRegistradaLaMateriaYElCiclo() {
		Integer id_ciclolectivo = 1, id_comision = 999;
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Turno turno = Turno.TURNO_MAÑANA;
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		CicloLectivo ciclo1 = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo1,
				fechaInicioCicloLectivo1, fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Comision comi = new Comision(id_comision, turno, ciclo1, tw1);

		Universidad unlam = new Universidad();
		Boolean operacion1 = false;
		unlam.registrarCicloLectivo(ciclo1);
		unlam.registrarMaterias(tw1);
		operacion1 = unlam.registrarComision(comi);

		assertTrue(operacion1);

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
		Integer id_cicloLectivo = 1;
		Integer id_cicloLectivo1 = 2;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Universidad unlam = new Universidad();
		Boolean operacion = false;
		Boolean operacion1 = false;
		CicloLectivo ciclo = new CicloLectivo(id_cicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		CicloLectivo ciclo2 = new CicloLectivo(id_cicloLectivo1, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
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
		AsignacionComisionProfe asignacionProfe = new AsignacionComisionProfe(codigoComision, dniProfesor);
		AsignacionComisionAlumno asignacionAlumno = new AsignacionComisionAlumno(codigoComision, dniAlumno);
		Comision comision = new Comision(codigoComision, dia, turno, ciclo, tw1, aula, asignacionAlumno,
				asignacionProfe);
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
		Nota parcialError = new Nota(2.0, TipoNota.PARCIAL_UNO);
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

		Boolean operacion = unlam.inscribirAlumnoComisionSiEstaDentroDeLasFechasInscripcion(dniAlumno, codigoComision,
				idComision,fechaInscripto);

		assertFalse(operacion);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaElCupoLLeno() {
		Integer codigoMateria1 = 2626;
		Integer dniAlumno = 412421;
		Integer codigoCurso = 1;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Integer numero = 266;
		Integer capacidadMax = 50;

		Aula aula = new Aula(numero, 49, capacidadMax);

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		CicloLectivo ciclo = new CicloLectivo(1, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
		Comision comision = new Comision(1, ciclo, pb2);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Curso curso = new Curso(codigoCurso);

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarCurso(curso);
		unlam.registrarCicloLectivo(ciclo);
		unlam.asignarComisionAUnCurso(codigoCurso, comision);
		unlam.asignarAulaACurso(codigoCurso, aula);

		Boolean operacion = unlam.inscribirAlumnoCurso(codigoCurso, dniAlumno, numero);

		assertFalse(operacion);

	}

	@Test
	public void queNoPuedaInscribirseAUnCursoPorqueSeSuperponeConOtroCursoYSusHorarios() {
		Alumno alumno = new Alumno(1234, "f", "g");
		Integer codigoMateria1 = 2500, codigoCurso = 1, codigoComision = 2626;
		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pb1 = new Materia("Pb1", 2300);

		Comision comision = new Comision(codigoComision, pb2, Dia.JUEVES, Turno.TURNO_MAÑANA);
		Curso curso = new Curso(codigoCurso, comision);
		Comision comision2 = new Comision(5, pb2, Dia.JUEVES, Turno.TURNO_MAÑANA);
		Curso inscribirse = new Curso(5, comision2);

		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pb1);
		unlam.registrarCurso(curso);
		unlam.inscribirAlumnoCurso(codigoCurso, 1234);

		Boolean operacion = unlam.inscribirAlumnoCurso(1234, codigoCurso, inscribirse);

		assertFalse(operacion);
	}

	@Test
	public void queSePuedaInscribirAUnCursoPorqueNoSeSuperponeConOtroCursoYSusHorarios() {
		Alumno alumno = new Alumno(1234, "f", "g");
		Integer codigoMateria1 = 2500, codigoCurso = 1, codigoComision = 2626;
		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pb1 = new Materia("Pb1", 2300);

		Comision comision = new Comision(codigoComision, pb2, Dia.JUEVES, Turno.TURNO_MAÑANA);
		Curso curso = new Curso(codigoCurso, comision);
		Comision comision2 = new Comision(5, pb2, Dia.MARTES, Turno.TURNO_MAÑANA);
		Curso inscribirse = new Curso(5, comision2);

		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pb1);
		unlam.registrarCurso(curso);
		unlam.inscribirAlumnoCurso(codigoCurso, 1234);

		Boolean operacion = unlam.inscribirAlumnoCurso(1234, codigoCurso, inscribirse);
		AsignacionCursoAlumno asig = unlam.buscarAsignacionAlumnoCurso(5, 1234);

		assertNotNull(asig);
		assertTrue(operacion);
	}

}
