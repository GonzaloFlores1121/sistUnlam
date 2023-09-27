package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSePuedaCrearUnaMateria() {
		String nombre = "Pb2";
		Integer codigo=1;
		Materia materia = new Materia(nombre,codigo);
		
		assertEquals(codigo, materia.getCodigo_materia());
	}
	
	@Test
	public void queSeAlCrearseNoTengaCorrelativas() {
		String nombre = "Pb2";
		Integer codigo=1;
		Materia materia = new Materia(nombre,codigo);
		
		assertTrue(materia.getCodigoCorrelativa().isEmpty());
	}
	
	@Test
	public void queSePuedaCrearMasMateria() {
		String nombre = "Pb1";
		Integer codigo=1;
		String nombre2 = "Pb2";
		Integer codigo2=2;
		Materia materia = new Materia(nombre,codigo);
		Materia materia2 = new Materia(nombre2,codigo2);
		
		assertEquals(codigo, materia.getCodigo_materia());
		assertEquals(codigo2, materia2.getCodigo_materia());

		assertNotEquals(materia,materia2);
	}
	
	@Test
	public void queDosMateriasNoTenganElMismoId() {
		String nombre = "Pb1";
		Integer codigo=1;
		String nombre2 = "Pb2";
		Integer codigo2=2;
		Materia materia = new Materia(nombre,codigo);
		Materia materia2 = new Materia(nombre2,codigo2);
		
		Integer codigoDeMateria=materia.getCodigo_materia();
		Integer codigoDeMateria2=materia2.getCodigo_materia();
		
		Boolean resultado=codigoDeMateria!=codigoDeMateria2;
		assertTrue(resultado);
		assertNotEquals(materia,materia2);
	}
	
	@Test
	public void queSePuedaAgregarUnaCorrelativa() {
		String nombre = "Pb1";
		Integer codigo=1;
		String nombre2 = "Pb2";
		Integer codigo2=2;
		Materia materia = new Materia(nombre,codigo);
		Materia materia2 = new Materia(nombre2,codigo2);
		
		materia.asignarCorrelativa(materia2.getCodigo_materia());
		
		boolean resultado=materia.getCodigoCorrelativa().isEmpty();
		assertFalse(resultado);
		
		Integer ve=1;
		Integer vo=materia.getCodigoCorrelativa().size();
		
		assertEquals(ve, vo);
		
		boolean resultadoBusqueda= materia.buscarCorrelativaDiego(materia2.getCodigo_materia());
		assertTrue(resultadoBusqueda);
	}
	
	@Test
	public void queSePuedaAgregarMasDeUnaCorrelativa() {
		String nombre = "Pb1";
		Integer codigo=1;
		String nombre2 = "Pb2";
		Integer codigo2=2;
		String nombre3 = "Taller web";
		Integer codigo3=3;
		Materia materia = new Materia(nombre,codigo);
		Materia materia2 = new Materia(nombre2,codigo2);
		Materia materia3 = new Materia(nombre3,codigo3);
		
		materia3.asignarCorrelativa(materia.getCodigo_materia());
		materia3.asignarCorrelativa(materia2.getCodigo_materia());
		
		boolean resultado=materia3.getCodigoCorrelativa().isEmpty();
		assertFalse(resultado);
		
		Integer ve=2;
		Integer vo=materia3.getCodigoCorrelativa().size();
		
		assertEquals(ve, vo);
		
		boolean resultadoBusqueda= materia3.buscarCorrelativaDiego(materia.getCodigo_materia());
		assertTrue(resultadoBusqueda);
		boolean resultadoBusqueda2= materia3.buscarCorrelativaDiego(materia2.getCodigo_materia());
		assertTrue(resultadoBusqueda2);
	}
	
	@Test
	public void queNoSePuedaAgregarCorrelativasConElMismoId() {
		String nombre = "Pb1";
		Integer codigo=1;
		String nombre2 = "Pb2";
//		Integer codigo2=2;
		String nombre3 = "Taller web";
		Integer codigo3=3;
		Materia materia = new Materia(nombre,codigo);
		Materia materia2 = new Materia(nombre2,codigo);
		Materia materia3 = new Materia(nombre3,codigo3);
		
		materia3.asignarCorrelativa(materia.getCodigo_materia());
		materia3.asignarCorrelativa(materia2.getCodigo_materia());
		
		boolean resultado=materia3.getCodigoCorrelativa().isEmpty();
		assertFalse(resultado);
		
		Integer ve=1;
		Integer vo=materia3.cantidadCorrelativas();
		
		assertEquals(ve, vo);
		
		boolean resultadoBusqueda= materia3.buscarCorrelativaDiego(materia.getCodigo_materia());
		assertTrue(resultadoBusqueda);
	}
}
