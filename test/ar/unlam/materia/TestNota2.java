package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota2 {

	@Test
	public void queALCrearUnaNotaSuValordeNotaPorDefectoSeaCeroYTipoNull() {

		Nota nota = new Nota();

		Double ve = 0.0;
		Double vo = nota.getValor();

		assertEquals(ve, vo);
		assertNull(nota.getTipoDeNota());

	}


//	@Test
//	public void queAlAsignarUnValorEntreUnoYDiezSeLeAsigneELValorALaNotaYSeValideConParcialesYNoRecuperatorios() {
//
//		Nota nota = new Nota();
//
//		Double valor = 7.0;
//		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
//		nota.registrarNota(valor, parcial);;
//
//		Double ve = 7.0;
//		Double vo = nota.getValor();
//		Boolean prueba= parcial.equals(nota.getTipoDeNota());
//		
//		assertEquals(ve, vo);
//		assertEquals(parcial, nota.getTipoDeNota());		
//		assertTrue(prueba);
//	}
	
//	@Test
//	public void queAlAsignarUnValorQueNoEsteEntreUnoYDiezNoSeLeAsigneELValorALaNotaYNiValideConClases() {
//		
//		Nota nota = new Nota();
//		
//		Double valor = 11.0;
//		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
//		nota.registrarNota(valor, parcial);;
//		
//		Double ve = 0.0;
//		Double vo = nota.getValor();
//		
//		assertEquals(ve, vo);
//		assertNotNull(nota.getTipoDeNota());
//		assertNull(nota.getTipoDeNota());
//	}

//	@Test
//	public void queAlAsignarUnValorQueNoEsteEntreUnoYDiezNoSeLeAsigneELValorALaNotaNiLaClase() {
//
//		Nota nota = new Nota(); // valor =0
//
//		Double valor = 11.0;
//
//		nota.asignarValor(valor); // valor = 0
//
//		Double ve = 0.0;
//		Double vo = nota.getValor();
//
//		assertEquals(ve, vo);
//
//	}
	 
//	@Test
//	public void queAlAsignarUnValorQueNoEsteEntreUnoYDiezNoSeLeAsigneELValorALaNotaNiElTipo() {
//		
//		Nota nota = new Nota(); // valor =0
//		
//		Double valor = 11.0;
//		ClaseDeNota parcial=ClaseDeNota.values()[1];
//		nota.asignarValor(valor); // valor = 0
//		nota.asignarTipoDeNota(parcial);
//		Double ve = 0.0;
//		Double vo = nota.getValor();
//		
//		assertEquals(ve, vo);
//		
//	}
	
	@Test
	public void queTengaUnaNotaValidaYUnTipoDeParcialValido() {
		
		ClaseDeNota primerParcial= ClaseDeNota.PRIMER_PARCIAL;
		
		Nota nota = new Nota(); // valor =0
		Double valor = 7.0;
		nota.registrarNota(valor, primerParcial);
		
		Double vo = nota.getValor();
		ClaseDeNota tipo= nota.getTipoDeNota();
		
		assertEquals(valor, vo);
		assertEquals(primerParcial, tipo);
		
		
	}

}
