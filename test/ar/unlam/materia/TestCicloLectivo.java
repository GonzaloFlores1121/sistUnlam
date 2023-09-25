package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestCicloLectivo {
	
	@Test
	public void queSeCreeUnCicloElectivo() {
//		Integer id1 = 1;
		
		// CicloLectivo
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		// Inscripcion
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo( fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		assertNotNull(ciclo);
	}

	@Test
	public void queDosCiclosLectivosSeanDiferentes() {
		// id
		
		// CicloLectivo 1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		// CicloLectivo 2
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 1);
		// Inscripcion 2
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 2);
		// Cuatri
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		Boolean operacion = false;

		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);

		operacion = ciclo.equals(ciclo2);
//
		assertFalse(operacion);

		Integer id1 = ciclo.getIdCiclo();
		Integer id2 = ciclo2.getIdCiclo();
		Boolean sonIguales = id1 == id2;

		assertNotEquals(id1, id2);
		assertFalse(sonIguales);
	}

	
	@Test
	public void queDosCiclosLectivosSeanIgualesSiTienenMismasFechasYDiferenteID() {
		

		// CicloLectivo
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		// Inscripcion
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Boolean operacionFechas = false;
		Boolean operacionID = false;

		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		operacionFechas = ciclo.equals(ciclo2);
		operacionID = ciclo.getIdCiclo() == ciclo2.getIdCiclo();

		assertFalse(operacionID);
		assertTrue(operacionFechas);
	}
	

	// NOTA
	// QUIZAS VALIDAR LOS MESES SEGUN EL CUATRIMESTRO QUIZAS!!
}
