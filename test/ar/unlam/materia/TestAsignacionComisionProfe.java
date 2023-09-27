package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAsignacionComisionProfe {

	@Test
	public void queSePuedaCrearUnaAsignacionProfe() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionProfe = 1;

		// COMISION
		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		Materia materia = new Materia(nombreMateria, codigoMateria);

		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		Integer idComision = 1;

		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		// PROFESOR
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Ejecucion
		AsignacionComisionProfe asignacion= new AsignacionComisionProfe(IdAsignacionProfe, idComision, dniP);
		
		// Validacion
		assertNotNull(comision);
		assertNotNull(profe);
		assertNotNull(asignacion);
		
		assertEquals(Id_Aula, asignacion.getCodigo_comision());
		assertEquals(dniP, asignacion.getDniProfesor());
		assertEquals(idComision, asignacion.getIdComision());
	}
	
	@Test
	public void queSePuedaCrearMasAsignacionProfeDiferentes() {
		// Preparacion de datos
		
		// COMISION
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);

		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);

		// Inscripcion 2
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2024, 6, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2024, 6, 17);

		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 6, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2024, 6, 16);

		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		CicloLectivo ciclo2 = new CicloLectivo(++idCiclo, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		Aula aula2 = new Aula(++Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		String nombreMateria2 = "PB2";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		Materia materia2 = new Materia(nombreMateria2, ++codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Turno turno2 = Turno.TURNO_TARDE;
		Dia day = Dia.LUNES;
		Dia day2 = Dia.MARTES;

		// Comision
		Integer idComision = 1;
		Integer idComision2 = 2;

		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		Comision comision2 = new Comision(idComision2, day2, turno2, ciclo2, materia2, aula2);
		
		// PROFESOR
		Integer dniP = 123;
		Integer dniP2 = 122;
		String nombreP = "Gonza";
		String apellidoP = "Flores";
		
		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Profesor profe2 = new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		//ids
		
		Integer IdAsignacionProfe = 1;
		Integer IdAsignacionProfe2 = 2;

		
		// Ejecucion
		AsignacionComisionProfe asignacion= new AsignacionComisionProfe(IdAsignacionProfe, idComision, dniP);
		AsignacionComisionProfe asignacion2= new AsignacionComisionProfe(IdAsignacionProfe2, idComision2, dniP2);
		
		// Validacion
		assertNotNull(asignacion);
		assertNotNull(asignacion2);
		
		assertNotEquals(asignacion, asignacion2);
//		assertEquals(asignacion, asignacion2);
	}

}
