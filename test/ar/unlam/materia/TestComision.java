package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class TestComision {

	@Test
	public void queSeCreeUnaComision() {

		// Preparacion de datos
		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		// Validacion
		assertNotNull(comision);

		assertEquals(idComision, comision.getCodigo_comision());
		assertEquals(day, comision.getDia());
		assertEquals(turno, comision.getTurno());
		assertEquals(ciclo, comision.getCiclo());
		assertEquals(materia, comision.getMateria());
		assertEquals(aula, comision.getAula());
		assertEquals(0, comision.getProfes().size());
		assertTrue(comision.getProfes().isEmpty());
		assertEquals(0, comision.getAlumnos().size());
		assertTrue(comision.getAlumnos().isEmpty());
	}

	@Test
	public void crearMasComisionesQueNoSeanIguales() {
		// Preparacion de datos

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

		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		Comision comision2 = new Comision(++idComision, day2, turno2, ciclo2, materia2, aula2);
//		Comision comision2 = new Comision(idComision, day2, turno2, ciclo2, materia2, aula2);
//		Comision comision2 = new Comision(++idComision, day, turno, ciclo, materia, aula2);

		// Validacion
		assertNotNull(comision);
		assertNotNull(comision2);
		assertNotEquals(comision, comision2);
	}
	
	

	@Test
	public void queSePuedaInscribirUnAlumnoALaComision() {
		// Preparacion de datos

		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);

		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);

		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		String nombre="Diego";
		String apellido="Oliva";
		
			//fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		
		Integer ve=1;
		Integer vo=comision.getAlumnos().size();
		// Validacion
		assertEquals(ve, vo);
		assertFalse(comision.getAlumnos().isEmpty());
	}
	
	@Test
	public void queNoSePuedaInscribirADosAlumnosALaComisionConElMismoDni() {
		// Preparacion de datos
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		Integer dni2=122;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2=new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirAlumno(alumno2);
		
		Integer ve=2;
//		Integer ve1=1;
		Integer vo=comision.getAlumnos().size();
		// Validacion
		assertEquals(ve, vo);
//		assertEquals(ve1, vo);
		assertFalse(comision.getAlumnos().isEmpty());
	}
	
	@Test
	public void queNoSePuedaInscribirAMasAlumnosALaComisionSiSuperaLaCantidadMaximaDelAula() {
		// Preparacion de datos
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 3;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		Integer dni2=122;
		Integer dni3=121;
		Integer dni4=120;
		Integer dni5=120;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2=new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno3=new Alumno(dni3, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno4=new Alumno(dni4, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno5=new Alumno(dni5, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirAlumno(alumno2);
		comision.inscribirAlumno(alumno3);
		Boolean ingreso=comision.inscribirAlumno(alumno4);
		comision.inscribirAlumno(alumno5);
		
		Integer ve=comision.getAula().getCapacidadMax();//3
//		Integer ve1=1;
		Integer vo=comision.getAlumnos().size();
		// Validacion
		assertFalse(ingreso);
		assertEquals(ve, vo);
//		assertEquals(ve1, vo);
		assertFalse(comision.getAlumnos().isEmpty());
	}
	
	@Test
	public void queSePuedaInscribirUnProfesorALaCursada() {
		// Preparacion de datos
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 3;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas alumnos
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		//Profesor
		Integer dniP=123;
		String nombreP="Gonza";
		String apellidoP="Flores";
		
		//fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirProfesor(profe);
		
		Double ve=comision.cantidadDeProfesPorAula();
		Integer vo=comision.getProfes().size();
		
		// Validacion
		assertEquals(ve,vo,0);
		assertFalse(comision.getProfes().isEmpty());
	}
	
	@Test
	public void queNoSePuedaInscribirUnProfesorALaCursadaSiNoHayAlumnos() {
		// Preparacion de datos
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 3;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Profesor
		Integer dniP=123;
		String nombreP="Gonza";
		String apellidoP="Flores";
		
		//fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirProfesor(profe);
		
		Integer ve=0;
		Integer vo=comision.getProfes().size();
		
		// Validacion
		assertEquals(ve,vo);
		assertTrue(comision.getProfes().isEmpty());
	}
	
	@Test
	public void queNoSePuedaDesignarDosProfesIgualesALaMismaCursada() {
		// Preparacion de datos
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 3;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas alumnos
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		//Profesor
		Integer dniP=123;
//		Integer dniP2=122;// dni diferente
		String nombreP="Gonza";
		String apellidoP="Flores";
		
		//fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Profesor profe2=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirProfesor(profe);
		Boolean resultado=comision.inscribirProfesor(profe2);
		
		Integer ve=1;
		Integer vo=comision.getProfes().size();
		
		// Validacion
		assertFalse(resultado);
		assertEquals(ve, vo);
		assertFalse(comision.getProfes().isEmpty());
	}

	@Test
	public void queSeInscribanLaCantidadDeProfesNecesariosParaLaCantidadDeAlumnos() {
		// Preparacion de datos HACER
		
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 6;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		Integer dni2=122;
		Integer dni3=121;
		Integer dni4=120;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas alumnos
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2=new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno3=new Alumno(dni3, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno4=new Alumno(dni4, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		//Profesor
		Integer dniP=123;
		Integer dniP2=122;
		String nombreP="Gonza";
		String apellidoP="Flores";
		
		//fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Profesor profe2=new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirAlumno(alumno2);
		comision.inscribirAlumno(alumno3);
		comision.inscribirAlumno(alumno4);
		comision.inscribirProfesor(profe);
		Boolean resultado=comision.inscribirProfesor(profe2);
		
		Double ve=comision.cantidadDeProfesPorAula();
		Integer vo=comision.getProfes().size();
		
		// Validacion
		assertEquals(ve, vo,0);
		assertTrue(resultado);
		assertFalse(comision.getProfes().isEmpty());
	}
	
	@Test
	public void queNoSeInscribanProfesDeMasParaLaCantidadDeAlumnos() {
		// Preparacion de datos HACER
		
		
		// ID ciclo
		Integer idCiclo = 1;
		// Inscripcion 1
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		
		// Ciclo1
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 4, 16);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri);
		
		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 6;
		
		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;
		
		// Comision
		Integer idComision = 1;
		
		//Alumno
		Integer dni=123;
		Integer dni2=122;
		Integer dni3=121;
		Integer dni4=120;
		String nombre="Diego";
		String apellido="Oliva";
		
		//fechas alumnos
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
		
		Alumno alumno=new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno2=new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno3=new Alumno(dni3, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		Alumno alumno4=new Alumno(dni4, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		
		//Profesor
		Integer dniP=123;
		Integer dniP2=122;
		Integer dniP3=121;
		String nombreP="Gonza";
		String apellidoP="Flores";
		
		//fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);
		
		Profesor profe=new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Profesor profe2=new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Profesor profe3=new Profesor(dniP3, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		
		// Ejecucion
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		comision.inscribirAlumno(alumno);
		comision.inscribirAlumno(alumno2);
		comision.inscribirAlumno(alumno3);
		comision.inscribirAlumno(alumno4);
		comision.inscribirProfesor(profe);
		comision.inscribirProfesor(profe2);
		Boolean resultado=comision.inscribirProfesor(profe3);
		
		Double ve=comision.cantidadDeProfesPorAula();
		Integer vo=comision.getProfes().size();
		
		// Validacion
		assertEquals(ve, vo,0);
		assertFalse(resultado);
		assertFalse(comision.getProfes().isEmpty());
	}
	
//	@Test
//	public void queDosComisionesSeanIgualesSiTieneMismaMateriaCicloLectivoyTurno() {
//		Integer id_comision = 999;
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		Turno turno = Turno.TURNO_MAÑANA;
//
//		Materia tw1 = new Materia("TALLER WEB1", 2300);
//
//		CicloLectivo ciclo1 = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		Comision comi = new Comision(id_comision, turno, ciclo1, tw1);
//		Comision comi1 = new Comision(1, turno, ciclo1, tw1);
//
//		Boolean exitoso = comi1.equals(comi);
//
//		assertTrue(exitoso);
//	}

//	@Test
//	public void queDosComisionesNoSeanIgualesSiTieneDiferenteMateriaCicloLectivoyTurno() {
//		Integer id_comision = 999;
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2023, 7, 25);
//		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 2);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;
//		Turno turno = Turno.TURNO_MAÑANA;
//		Turno turno1 = Turno.TURNO_NOCHE;
//
//		Materia tw1 = new Materia("TALLER WEB1", 2300);
//		Materia tw2 = new Materia("TALLER WEB1", 2300);
//
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
//				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
//
//		Comision comi = new Comision(id_comision, turno, ciclo, tw1);
//		Comision comi1 = new Comision(id_comision, turno1, ciclo2, tw2);
//
//		Boolean exitoso = comi1.equals(comi);
//
//		assertFalse(exitoso);
//	}

}
