package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCursada {

	@Test
	public void queSePuedaCrearUnaCursada() {

		Alumno alumno = new Alumno(22, "Juan", "perez");
		Materia materia = new Materia("pb2", 2);
		Nota nota = new Nota();
		Cursada cursada = new Cursada(alumno, materia, nota);

		assertNotNull(cursada);

		Cursada cursada1 = new Cursada(alumno, materia);

	}

	@Test
	public void queSePuedaAsiganarUnValorEntreUnoYDiezaUnaNotaDeUnaCursada() {

		Alumno alumno = new Alumno(22, "Juan", "perez");
		Materia materia = new Materia("pb2", 2);
		Nota nota = new Nota();
		Cursada cursada = new Cursada(alumno, materia, nota);

		Double valor = 7.0;
		cursada.calificar(valor);

		Double vo = cursada.getNota().getValor();
		assertEquals(valor, vo);

	}
}
