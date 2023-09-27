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
		
		Integer id=1;
		
		CicloLectivo ciclo = new CicloLectivo(id, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		
		assertNotNull(ciclo);
				
		Integer vo=ciclo.getIdCiclo();
		Integer ve=id;
		
		assertEquals(ve, vo);
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
		//IDs
		Integer id1=1;
		Integer id2=2;

		CicloLectivo ciclo = new CicloLectivo(id1,fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		CicloLectivo ciclo2 = new CicloLectivo(id2,fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);

		//IDS
		Integer vo1=ciclo.getIdCiclo();
		Integer vo2=ciclo2.getIdCiclo();
		Integer ve1=1;
		Integer ve2=2;
		Boolean noSonIguales=vo1!=vo2;
		
		assertTrue(noSonIguales);
		assertEquals(ve1,vo1 );
		assertEquals(ve2, vo2);
	}

	@Test
	public void queDosCiclosLectivosNoTenganLaMismaFecha() {
		
		// CicloLectivo
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 4, 12);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		// Inscripcion
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		assertNotEquals(ciclo, ciclo2);
	}
}
