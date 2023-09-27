package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {
	

	@Test
	public void queALCrearUnaNotaSuValordeNotaPorDefectoSeaCeroYTipoNull() {

		Nota nota = new Nota();

		Double ve = 0.0;
		Double vo = nota.getValor();

		assertEquals(ve, vo);
		assertNull(nota.getTipoDeNota());
	}

	@Test
	public void queSePuedaAsignarUnaNotaDelUnoAlDiezYElTipo() {
		
		Nota nota = new Nota();
		
		Double valor = 7.0;
		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
		nota.registrarNota(valor, parcial);;
		
		Double ve = 7.0;
		Double vo = nota.getValor();
		Boolean prueba= parcial.equals(nota.getTipoDeNota());
		
		assertEquals(ve, vo);
		assertEquals(parcial, nota.getTipoDeNota());		
		assertTrue(prueba);
	}
	
	@Test
	public void queAlAsignarUnValorFueraDeEntreUnoYDiezNoSeLeAsigneELValorALaNotaNiValideConParciales() {

		Nota nota = new Nota();

		Double valor = 11.0;
		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota nada=null;		
		nota.registrarNota(valor, parcial);;

		Double ve = 0.0;
		Double vo = nota.getValor();//0
		
		assertEquals(ve, vo);
		assertEquals(nada, nota.getTipoDeNota());
		assertNotEquals(parcial, nota.getTipoDeNota());		
	}
	
	@Test
	public void queAlAsignarLaNotaPorPrimeraVezNoSePuedaTomarOtrosValoresDeClasesQueNoSeaParcialUnoYDos() {
		
		Nota nota = new Nota();
		
		Double valor = 7.0;
		ClaseDeNota parcial=ClaseDeNota.RECUPERATORIO_1;
		nota.registrarNota(valor, parcial);;
		
		Double ve = 0.0;
		Double vo = nota.getValor();//0
		ClaseDeNota voNota=null;		
		
		assertEquals(ve, vo);
		assertEquals(voNota, nota.getTipoDeNota());
		assertNotEquals(parcial, nota.getTipoDeNota());		
	}
	
	@Test
	public void queSePuedaRecuperarUnaNota() {
		
		Nota nota = new Nota();
		
		Double valor = 5.0;
		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
		nota.registrarNota(valor, parcial);
		
		Double notaAntesDelRecuperatorio=nota.getValor();
		ClaseDeNota TipoDeNotaAntesDelRecuperatorio=nota.getTipoDeNota();
		
		assertEquals(valor, notaAntesDelRecuperatorio);
		assertEquals(parcial, TipoDeNotaAntesDelRecuperatorio);
		
		Double notaRecuperatorio=7.0;
		nota.recuperarNota(notaRecuperatorio);
		ClaseDeNota recuperatorio=ClaseDeNota.RECUPERATORIO_1;
		
		Double notaDespuesDelRecuperatorio=nota.getValor();
		ClaseDeNota TipoDeNotaDespuesDelRecuperatorio=nota.getTipoDeNota();
		
		assertEquals(notaRecuperatorio, notaDespuesDelRecuperatorio);
		assertEquals(recuperatorio, TipoDeNotaDespuesDelRecuperatorio);
	}
	
	@Test
	public void queNoSePuedaRecuperarUnaNotaSiLaClaseDeNotaNoEsNiParcialUnoODos() {
		
		Nota nota = new Nota();
		
		Double valor = 5.0;
//		ClaseDeNota parcial=null;
		ClaseDeNota parcial=ClaseDeNota.RECUPERATORIO_1;
		nota.registrarNota(valor, parcial);
		
		Double ve=0.0;
		ClaseDeNota TipoDeNotaEsperada=null;
		
		assertEquals(ve, nota.getValor());
		assertEquals(TipoDeNotaEsperada, nota.getTipoDeNota());
		
		Double notaRecuperatorio=7.0;
		nota.recuperarNota(notaRecuperatorio);
		ClaseDeNota recuperatorio=null;
		
		Double notaDespuesDelRecuperatorio=nota.getValor();
		ClaseDeNota TipoDeNotaDespuesDelRecuperatorio=nota.getTipoDeNota();
		
		assertEquals(ve, notaDespuesDelRecuperatorio);
		assertEquals(recuperatorio, TipoDeNotaDespuesDelRecuperatorio);
	}
	
	@Test
	public void queNoSePuedaRecuperarUnaNotaSiLaNuevaNotaEsMayorADiezOMenosAUno() {
		
		Nota nota = new Nota();
		
		Double valor = 11.0;
//		ClaseDeNota parcial=null;
		ClaseDeNota parcial=ClaseDeNota.PRIMER_PARCIAL;
		nota.registrarNota(valor, parcial);
		
		Double ve=0.0;
		ClaseDeNota TipoDeNotaEsperada=null;
		
		assertEquals(ve, nota.getValor());
		assertEquals(TipoDeNotaEsperada, nota.getTipoDeNota());
		
		Double notaRecuperatorio=7.0;
		nota.recuperarNota(notaRecuperatorio);
		ClaseDeNota recuperatorio=null;
		
		Double notaDespuesDelRecuperatorio=nota.getValor();
		ClaseDeNota TipoDeNotaDespuesDelRecuperatorio=nota.getTipoDeNota();
		
		assertEquals(ve, notaDespuesDelRecuperatorio);
		assertEquals(recuperatorio, TipoDeNotaDespuesDelRecuperatorio);
	}
	


}
