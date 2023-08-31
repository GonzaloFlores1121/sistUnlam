package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void queALCrearUnaNotaSuValordeNotaPorDefectoSeaCero() {

		Nota nota = new Nota();

		Double ve = 0.0;
		Double vo = nota.getValor();

		assertEquals(ve, vo);

	}

	@Test
	public void queAlAsignarUnValorEntreUnoYDiezSeLeAsigneELValorALaNota() {

		Nota nota = new Nota();

		Double valor = 7.0;
		nota.asignarValor(valor);

		Double ve = 7.0;
		Double vo = nota.getValor();
		assertEquals(ve, vo);

	}

	@Test
	public void queAlAsignarUnValorQueNoEsteEntreUnoYDiezNoSeLeAsigneELValorALaNota() {

		Nota nota = new Nota(); // valor =0

		Double valor = 11.0;

		nota.asignarValor(valor); // valor = 0

		Double ve = 0.0;
		Double vo = nota.getValor();

		assertEquals(ve, vo);

	}

}
