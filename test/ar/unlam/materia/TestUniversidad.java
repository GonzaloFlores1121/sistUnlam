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
	public void queSePuedaRegistrarUnCursoYEncontrarloPorCodigo() {
		Integer numero = 999, capacidadMax = 50, dniAlumno = 777, dniProfesor = 8888, codigo_curso = 1,
				id_ciclolectivo = 1, idComision = 1;

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Turno turno = Turno.TURNO_MAÑANA;

		Materia tw1 = new Materia("TALLER WEB1", 2300);
		Integer capacidadActual = 2;
		Aula aula = new Aula(numero, capacidadActual, capacidadMax);
		CicloLectivo ciclo = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Comision comision = new Comision(idComision, turno, ciclo, tw1);
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Profesor profe = new Profesor(dniProfesor, "F", "G", 0.0);
		AsignacionCursoProfe asignacionProfe = new AsignacionCursoProfe(codigo_curso, dniProfesor);
		AsignacionCursoAlumno asignacionAlumno = new AsignacionCursoAlumno(codigo_curso, dniAlumno);
		Curso curso = new Curso(codigo_curso, comision, aula, asignacionAlumno, asignacionProfe);
		Curso esperado = null;
		Universidad unlam = new Universidad();

		unlam.registrarAlumno(alm);
		unlam.registrarProfesor(profe);
		unlam.registrarCurso(curso);
		unlam.registrarAlumno(alm);
		unlam.registrarProfesor(profe);
		esperado = unlam.buscarCursoPorCodigo(codigo_curso);

		assertEquals(esperado, curso);

	}

	@Test
	public void queSePuedaAsignarComisionAUnCurso() {

		Universidad unlam = new Universidad();
		Integer codigoCurso = 1;

		Curso curso = new Curso(codigoCurso);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Turno turno = Turno.TURNO_MAÑANA;
		Integer idComision = 1;
		Integer id_ciclolectivo = 1;
		CicloLectivo ciclo = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		Comision comision = new Comision(idComision, turno, ciclo, tw1);
		Boolean operacion = false;

		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarMaterias(tw1);
		unlam.registrarCurso(curso);
		unlam.registrarComision(comision);
		operacion = unlam.asignarComisionAUnCurso(codigoCurso, comision);

		assertTrue(operacion);

	}

	@Test
	public void queSePuedaAsignarAulaAUnCurso() {
		Universidad unlam = new Universidad();
		Integer codigoCurso = 1;
		Curso curso = new Curso(codigoCurso);
		Integer numero = 416;
		Integer capacidadMax = 50;
		Integer capacidadACtual = 2;
		Aula aula = new Aula(numero, capacidadACtual, capacidadMax);
		unlam.registrarCurso(curso);
		unlam.registrarAula(aula);
		unlam.asignarAulaACurso(codigoCurso, aula);

		assertNotNull(curso);
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
		Integer dniAlumno = 412421, codigoCurso = 1;
		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Curso curso = new Curso(codigoCurso);

		unlam.registrarAlumno(alm);
		unlam.registrarCurso(curso);

		Boolean exitoso = unlam.inscribirAlumnoCurso(codigoCurso, dniAlumno);

		assertTrue(exitoso);
	}

	@Test
	public void queSePuedaInscribirAlumnoAUnCursoSiTieneLasCorrelativasAprobadas() {
		Integer codigoMateria = 2300;
		Integer codigoMateria1 = 2626;
		Integer codigoMateria2 = 2500;
		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;
		Integer codigoCurso = 1, codigoCurso1 = 2, codigoCurso2 = 3, codigoCurso3 = 4;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pw1 = new Materia("Pw1", codigoMateria2);
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);

		Integer idComision1 = 1;
		Integer idComision2 = 2;
		Integer idComision3 = 3;
		Integer idComision4 = 4;

		Comision comision = new Comision(idComision1, pb2);
		Comision comision1 = new Comision(idComision2, pw1);
		Comision comision2 = new Comision(idComision3, bdd1);
		Comision comision3 = new Comision(idComision4, tw1);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Curso curso = new Curso(codigoCurso, comision);
		Curso curso1 = new Curso(codigoCurso1, comision1);
		Curso curso2 = new Curso(codigoCurso2, comision2);
		Double nota1 = 5.0;
		Double nota2 = 7.0;

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(tw1);
		unlam.registrarCurso(curso);
		unlam.registrarCurso(curso1);
		unlam.registrarCurso(curso2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
		unlam.inscribirAlumnoCurso(codigoCurso, dniAlumno);
		unlam.inscribirAlumnoCurso(codigoCurso1, dniAlumno);
		unlam.inscribirAlumnoCurso(codigoCurso2, dniAlumno);

		unlam.evaluarAlumnoCurso(codigoCurso, dniAlumno, nota1, nota2);
		unlam.evaluarAlumnoCurso(codigoCurso1, dniAlumno, nota1, nota2);
		unlam.evaluarAlumnoCurso(codigoCurso2, dniAlumno, nota1, nota2);

		Boolean operacion = unlam.inscribirAlumnoCurso(dniAlumno, codigoMateria, comision3,
				codigoCurso3);

		AsignacionCursoAlumno asign=unlam.buscarAsignacionAlumnoCurso(codigoCurso3, dniAlumno);

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
		Integer codigoCurso = 1, codigoCurso1 = 2, codigoCurso2 = 3, codigoCurso3 = 4;

		Materia pb2 = new Materia("Pb2", codigoMateria1);
		Materia pw1 = new Materia("Pw1", codigoMateria2);
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
		Integer idComision1 = 1;
		Integer idComision2 = 2;
		Integer idComision3 = 3;
		Integer idComision4 = 4;

		Comision comision = new Comision(idComision1, pb2);
		Comision comision1 = new Comision(idComision2, pw1);
		Comision comision2 = new Comision(idComision3, bdd1);
		Comision comision3 = new Comision(idComision4, tw1);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Curso curso = new Curso(codigoCurso, comision);
		Curso curso1 = new Curso(codigoCurso1, comision1);
		Curso curso2 = new Curso(codigoCurso2, comision2);
		Double nota1 = 5.0;
		Double nota2 = 7.0;
		Double notaerror = 2.0;

		unlam.registrarAlumno(alm);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(tw1);
		unlam.registrarCurso(curso);
		unlam.registrarCurso(curso1);
		unlam.registrarCurso(curso2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
		unlam.inscribirAlumnoCurso(codigoCurso, dniAlumno);
		unlam.inscribirAlumnoCurso(codigoCurso1, dniAlumno);
		unlam.inscribirAlumnoCurso(codigoCurso2, dniAlumno);

		unlam.evaluarAlumnoCurso(codigoCurso, dniAlumno, nota1, nota2);
		unlam.evaluarAlumnoCurso(codigoCurso1, dniAlumno, nota1, nota2);
		unlam.evaluarAlumnoCurso(codigoCurso2, dniAlumno, nota1, notaerror);

		Boolean operacion = unlam.inscribirAlumnoCurso(dniAlumno, codigoMateria, comision3,
				codigoCurso3);

		assertFalse(operacion);

	}

	@Test
	public void queNoSePuedaInscribirAlumnoAUnCursoSiEstaFueraDeLaFechaDeInscripcion() {

		Integer codigoMateria3 = 2600;
		Integer dniAlumno = 412421;
		Integer codigoCurso2 = 3;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
		LocalDate fechaInscripto = LocalDate.of(2024, 8, 1);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Integer id_ciclolectivo = 1;
		CicloLectivo ciclo = new CicloLectivo(id_ciclolectivo, fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		Turno turno = Turno.TURNO_MAÑANA;
		Integer idComision3 = 3;
		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
		Comision comision2 = new Comision(idComision3, turno, ciclo, bdd1);

		Universidad unlam = new Universidad();
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Curso curso2 = new Curso(codigoCurso2, comision2);

		unlam.registrarAlumno(alm);

		unlam.registrarMaterias(bdd1);

		unlam.registrarCurso(curso2);

		Boolean operacion = unlam.inscribirAlumnoCurso(codigoCurso2, dniAlumno, comision2, fechaInscripto);

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
		
		
		Boolean operacion=unlam.inscribirAlumnoCurso(1234,codigoCurso,inscribirse);
		
		
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
		
		
		Boolean operacion=unlam.inscribirAlumnoCurso(1234,codigoCurso,inscribirse);
		AsignacionCursoAlumno asig=unlam.buscarAsignacionAlumnoCurso(5,1234);
		
		assertNotNull(asig);
		assertTrue(operacion);
	}

}
