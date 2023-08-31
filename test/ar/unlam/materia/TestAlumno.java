package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSePuedaCrearUnAlumno() {

		// Preparacion de datos
		String nombre = "andres";
		String apellido = "Gomez";
		Integer dni = 44444;
		Integer codigo = 1;
		// ejecucion

		Alumno alumno = new Alumno(codigo, dni, apellido, nombre);

		// validacion

		assertNotNull(alumno);

		assertEquals(nombre, alumno.getNombre());

	}
	

}
