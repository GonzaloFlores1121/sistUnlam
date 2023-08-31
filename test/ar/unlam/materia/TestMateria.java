package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedeaCrearUnaMateria() {
		String nombre = "Pb2";
		Integer codigo=1;
		Materia materia = new Materia(nombre,codigo);
		
		assertEquals(codigo, materia.getCodigo_materia());
	}

}
