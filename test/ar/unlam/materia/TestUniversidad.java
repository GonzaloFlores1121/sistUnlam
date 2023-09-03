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

	@Test
	public void queSePuedaCrearCursada() {
		Integer dni = 1, codigo_materia = 1;
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", codigo_materia);
		Cursada cursada1 = new Cursada(alumno, pb2);
		boolean exito = false;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		exito = unlam.inscripcionCursada(cursada1);

		assertTrue(exito);

	}

	@Test
	public void queSePuedaEncontrarCursadasPorMateria() {
		Integer cod_materia = 1;
		Materia pb2 = new Materia("pb2", cod_materia);
		Alumno alumno = new Alumno(23121, "Flores", "Gonzalo");
		Alumno alumno1 = new Alumno(1222, "f", "g");
		Cursada cursada1 = new Cursada(alumno, pb2);
		Cursada cursada2 = new Cursada(alumno1, pb2);
		Universidad unlam = new Universidad();
		ArrayList<Cursada> actual = new ArrayList<>();
		Boolean cursada1Encontrada = false;
		Boolean cursada2Encontrada = false;
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno1);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		actual = unlam.buscarCursadasPorMateria(cod_materia);
		cursada1Encontrada = actual.contains(cursada1);
		cursada2Encontrada = actual.contains(cursada2);

		assertTrue(cursada1Encontrada);
		assertTrue(cursada2Encontrada);

	}

	@Test
	public void queSePuedaEncontrarAlumnoEnUnaCursadaPorDni() {
		Integer dni = 777, cod_materia = 1;

		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", cod_materia);
		Universidad unlam = new Universidad();
		Cursada cursada = new Cursada(alumno, pb2);
		Cursada cursadaAlumnoEncontrada = null;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada);
		cursadaAlumnoEncontrada = unlam.buscarAlumnoCursada(cod_materia, dni);

		assertNotNull(cursadaAlumnoEncontrada);
	}

	@Test
	public void queSePuedaCalificarAlumno() {
		Integer dni = 777, cod_materia = 1;
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", cod_materia);
		Double calificacion = 7.0;
		Cursada cursada = new Cursada(alumno, pb2);
		Cursada encontrada = null;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada);
		encontrada = unlam.buscarAlumnoCursada(cod_materia, dni);
		encontrada.calificar(calificacion);

		assertEquals(calificacion, encontrada.getNota().getValor());

	}

	@Test
	public void queSePuedaEncontrarCursadasDeUnAlumno() {
		Integer dni = 777;
		Alumno yo = new Alumno(dni, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", 1);
		Materia pw1 = new Materia("pw1", 2);
		Materia bdd1 = new Materia("bdd1", 3);
		Materia kcyo = new Materia("kcyo", 4);
		Universidad unlam = new Universidad();
		Cursada cursada1 = new Cursada(yo, pb2);
		Cursada cursada2 = new Cursada(yo, pw1);
		Cursada cursada3 = new Cursada(yo, bdd1);
		Cursada cursada4 = new Cursada(yo, kcyo);
		ArrayList<Cursada> cursada = new ArrayList<>();
		Boolean operacion1 = false;
		Boolean operacion2 = false;
		Boolean operacion3 = false;
		Boolean operacion4 = false;

		unlam.registrarAlumno(yo);
		unlam.registrarMaterias(kcyo);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(pw1);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		unlam.inscripcionCursada(cursada3);
		unlam.inscripcionCursada(cursada4);
		cursada = unlam.buscarCursadasDeUnAlumno(dni);
		operacion1 = cursada.contains(cursada1);
		operacion2 = cursada.contains(cursada2);
		operacion3 = cursada.contains(cursada3);
		operacion4 = cursada.contains(cursada4);

		assertTrue(operacion1);
		assertTrue(operacion2);
		assertTrue(operacion3);
		assertTrue(operacion4);

	}

	@Test
	public void queSePuedaObtenerPromedioCalificacionesDeUnaCursada() {
		Integer cod_materia = 1;
		Materia pb2 = new Materia("pb2", cod_materia);
		Alumno alumno = new Alumno(2143, "Flores", "Gonzalo");
		Alumno alumno1 = new Alumno(1234, "f", "g");
		Alumno alumno2 = new Alumno(6666, "p", "v");
		Alumno alumno3 = new Alumno(777, "m", "m");
		Nota n1 = new Nota(6.0);
		Nota n2 = new Nota(4.0);
		Nota n3 = new Nota(10.0);
		Nota n4 = new Nota(9.0);
		Cursada cursada1 = new Cursada(alumno, pb2, n1);
		Cursada cursada2 = new Cursada(alumno1, pb2, n2);
		Cursada cursada3 = new Cursada(alumno2, pb2, n3);
		Cursada cursada4 = new Cursada(alumno3, pb2, n4);
		Universidad unlam = new Universidad();
		Double promedio_calificaciones_cursada_esperado = 7.25;
		Double promedio_calificaciones_cursada;

		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno1);
		unlam.registrarAlumno(alumno2);
		unlam.registrarAlumno(alumno3);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		unlam.inscripcionCursada(cursada3);
		unlam.inscripcionCursada(cursada4);

		promedio_calificaciones_cursada = unlam.obtenerPromedioCalificacionesDeUnaCursada(cod_materia);

		assertEquals(promedio_calificaciones_cursada_esperado, promedio_calificaciones_cursada);
	}

	@Test
	public void queSeObtengaUnaListaDeMateriasAprobadasDeUnAlumno() {
		Integer dni = 777;
		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Double nota1 = 7.0;
		Double nota2 = 2.0;
		Double nota3 = 10.0;
		Double nota4 = 4.0;
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 1);
		Materia pw1 = new Materia("pw1", 2);
		Materia bdd1 = new Materia("bdd1", 3);
		Materia kcyo = new Materia("kcyo", 4);
		Cursada cursada1 = new Cursada(alumno, pb2);
		Cursada cursada2 = new Cursada(alumno, pw1);
		Cursada cursada3 = new Cursada(alumno, bdd1);
		Cursada cursada4 = new Cursada(alumno, kcyo);
		ArrayList<Materia> materiasLista = new ArrayList<>();

		Boolean operacion1 = false;
		Boolean operacion2 = false;
		Boolean operacion3 = false;
		Boolean operacion4 = false;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(kcyo);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		unlam.inscripcionCursada(cursada3);
		unlam.inscripcionCursada(cursada4);
		cursada1.calificar(nota1);
		cursada2.calificar(nota2);
		cursada3.calificar(nota3);
		cursada4.calificar(nota4);

		materiasLista = unlam.obtengaUnaListaDeMateriasAprobadasDeUnAlumno(dni);
		operacion1 = materiasLista.contains(pb2);
		operacion2 = materiasLista.contains(pw1);
		operacion3 = materiasLista.contains(bdd1);
		operacion4 = materiasLista.contains(kcyo);

		assertTrue(operacion1);
		assertTrue(operacion3);
		assertFalse(operacion2);
		assertFalse(operacion4);

	}

	@Test
	public void queSePuedaInscribirSiTieneLasCorrelativasAprobadas() {
		Integer dni = 777;
		Alumno alumno = new Alumno(dni, "Flores", "Gonzalo");
		Universidad unlam = new Universidad();
		Materia pb2 = new Materia("pb2", 2623);
		Materia pw1 = new Materia("pw1", 2624);
		Materia bdd1 = new Materia("bdd1", 2625);
		Integer materias_correlativas[] = { 2623, 2624, 2625 };
		Materia tw1 = new Materia(2631, "tw1", materias_correlativas);
		Cursada cursada1 = new Cursada(alumno, pb2);
		Cursada cursada2 = new Cursada(alumno, pw1);
		Cursada cursada3 = new Cursada(alumno, bdd1);
		boolean exitoso = false;

		Double nota1 = 7.0;
		Double nota2 = 8.0;
		Double nota3 = 10.0;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.registrarMaterias(pw1);
		unlam.registrarMaterias(bdd1);
		unlam.registrarMaterias(tw1);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		unlam.inscripcionCursada(cursada3);
		cursada1.calificar(nota1);
		cursada2.calificar(nota2);
		cursada3.calificar(nota3);

		exitoso = unlam.inscripcionCursadaSiTieneLasCorrelativasAprobadas(dni, tw1);
		Cursada encontrada = unlam.buscarAlumnoCursada(2631, dni);

		assertTrue(exitoso);
		assertNotNull(encontrada);

	}
}
