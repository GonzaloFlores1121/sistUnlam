package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestComision {

	@Test
	public void queDosComisionesSeanIgualesSiTieneMismaMateriaCicloLectivoyTurno() {
		Integer  id_comision = 999;
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);

		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
	

		Turno turno = Turno.TURNO_MAÑANA;
		
		Materia tw1 = new Materia("TALLER WEB1", 2300);

		CicloLectivo ciclo1 = new CicloLectivo(fechaFinalizacionCicloLectivo1,
				fechaInicioCicloLectivo1, fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Comision comi = new Comision(id_comision, turno, ciclo1, tw1);
		Comision comi1 = new Comision(1, turno, ciclo1, tw1);

		Boolean exitoso = comi1.equals(comi);

		assertTrue(exitoso);
	}

	@Test
	public void queDosComisionesNoSeanIgualesSiTieneDiferenteMateriaCicloLectivoyTurno() {
		Integer id_comision = 999;
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
		Turno turno = Turno.TURNO_MAÑANA;
		Turno turno1 = Turno.TURNO_NOCHE;

		Materia tw1 = new Materia("TALLER WEB1", 2300);
		Materia tw2 = new Materia("TALLER WEB1", 2300);

		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);

		Comision comi = new Comision(id_comision, turno, ciclo, tw1);
		Comision comi1 = new Comision(id_comision, turno1, ciclo2, tw2);

		Boolean exitoso = comi1.equals(comi);

		assertFalse(exitoso);
	}
	
	

}
