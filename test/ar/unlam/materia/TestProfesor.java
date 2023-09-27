package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSePuedaCrearUnProfesor() {
		Integer dni = 28701;
		String nombre = "Diego";
		String apellido = "Oliva";
		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);	
		
		Profesor nuevo=new Profesor(dni, nombre, apellido, nacimiento, inscripcion);
		
		assertNotNull(nuevo);
		assertEquals(dni, nuevo.getDni());
		}
	
	@Test
	public void queSePuedaCrearMasProfesorConDniDiferente() {
		Integer dni = 28701;
		Integer dni2 = 28702;
		String nombre = "Diego";
		String apellido = "Oliva";
		LocalDate nacimiento = LocalDate.of(2001, 7, 28);
		LocalDate inscripcion = LocalDate.of(2020, 2, 3);	
		
		Profesor nuevo=new Profesor(dni, nombre, apellido, nacimiento, inscripcion);
		Profesor nuevo2=new Profesor(dni2, nombre, apellido, nacimiento, inscripcion);
		
		assertNotNull(nuevo);
		assertNotNull(nuevo2);
		assertEquals(dni, nuevo.getDni());
		assertEquals(dni2, nuevo2.getDni());
		assertNotEquals(nuevo, nuevo2);
	}

}
