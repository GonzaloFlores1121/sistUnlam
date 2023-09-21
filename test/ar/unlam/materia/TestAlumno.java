package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {

//	@Test
//	public void queSePuedaCrearUnAlumno() {
//
//		// Preparacion de datos
//		String nombre = "andres";
//		String apellido = "Gomez";
//		Integer dni = 44444;
//
//		// ejecucion
//
//		Alumno alumno = new Alumno(dni, apellido, nombre);
//
//		// validacion
//
//		assertNotNull(alumno);
//
//		assertEquals(nombre, alumno.getNombre());
//
//	}

	@Test
	public void queSePuedaCrearUnAlumno() {

		// Preparacion de datos
		String nombre = "Diego";
		String apellido = "Oliva";
		Integer dni = 44444;
		Integer id = 1;

		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);

		// ejecucion

		Alumno alumno = new Alumno(id, nombre, apellido, dni, nacimiento, inscripcion);

		// validacion

		assertNotNull(alumno);
	}

	@Test
	public void queSePuedaCrearMasAlumnosConDiferenteDNI() {

		// Preparacion de datos
		String nombre = "Diego";
		String apellido = "Oliva";
		Integer dni = 444;
		Integer dni2 = 333;
		Integer id = 1;
		Integer id2 = 2;

		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);

		// ejecucion

		Alumno alumno = new Alumno(id, nombre, apellido, dni, nacimiento, inscripcion);
		Alumno alumno2 = new Alumno(id2, nombre, apellido, dni2, nacimiento, inscripcion);

		// validacion

		assertNotEquals(alumno, alumno2);
	}

	@Test
	public void queNoSeAcepteDniIgualesEnDiferentesAlumnos() {

		// Preparacion de datos
		String nombre = "Diego";
		String apellido = "Oliva";
		Integer dni = 444;
		Integer dni2 = 444;
		Integer id = 1;
		Integer id2 = 2;

		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);

		// ejecucion

		Alumno alumno = new Alumno(id, nombre, apellido, dni, nacimiento, inscripcion);
		Alumno alumno2 = new Alumno(id, nombre, apellido, dni2, nacimiento, inscripcion);

		// validacion

		assertEquals(alumno,alumno2);
	}

}
