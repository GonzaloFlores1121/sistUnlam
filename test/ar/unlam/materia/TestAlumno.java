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
		Integer id=1;
		
		LocalDate nacimiento=LocalDate.of(2001, 7, 28);
		LocalDate inscripcion=LocalDate.of(2020, 2, 3);
		
		// ejecucion
		
		Alumno alumno = new Alumno(id,nombre, apellido,dni,nacimiento,inscripcion);
		
		// validacion
		
		assertNotNull(alumno);
	}
	
//	@Test
//	public void queSePuedaCrearMasAlumnos() {
//		
//		// Preparacion de datos
//		String nombre = "Diego";
//		String apellido = "Oliva";
//		Integer dni = 44444;
//		Integer id=1;
//		
//		LocalDate nacimiento=LocalDate.of(2001, 7, 28);
//		LocalDate inscripcion=LocalDate.of(2020, 2, 3);
//		
//		// ejecucion
//		
//		Alumno alumno = new Alumno(id,nombre, apellido,dni,nacimiento,inscripcion);
//		
//		// validacion
//		
//		assertNotNull(alumno);
//	}

}
