package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {

		// Preparacion de datos
		String nombre = "Diego";
		String apellido = "Oliva";
		Integer dni = 44444;

		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);

		// ejecucion

		Alumno alumno = new Alumno(dni, nombre, apellido, nacimiento, inscripcion);

		// validacion

		assertNotNull(alumno);
		assertEquals(dni, alumno.getDni());
	}
	
	@Test
	public void queSePuedaCrearMasAlumnosConDiferenteDNI() {
		
		// Preparacion de datos
		String nombre = "Diego";
		String apellido = "Oliva";
		Integer dni = 44444;
		Integer dni2 = 33333;
		
		LocalDate nacimiento=LocalDate.of(2001, 7, 28);
		LocalDate inscripcion=LocalDate.of(2020, 2, 3);
		
		// ejecucion
		
		Alumno alumno = new Alumno(dni, nombre, apellido, nacimiento, inscripcion);
		Alumno alumno2 = new Alumno(dni2, nombre, apellido, nacimiento, inscripcion);
		
		// validacion
		
		assertNotNull(alumno);
		assertEquals(dni, alumno.getDni());

		assertNotNull(alumno2);
		assertEquals(dni2, alumno2.getDni());
		
		assertNotEquals(alumno, alumno2);

	}
}
