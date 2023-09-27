package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAsignacionAlumno {

	@Test
	public void queSePuedaCrearUnaAsignacionAlumno() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;

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

		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);

		// Validacion
		assertNotNull(comision);
		assertNotNull(alumno);
		assertNotNull(asignacion);

		assertEquals(Id_Aula, asignacion.getCodigo_comision());
		assertEquals(dni, asignacion.getDniAlumno());
		assertEquals(idComision, asignacion.getCodigo_comision());
	}
	
	@Test
	public void queSePuedaCrearMasAsignacionAlumnoDiferentes() {
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
		
		// Alumno
		Integer dni = 123;
		Integer dni2 = 122;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		//ids
		
		Integer IdAsignacionAlumno= 1;
		Integer IdAsignacionAlumno2= 2;

		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		AsignacionComisionAlumno asignacion2 = new AsignacionComisionAlumno(IdAsignacionAlumno2, idComision2, dni2);
		
		// Validacion
		assertNotNull(asignacion);
		assertNotNull(asignacion2);
		
		assertNotEquals(asignacion, asignacion2);
	}
	
	@Test
	public void queSeRegistreUnaNota() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		
		Integer ve=1;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSeRegistreDosNotasDelMismoTipo() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean resultado2=asignacion.registrarNota(valorDeNota, clase);
		
		Integer ve=1;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSeRegistreDosNotasDeDiferenteTipo() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.SEGUNDO_PARCIAL;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean resultado2=asignacion.registrarNota(valorDeNota, clase2);
		
		Integer ve=2;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertTrue(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSeRegistreMasNotasDespuesDelLimiteDeNotas() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.SEGUNDO_PARCIAL;
		ClaseDeNota clase3=ClaseDeNota.RECUPERATORIO_1;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean resultado2=asignacion.registrarNota(valorDeNota, clase2);
		Boolean resultado3=asignacion.registrarNota(valorDeNota, clase3);
		
		Integer ve=2;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertTrue(resultado2);
		assertFalse(resultado3);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSeRegistreNotasRecuperatorioAlAsignarlasPorPrimeraVez() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.RECUPERATORIO_1;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		
		Integer ve=0;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertEquals(ve, vo);
		assertFalse(resultado);
	}
	
	@Test
	public void queSePuedaRecuperarUnaNota() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=3.00;
		Double valorDeNota2=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.RECUPERATORIO_1;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean comparacion=clase.equals(asignacion.getNotas().get(0).getTipoDeNota());
		
		asignacion.recuperarNota(clase,valorDeNota2);
		
		Integer ve=1;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(comparacion);
		assertTrue(resultado);
		assertEquals(ve, vo);
		assertEquals(clase2, asignacion.getNotas().get(0).getTipoDeNota());
	}
	
	@Test
	public void queSePuedaRecuperarSoloUnaNota() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=4.00;
		Double valorDeNota2=5.00;
		Double valorDeNota3=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.SEGUNDO_PARCIAL;
		
		ClaseDeNota recu=ClaseDeNota.RECUPERATORIO_1;
		ClaseDeNota recu2=ClaseDeNota.RECUPERATORIO_2;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean resultado2=asignacion.registrarNota(valorDeNota2, clase2);
		Boolean comparacion=clase.equals(asignacion.getNotas().get(0).getTipoDeNota());
		
		asignacion.recuperarNota(clase,valorDeNota3);
		asignacion.recuperarNota(clase2,valorDeNota3);
		
		Integer ve=2;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(comparacion);
		assertTrue(resultado);
		assertTrue(resultado2);
		assertEquals(ve, vo);
		assertEquals(recu, asignacion.getNotas().get(0).getTipoDeNota());
		assertEquals(clase2, asignacion.getNotas().get(1).getTipoDeNota());
	}
	
	@Test
	public void queNoSePuedaRecuperarUnaNotaQueNoExiste() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota3=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.SEGUNDO_PARCIAL;
		
		ClaseDeNota recu=ClaseDeNota.RECUPERATORIO_1;
		
		asignacion.recuperarNota(clase,valorDeNota3);
		
		Integer ve=0;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertFalse(asignacion.existe(clase));
		assertEquals(ve, vo);
	}
	
	@Test
	public void obtenerPromedioFinal() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=6.00;
		Double valorDeNota2=5.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		ClaseDeNota clase2=ClaseDeNota.SEGUNDO_PARCIAL;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		Boolean resultado2=asignacion.registrarNota(valorDeNota2, clase2);
		
		Double notaFinal=asignacion.obtenerPromedioFinal();
		Double finalVe=5.00;
		
		Integer ve=2;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertTrue(resultado2);
		assertEquals(ve, vo);
		assertEquals(finalVe, notaFinal);
	}
	
	@Test
	public void noPoderObtenerElPromedioFinalPorFaltaDeNotas() {
		// Preparacion de datos
		// Id
		Integer IdAsignacionAlumno = 1;
		
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
		
		// Alumno
		Integer dni = 123;
		String nombre = "Gonza";
		String apellido = "Flores";
		
		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2023, 3, 11);
		
		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		AsignacionComisionAlumno asignacion = new AsignacionComisionAlumno(IdAsignacionAlumno, idComision, dni);
		Double valorDeNota=7.00;
		ClaseDeNota clase=ClaseDeNota.PRIMER_PARCIAL;
		
		Boolean resultado=asignacion.registrarNota(valorDeNota, clase);
		
		Double notaFinal=asignacion.obtenerPromedioFinal();
		Double finalVe=0.0;
		
		Integer ve=1;
		Integer vo=asignacion.getNotas().size();
		// Validacion
		assertTrue(resultado);
		assertEquals(ve, vo);
		assertEquals(finalVe, notaFinal);
	}
	
}
