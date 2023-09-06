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
		Integer numero = 999, capacidadMax = 50, dniAlumno = 777, dniProfesor = 8888, codigo_curso = 1;

		LocalDate fechaDeInicio = LocalDate.of(2023, 4, 14);
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Dia dia = Dia.JUEVES;
		Turno turno = Turno.TURNO_MAÑANA;
		Horario horario = new Horario(dia, turno);
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		Aula aula = new Aula(numero, capacidadMax);
		CicloLectivo ciclo = new CicloLectivo(fechaDeInicio, cuatri);
		Alumno alm = new Alumno(dniAlumno, "F", "G");
		Profesor profe = new Profesor(dniProfesor, "F", "G", 0.0);
		AsignacionCursoProfe asignacionProfe = new AsignacionCursoProfe(1,codigo_curso, dniProfesor);
		AsignacionCursoAlumno asignacionAlumno = new AsignacionCursoAlumno(1,codigo_curso, dniAlumno);
		Curso curso = new Curso(codigo_curso, tw1, aula, ciclo, horario, asignacionAlumno, asignacionProfe);
		Curso esperado = null;
		Universidad unlam = new Universidad();

		
		unlam.registrarAlumno(alm);
		unlam.registrarProfesor(profe);
		unlam.registrarCurso(curso);
		esperado = unlam.buscarCursoPorCodigo(codigo_curso);

		assertEquals(esperado, curso);

	}

}
