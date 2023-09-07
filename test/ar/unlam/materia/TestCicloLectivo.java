package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void queDosCiclosLectivosSeanIgualesSiTienenElMismoID() {
		Integer id_cicloLectivo = 1;

		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 2);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		Boolean operacion = false;

		CicloLectivo ciclo = new CicloLectivo(id_cicloLectivo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(id_cicloLectivo, fechaFinalizacionCicloLectivo2,
				fechaInicioCicloLectivo2, fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);

		operacion = ciclo.equals(ciclo2);

		assertTrue(operacion);
	}

	@Test
	public void queDosCiclosLectivosSeanIgualesSiTienenMismasFechasYDiferenteID() {
		Integer id_cicloLectivo = 1;

		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		Boolean operacion = false;

		CicloLectivo ciclo = new CicloLectivo(id_cicloLectivo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(2, fechaFinalizacionCicloLectivo1,
				fechaInicioCicloLectivo1, fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		operacion = ciclo.equals(ciclo2);

		assertTrue(operacion);
	}

}
