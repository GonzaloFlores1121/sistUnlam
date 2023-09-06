package ar.unlam.materia;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaIngresarAlumno() {
		Alumno alumno = new Alumno(12341, "Flores", "Gonzalo");
		Universidad unlam = new Universidad();
		boolean exitoso = false;

		exitoso = unlam.registrarAlumno(alumno);

		assertTrue(exitoso);
	}

	@Test
	public void queSePuedaIngresarMaterias() {
		Materia pb2 = new Materia("pb2", 1);
		Universidad unlam = new Universidad();
		boolean exitoso = false;

		exitoso = unlam.registrarMaterias(pb2);

		assertTrue(exitoso);

	}

	@Test
	public void queEncuentreAlumnoEnUnlamPorDni() {
		Integer dni = 444444;
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Alumno alumnoEncontrado = null;
		unlam.registrarAlumno(alumno);

		alumnoEncontrado = unlam.buscarAlumnoRegistrado(dni);

		assertNotNull(alumnoEncontrado);
	}

	@Test
	public void queSeEncuentreMateriaEnUnlamPorCodigo() {
		Integer codigo_materia = 1;
		Materia pb2 = new Materia("pb2", codigo_materia);
		Materia m_encontrada = null;
		Universidad unlam = new Universidad();

		unlam.registrarMaterias(pb2);
		m_encontrada = unlam.buscarMateria(codigo_materia);

		assertNotNull(m_encontrada);

	}

	
}
