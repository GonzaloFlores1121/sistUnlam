package ar.unlam.materia;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaIngresarAlumno() {
		Alumno alumno = new Alumno(1, 12341, "Flores", "Gonzalo");
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
	public void queEncuentreAlumnoEnUnlam() {
		Integer codigo_alumno = 1;
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(codigo_alumno, 21311, "Flores", "Gonzalo");
		Alumno alumnoEncontrado = null;
		unlam.registrarAlumno(alumno);

		alumnoEncontrado = unlam.buscarAlumnoRegistrado(codigo_alumno);

		assertNotNull(alumnoEncontrado);
	}

	@Test
	public void queSeEncuentreMateriaEnUnlam() {
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
		Integer codigo_alumno = 1, codigo_materia = 1;
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(codigo_alumno, 12412, "Flores", "Gonzalo");
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
		Materia pb2 = new Materia("pb2", 1);
		Alumno alumno = new Alumno(1, 23121, "Flores", "Gonzalo");
		Alumno alumno1 = new Alumno(2, 1, "f", "g");
		Cursada cursada1 = new Cursada(alumno, pb2);
		Cursada cursada2 = new Cursada(alumno1, pb2);
		Universidad unlam = new Universidad();
		Cursada busqueda[] = new Cursada[2];
		Cursada actuales[] = new Cursada[2];
		actuales[0] = cursada1;
		actuales[1] = cursada2;
		Integer cod_materia = 1;

		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno1);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada1);
		unlam.inscripcionCursada(cursada2);
		busqueda = unlam.buscarCursadasPorMateria(cod_materia);

		assertEquals(busqueda[0], actuales[0]);
		assertEquals(busqueda[1], actuales[1]);

	}

	@Test
	public void queSePuedaEncontrarAlumnoEnUnaCursadaPorCodigoAlumno() {
		Alumno alumno = new Alumno(1, 12412, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", 1);
		Universidad unlam = new Universidad();
		Cursada cursada = new Cursada(alumno, pb2);
		Cursada cursadaAlumnoEncontrada = null;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada);
		cursadaAlumnoEncontrada = unlam.buscarAlumnoCursada(1, 1);

		assertNotNull(cursadaAlumnoEncontrada);
	}

	@Test
	public void queSePuedaCalificarAlumno() {
		Universidad unlam = new Universidad();
		Alumno alumno = new Alumno(1, 45128862, "Flores", "Gonzalo");
		Materia pb2 = new Materia("pb2", 1);
		Double calificacion = 7.0;
		Cursada cursada = new Cursada(alumno, pb2);
		Cursada encontrada = null;

		unlam.registrarAlumno(alumno);
		unlam.registrarMaterias(pb2);
		unlam.inscripcionCursada(cursada);
		encontrada = unlam.buscarAlumnoCursada(1, 1);
		encontrada.calificar(calificacion);

		assertEquals(calificacion, encontrada.getNota().getValor());

	}

	@Test
	public void queSePuedaObtenerPromedioCalificacionesDeUnaCursada() {
		Materia pb2 = new Materia("pb2", 1);
		Alumno alumno = new Alumno(1, 2143, "Flores", "Gonzalo");
		Alumno alumno1 = new Alumno(2, 1234, "f", "g");
		Alumno alumno2 = new Alumno(3, 6666, "p", "v");
		Alumno alumno3 = new Alumno(4, 777, "m", "m");
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
		Integer cod_materia = 1;

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
		Alumno alumno = new Alumno(1, 124, "Flores", "Gonzalo");
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
		Materia[] listaMaterias = new Materia[100];
		Integer cod_alumno = 1;

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

		listaMaterias = unlam.obtengaUnaListaDeMateriasAprobadasDeUnAlumno(cod_alumno);

		assertEquals(pb2, listaMaterias[0]);
		assertEquals(bdd1, listaMaterias[1]);

	}

	@Test
	public void queSePuedaInscribirSiTieneLasCorrelativasAprobadas() {
		Alumno alumno = new Alumno(1, 1234, "Flores", "Gonzalo");
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
		Integer codigo_alumno = 1;

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

		exitoso = unlam.inscripcionCursadaSiTieneLasCorrelativasAprobadas(codigo_alumno, tw1);
		Cursada encontrada = unlam.buscarAlumnoCursada(2631, codigo_alumno);

		assertTrue(exitoso);
		assertNotNull(encontrada);

	}
}
