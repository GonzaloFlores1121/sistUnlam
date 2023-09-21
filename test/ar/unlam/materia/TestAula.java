package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSePuedaCrearUnaAula() {
	//Preparacion
	Integer numeroDeAula=1;
	Integer cantidadMaxDeAlumnos=30;
	Aula uno=new Aula(numeroDeAula, cantidadMaxDeAlumnos);
	
	//Ejecucion
	Boolean resultado=uno!=null;
	//Prueba
	
	assertTrue(resultado);
	assertNotNull(uno);
	}
	
	@Test
	public void queSePuedaCrearMasAulasDiferentes() {
		//Preparacion
		Integer numeroDeAula=1;
		Integer numeroDeAula2=2;
		Integer cantidadMaxDeAlumnos=30;
		Aula uno=new Aula(numeroDeAula, cantidadMaxDeAlumnos);
		Aula dos=new Aula(numeroDeAula2, cantidadMaxDeAlumnos);
		
		//Ejecucion
		Boolean resultado=uno!=null;
		Boolean resultado2=dos!=null;
		//Prueba
		
		assertTrue(resultado);
		assertTrue(resultado2);
		assertNotNull(uno);
		assertNotNull(dos); 
		
		assertNotEquals(uno, dos);
	}
}
