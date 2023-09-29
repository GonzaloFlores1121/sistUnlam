package ar.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;

public class TestUniversidad {
	// chau pichu
	@Test
	public void queSeCreeLaUniversidad() {
		Universidad unlam = new Universidad();

		assertNotNull(unlam);
		assertNotNull(unlam.getMaterias());
		assertNotNull(unlam.getAlumnos());
		assertNotNull(unlam.getProfes());
		assertNotNull(unlam.getAulas());
		assertNotNull(unlam.getCiclosLectivos());
		assertNotNull(unlam.getComisiones());
		assertNotNull(unlam.getComisionesAlumno());// Se crean cuando se inscribe
		assertNotNull(unlam.getComisionesProfe());// Se crean cuando se inscribe
	}

	@Test
	public void queSeCreeMateriasAlumnosProfesAulasComisionesYCicloLectivo() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 0;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		// Yo puedo registrar a un alumno en la facu que no esta cursando?
		unlam.registrarAlumno(alumno);
		////////////////////////////////
		unlam.registrarProfesor(profe);
		unlam.registrarAula(aula);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarComision(comision);

		Integer ve = 1;
		// Evaluacion

		Integer vo = unlam.getMaterias().size();
		assertEquals(ve, vo);
		vo = unlam.getAlumnos().size();
		assertEquals(ve, vo);
		vo = unlam.getProfes().size();
		assertEquals(ve, vo);
		vo = unlam.getAulas().size();
		assertEquals(ve, vo);
		vo = unlam.getCiclosLectivos().size();
		assertEquals(ve, vo);
		vo = unlam.getComisiones().size();
		assertEquals(ve, vo);
	}

	@Test
	public void queSeCreeAtributosDiferentes() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		Integer dni2 = 124;

		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Integer dniP2 = 124;
		Profesor profe2 = new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		Integer Id_Aula2 = 2;
		Aula aula2 = new Aula(Id_Aula2, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 1;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Integer idCiclo2 = 2;
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2024, 6, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2024, 6, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 7, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
		Integer idComision2 = 2;
		Turno turno2 = Turno.TURNO_MAÑANA;
		Dia day2 = Dia.LUNES;
		Comision comision2 = new Comision(idComision2, day2, turno2, ciclo2, materia2, aula2);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		// Yo puedo registrar a un alumno en la facu que no esta cursando?
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno2);
		////////////////////////////////
		unlam.registrarProfesor(profe);
		unlam.registrarProfesor(profe2);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarComision(comision);
		unlam.registrarComision(comision2);

		Integer ve = 2;
		// Evaluacion

		Integer vo = unlam.getMaterias().size();
		assertEquals(ve, vo);
		vo = unlam.getAlumnos().size();
		assertEquals(ve, vo);
		vo = unlam.getProfes().size();
		assertEquals(ve, vo);
		vo = unlam.getAulas().size();
		assertEquals(ve, vo);
		vo = unlam.getCiclosLectivos().size();
		assertEquals(ve, vo);
		vo = unlam.getComisiones().size();
		assertEquals(ve, vo);
	}

	@Test
	public void queSePuedaUbicarDeterminadosAtributos() {
		// Preparacion
		// Materia
		String nombreMateria = "PB1";
		Integer codigoMateria = 1;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		String nombreMateria2 = "PB2";
		Integer codigoMateria2 = 2;

		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);

		// Alumno
		Integer dni = 123;
		String nombre = "Diego";
		String apellido = "Oliva";

		// fechas
		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);

		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);

		Integer dni2 = 124;

		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
		////////////////

		// Profesor
		Integer dniP = 123;
		String nombreP = "Gonza";
		String apellidoP = "Flores";

		// fechas
		LocalDate fechaDeNacimientoP = LocalDate.of(2000, 1, 28);
		LocalDate fechaDeInscripcionP = LocalDate.of(2023, 3, 11);

		Profesor profe = new Profesor(dniP, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);
		Integer dniP2 = 124;
		Profesor profe2 = new Profesor(dniP2, nombreP, apellidoP, fechaDeNacimientoP, fechaDeInscripcionP);

		// Aula
		Integer Id_Aula = 1;
		Integer cantidadMaximaAlumnos = 5;

		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
		Integer Id_Aula2 = 2;
		Aula aula2 = new Aula(Id_Aula2, cantidadMaximaAlumnos);

		// Ciclo
		Integer idCiclo = 1;
		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;

		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);

		Integer idCiclo2 = 2;
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2024, 6, 10);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2024, 6, 17);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2024, 7, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2024, 7, 17);
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;

		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		// Tiempo
		Turno turno = Turno.TURNO_MAÑANA;
		Dia day = Dia.LUNES;

		// Comision
		Integer idComision = 1;
		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);

		Integer idComision2 = 2;
		Turno turno2 = Turno.TURNO_MAÑANA;
		Dia day2 = Dia.LUNES;
		Comision comision2 = new Comision(idComision2, day2, turno2, ciclo2, materia2, aula2);

		Universidad unlam = new Universidad();
		// Ejecucion
		unlam.registrarMaterias(materia);
		unlam.registrarMaterias(materia2);
		unlam.registrarAlumno(alumno);
		unlam.registrarAlumno(alumno2);
		unlam.registrarProfesor(profe);
		unlam.registrarProfesor(profe2);
		unlam.registrarAula(aula);
		unlam.registrarAula(aula2);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarComision(comision);
		unlam.registrarComision(comision2);
		
		// Evaluacion
		assertNotNull(unlam.buscarMateria(codigoMateria2));
		assertNotNull(unlam.buscarAlumnoRegistrado(dni));
		assertNotNull(unlam.buscarProfesorRegistrado(dniP2));
		assertNotNull(unlam.buscarAulaPorNumero(Id_Aula2));
		assertNotNull(unlam.buscarCicloLectivoPorID(idCiclo));
		assertNotNull(unlam.buscarComisionPorCodigo(idComision2));
	}
	
	//PRUEBAS DE CREACION Y UBICACION DE ATRIBUTOS
	@Test
	public void queSePuedaRegistrarUnaMateriaYEncontrarlaPorCodigo() {
		// Preparacion
		Integer codigo_materia = 2623;
		Materia materia = new Materia("PB2", codigo_materia);
		
		Universidad unlam = new Universidad();
		
		Materia esperada = null;
		
		// Ejecucion
		Boolean resultado=unlam.registrarMaterias(materia);
		esperada = unlam.buscarMateria(codigo_materia);
		
		Integer ve=1;
		Integer vo=unlam.getMaterias().size();
		// Evaluacion

		assertTrue(resultado);
		assertEquals(materia, esperada);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosMateriasConMismoCodigo() {
		// Preparacion
		Integer codigo_materia = 2623;
		Materia materia = new Materia("PB2", codigo_materia);
		Materia materiaError = new Materia("TW1", codigo_materia);
		
		Boolean operacion = false;
		Boolean operacion1 = false;
		
		Universidad unlam = new Universidad();
		
		// Ejecucion
		operacion1 = unlam.registrarMaterias(materia);
		operacion = unlam.registrarMaterias(materiaError);

		Integer ve=1;
		Integer vo=unlam.getMaterias().size();
		// Evaluacion
		assertTrue(operacion1);
		assertFalse(operacion);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaRegistrarUnAlumnoYEncontrarloPorDni() {
		// Preparacion
		Integer dni = 777;
		Alumno alm = new Alumno(dni, "F", "G");
		Universidad unlam = new Universidad();
		Alumno esperada = null;
	
		// Ejecucion
		Boolean resultado=unlam.registrarAlumno(alm);
		esperada = unlam.buscarAlumnoRegistrado(dni);
		
		Integer ve=1;
		Integer vo=unlam.getAlumnos().size();
		// Evaluacion
		assertTrue(resultado);
		assertEquals(alm, esperada);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAlumnosConMismoDni() {
		// Preparacion
		Integer dni = 777;
		Alumno alm = new Alumno(dni, "F", "G");
		Alumno alm2 = new Alumno(dni, "A", "Z");
		
		Universidad unlam = new Universidad();
		
		Boolean op = false;
		Boolean op2 = false;

		// Ejecucion
		op = unlam.registrarAlumno(alm);
		op2 = unlam.registrarAlumno(alm2);
		
		Integer ve=1;
		Integer vo=unlam.getAlumnos().size();
		// Evaluacion
		assertTrue(op);
		assertFalse(op2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaRegistrarUnProfesorYEncontrarloPorDni() {
		// Preparacion
		Integer dni = 444;
		String nombre = "A", apellido = "B";
		Profesor profe = new Profesor(dni, nombre, apellido);
		Universidad unlam = new Universidad();
		Profesor esperado = null;
		
		// Ejecucion
		Boolean resultado=unlam.registrarProfesor(profe);
		esperado = unlam.buscarProfesorRegistrado(dni);
		
		Integer ve=1;
		Integer vo=unlam.getProfes().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertEquals(profe,esperado);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosProfesorConElMismoDni() {
		// Preparacion
		Integer dni = 444;
		String nombre = "A", apellido = "B";
		Profesor profe = new Profesor(dni, nombre, apellido);
		Profesor profe2 = new Profesor(dni, nombre, apellido);
		
		Universidad unlam = new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarProfesor(profe);
		Boolean resultado2=unlam.registrarProfesor(profe2);
		
		Integer ve=1;
		Integer vo=unlam.getProfes().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaRegistrarUnAulaYEncontrarlaPorNumero() {
		// Preparacion
		Integer numeroDeAula = 1;
		Integer capMax = 10;
		
		Aula aula=new Aula(numeroDeAula,capMax);
		
		Universidad unlam = new Universidad();
		Aula ubicada = null;
		
		// Ejecucion
		Boolean resultado=unlam.registrarAula(aula);
		ubicada = unlam.buscarAulaPorNumero(numeroDeAula);
		
		Integer ve=1;
		Integer vo=unlam.getAulas().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertEquals(aula,ubicada);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAulaConElMismoNumero() {
		// Preparacion
		Integer numeroDeAula = 1;
		Integer capMax = 10;
		
		Aula aula=new Aula(numeroDeAula,capMax);
		Aula aula2=new Aula(numeroDeAula,capMax);
		
		Universidad unlam = new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarAula(aula);
		Boolean resultado2=unlam.registrarAula(aula2);
		
		Integer ve=1;
		Integer vo=unlam.getAulas().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaRegistrarCicloLectivoYEncontrarloPorId() {
		// Preparacion
		Integer id=1;

		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(id,fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		Universidad unlam = new Universidad();

		CicloLectivo encontrado=null;
		
		Boolean operacion = false;
		// Ejecucion
		operacion = unlam.registrarCicloLectivo(ciclo);
		encontrado=unlam.buscarCicloLectivoPorID(id);
		
		Integer ve=1;
		Integer vo=unlam.getCiclosLectivos().size();
		// Evaluacion
		assertTrue(operacion);
		assertEquals(ciclo, encontrado);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosCicloLectivoQueSeSuperponganLasFechasYDiferenteId() {
		// Preparacion
		Integer id=1;
		Integer id2=2;
		
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(id,fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		CicloLectivo ciclo2 = new CicloLectivo(id2,fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		Universidad unlam = new Universidad();
		
		Boolean operacion = false;
		Boolean operacion2 = false;
		// Ejecucion
		operacion = unlam.registrarCicloLectivo(ciclo);
		operacion2 = unlam.registrarCicloLectivo(ciclo2);
		
		Integer ve=1;
		Integer vo=unlam.getCiclosLectivos().size();
		// Evaluacion
		assertTrue(operacion);
		assertFalse(operacion2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosCicloLectivoQueTenganElMismoIdYDiferenteFechas() {
		// Preparacion
		Integer id=1;
		
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		
		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2023, 8, 28);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 30);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 9, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 2);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(id,fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		CicloLectivo ciclo2 = new CicloLectivo(id,fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
		
		Universidad unlam = new Universidad();
		
		Boolean operacion = false;
		Boolean operacion2 = false;
		// Ejecucion
		operacion = unlam.registrarCicloLectivo(ciclo);
		operacion2 = unlam.registrarCicloLectivo(ciclo2);
		
		Integer ve=1;
		Integer vo=unlam.getCiclosLectivos().size();
		// Evaluacion
		assertTrue(operacion);
		assertFalse(operacion2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queSePuedaRegistrarUnaComisionYEncontrarloPorCodigoYID() {
		// Preparacion
		Integer	codigoComision = 2900;
		
		Integer numero = 999, capacidadMax = 50;
		
		Aula aula = new Aula(numero, capacidadMax);
		
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		Turno turno = Turno.TURNO_MAÑANA;
		Dia dia = Dia.LUNES;
		
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		
		Comision comision = new Comision(codigoComision,dia,turno,ciclo,tw1,aula);
		
		Integer id_comision = comision.getId();
		
		Comision encontrada = null;
		
		Universidad unlam = new Universidad();
		// Ejecucion

		unlam.registrarMaterias(tw1);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarAula(aula);
		Boolean resultado=unlam.registrarComision(comision);
		encontrada = unlam.buscarComisionPorCodigo(codigoComision);
		
		Integer ve=1;
		Integer vo=unlam.getComisiones().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertEquals(encontrada, comision);
		assertEquals(ve, vo);

	}
	
	@Test
	public void queNoSePuedaRegistrarDosComisionSiTieneElMismoId() {
		// Preparacion
		Integer	codigoComision = 2900;
		
		Integer numero = 999, capacidadMax = 50;
		
		Aula aula = new Aula(numero, capacidadMax);
		
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri2);
		
		Turno turno = Turno.TURNO_MAÑANA;
		Dia dia = Dia.LUNES;
		
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		
		Comision comision = new Comision(codigoComision,dia,turno,ciclo,tw1,aula);
		Comision comision2 = new Comision(codigoComision,dia,turno,ciclo2,tw1,aula);
		
		Comision encontrada = null;
		
		Universidad unlam = new Universidad();
		// Ejecucion
		
		unlam.registrarMaterias(tw1);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarAula(aula);
		Boolean resultado=unlam.registrarComision(comision);
		Boolean resultado2=unlam.registrarComision(comision2);
		encontrada = unlam.buscarComisionPorCodigo(codigoComision);
		
		Integer ve=1;
		Integer vo=unlam.getComisiones().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(encontrada, comision);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosComisionSiTieneElMismosAtributosMenosElId() {
		// Preparacion
		Integer	codigoComision = 2900;
		Integer	codigoComision2 = 2901;
		
		Integer numero = 999, capacidadMax = 50;
		
		Aula aula = new Aula(numero, capacidadMax);
		
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 29);
		
		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
//		Cuatrimestre cuatri2 = Cuatrimestre.SEGUNDO_CUATRIMESTRE;
		
		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		CicloLectivo ciclo2 = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
		
		Turno turno = Turno.TURNO_MAÑANA;
		Dia dia = Dia.LUNES;
		
		Materia tw1 = new Materia("TALLER WEB1", 2300);
		
		Comision comision = new Comision(codigoComision,dia,turno,ciclo,tw1,aula);
		Comision comision2 = new Comision(codigoComision2,dia,turno,ciclo2,tw1,aula);
		
		Universidad unlam = new Universidad();
		// Ejecucion
		
		unlam.registrarMaterias(tw1);
		unlam.registrarCicloLectivo(ciclo);
		unlam.registrarCicloLectivo(ciclo2);
		unlam.registrarAula(aula);
		Boolean resultado=unlam.registrarComision(comision);
		Boolean resultado2=unlam.registrarComision(comision2);
		
		Integer ve=1;
		Integer vo=unlam.getComisiones().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}

	@Test
	public void queSePuedaRegistrarUnaAsignacionComisionAlumnoYEncontrarlaPorId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoComision=1;
		Integer dni=1;
		
		AsignacionComisionAlumno alumno=new AsignacionComisionAlumno(codigoAsignacion, codigoComision,dni);
		
		Universidad unlam=new Universidad();
		
		AsignacionComisionAlumno ubicado=null;
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionAlumno(alumno);
		ubicado=unlam.buscarAsignacionAlumnoComision(codigoAsignacion);

		Integer ve=1;
		Integer vo=unlam.getComisionesAlumno().size();

		// Evaluacion
		assertTrue(resultado);
		assertEquals(ubicado, alumno);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAsignacionComisionAlumnoConElMismoId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoComision=1;
		Integer codigoComision2=2;
		Integer dni=1;
		
		AsignacionComisionAlumno alumno=new AsignacionComisionAlumno(codigoAsignacion, codigoComision,dni);
		AsignacionComisionAlumno alumno2=new AsignacionComisionAlumno(codigoAsignacion, codigoComision2,dni);
		
		Universidad unlam=new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionAlumno(alumno);
		Boolean resultado2=unlam.registrarAsignacionComisionAlumno(alumno2);
		
		Integer ve=1;
		Integer vo=unlam.getComisionesAlumno().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAsignacionComisionAlumnoConLosMismosAtributosMenosId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoAsignacion2=2;
		
		Integer codigoComision=1;
		Integer dni=1;
		
		AsignacionComisionAlumno alumno=new AsignacionComisionAlumno(codigoAsignacion, codigoComision,dni);
		AsignacionComisionAlumno alumno2=new AsignacionComisionAlumno(codigoAsignacion2, codigoComision,dni);
		
		Universidad unlam=new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionAlumno(alumno);
		Boolean resultado2=unlam.registrarAsignacionComisionAlumno(alumno2);
		
		Integer ve=1;
		Integer vo=unlam.getComisionesAlumno().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}

	@Test
	public void queSePuedaRegistrarUnaAsignacionComisionProfesorYEncontrarlaPorId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoComision=1;
		Integer dni=1;
		
		AsignacionComisionProfe profe=new AsignacionComisionProfe(codigoAsignacion, codigoComision,dni);
		
		Universidad unlam=new Universidad();
		
		AsignacionComisionProfe ubicado=null;
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionProfe(profe);
		ubicado=unlam.buscarAsignacionProfeComision(codigoAsignacion);

		Integer ve=1;
		Integer vo=unlam.getComisionesProfe().size();

		// Evaluacion
		assertTrue(resultado);
		assertEquals(ubicado, profe);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAsignacionComisionProfesorConElMismoId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoComision=1;
		Integer codigoComision2=2;
		Integer dni=1;
		
		AsignacionComisionProfe profe=new AsignacionComisionProfe(codigoAsignacion, codigoComision,dni);
		AsignacionComisionProfe profe2=new AsignacionComisionProfe(codigoAsignacion, codigoComision2,dni);
		
		Universidad unlam=new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionProfe(profe);
		Boolean resultado2=unlam.registrarAsignacionComisionProfe(profe2);
		
		Integer ve=1;
		Integer vo=unlam.getComisionesProfe().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaRegistrarDosAsignacionComisionProfesorConMismosAtributosMenosId() {
		// Preparacion
		Integer codigoAsignacion=1;
		Integer codigoAsignacion2=2;
		Integer codigoComision=1;
		Integer dni=1;
		
		AsignacionComisionProfe profe=new AsignacionComisionProfe(codigoAsignacion, codigoComision,dni);
		AsignacionComisionProfe profe2=new AsignacionComisionProfe(codigoAsignacion2, codigoComision,dni);
		
		Universidad unlam=new Universidad();
		
		// Ejecucion
		Boolean resultado=unlam.registrarAsignacionComisionProfe(profe);
		Boolean resultado2=unlam.registrarAsignacionComisionProfe(profe2);
		
		Integer ve=1;
		Integer vo=unlam.getComisionesProfe().size();
		
		// Evaluacion
		assertTrue(resultado);
		assertFalse(resultado2);
		assertEquals(ve, vo);
	}
//	
	/////////////////////////////////////////////////////////
	
//	//PRUEBAS AULA
//	@Test
//	public void queSePuedaAsignarAulaAUnComision2() {
//		// Preparacion
//		Universidad unlam = new Universidad();
//
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//
//		Integer numero = 1;
//		Integer capacidadMax = 10;
//		Aula aula = new Aula(numero, capacidadMax);
//
//		// Ejecucion
//		unlam.registrarComision(comision);
//		unlam.registrarAula(aula);
//		Boolean resultado = unlam.asignarAulaAComision(codigoCurso, aula);
//
//		// Evaluacion
//		assertTrue(resultado);
//		assertEquals(aula, comision.getAula());
//
//	}
//	
//	@Test
//	public void queSePuedaAsignarAulaAUnComision() {
//		Universidad unlam = new Universidad();
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//		Integer numero = 416;
//		Integer capacidadMax = 50;
//		Integer idComision = comision.getId();
//
//		Aula aula = new Aula(numero, capacidadMax);
//		unlam.registrarComision(comision);
//		unlam.registrarAula(aula);
//		Boolean resultado = unlam.asignarAulaAComision(idComision, codigoCurso, aula);
//
//		assertTrue(resultado);
//	}
//
//	public void queNoSePuedaAsignarAulaAUnComisionPorqueLaAulaNoExiste() {
//		Universidad unlam = new Universidad();
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//		Integer numero = 416;
//		Integer capacidadMax = 50;
//		Integer idComision = comision.getId();
//
//		Aula aula = new Aula(numero, capacidadMax);
//		unlam.registrarComision(comision);
//
//		Boolean resultado = unlam.asignarAulaAComision(idComision, codigoCurso, aula);
//
//		assertFalse(resultado);
//	}
//
//	@Test
//	public void queNoSeSePuedaAsignarAulaAUnComisionPorqueLaComisionNoEstaRegistrada() {
//		Universidad unlam = new Universidad();
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//		Integer numero = 416;
//		Integer capacidadMax = 50;
//		Integer idComision = comision.getId();
//
//		Aula aula = new Aula(numero, capacidadMax);
//
//		unlam.registrarAula(aula);
//		Boolean resultado = unlam.asignarAulaAComision(idComision, codigoCurso, aula);
//
//		assertFalse(resultado);
//	}
//
//	////Diego
//	@Test
//	public void queSePuedaAsignarAulaAUnComisionDiego() {
//		// Preparacion
//		Universidad unlam = new Universidad();
//
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//
//		Integer numero = 1;
//		Integer capacidadMax = 10;
//		Aula aula = new Aula(numero, capacidadMax);
//
//		// Ejecucion
//		unlam.registrarComision(comision);
//		unlam.registrarAula(aula);
//		Boolean resultado = unlam.asignarAulaAComision(codigoCurso, aula);
//
//		// Evaluacion
//		assertTrue(resultado);
//		assertEquals(aula, comision.getAula());
//	}
//	
//	//////////////
//	//Correlativas
//	
//	@Test
//	public void queSePuedaRegistrarUnaMateriaCorrelativa() {
//		// Preparacio
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		String nombreMateria2 = "PB2";
//		Integer codigoMateria2 = 2;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);
//
//		Universidad unlam = new Universidad();
//
//		Materia materiaBuscada = null;
//
//		// Ejecucion
//		unlam.registrarMaterias(materia);
//		unlam.registrarMaterias(materia2);
//		Boolean resultado = unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
//		materiaBuscada = unlam.buscarMateria(codigoMateria);
//
//		Integer ve = 1;
//		Integer vo = materiaBuscada.getCodigoCorrelativa().size();
//
//		// Evaluacion
//		assertEquals(materia, materiaBuscada);
//		assertEquals(ve, vo);
//		assertEquals(materia2.getCodigo_materia(), materiaBuscada.getCodigoCorrelativa().get(0));// compara el codigo de
//																									// materia
//		assertTrue(resultado);
//	}
//
//	@Test
//	public void queSePuedaAsignarCorrelativasAMateria() {
//
//		Integer codigoMateria = 2900;
//		Integer codigoMateriaCorrelativa = 3000;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//
//		Integer codigoCurso = 1;
//		Comision comision = new Comision(codigoCurso);
//
//		Integer numero = 1;
//		Integer capacidadMax = 10;
//		Aula aula = new Aula(numero, capacidadMax);
//
//		// Ejecucion
//		unlam.registrarComision(comision);
//		unlam.registrarAula(aula);
//		Boolean resultado = unlam.asignarAulaAComision(codigoCurso, aula);
//
//		// Evaluacion
//		assertTrue(resultado);
//		assertEquals(aula, comision.getAula());
//	}
//
//	@Test
//	public void queNoSePuedaAsignarCorrelativasAMateriaPorqueLaCorrelativaNoEstaRegistrada() {
//
//		Integer codigoMateria = 2900;
//		Integer codigoMateriaCorrelativa = 3000;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//		Boolean operacion = false;
//
//		unlam.registrarMaterias(tw1);
//
//		operacion = unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
//
//		assertFalse(operacion);
//
//	}
//
//	@Test
//	public void queSePuedaEliminarCorrelativasAMateria() {
//
//		Integer codigoMateria = 1;
//		Integer codigoMateriaCorrelativa = 2;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//
//		unlam.registrarMaterias(tw1);
//		unlam.registrarMaterias(pb2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
//		int cant = tw1.cantidadCorrelativas();
//		Boolean operacion = unlam.eliminarCorrelativaDeMateria(codigoMateria, codigoMateriaCorrelativa);
//		int cantidad = tw1.cantidadCorrelativas();
//
//		assertEquals(1, cant);
//		assertEquals(0, cantidad);
//		assertTrue(operacion);
//
//	}
//
//	public void queNoSePuedaEliminarCorrelativasAMateriaPorqueLaCorrelativaNoFormaParteDeLaMateria() {
//
//		Integer codigoMateria = 2900;
//		Integer codigoMateriaCorrelativa = 3000;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia ingieneria = new Materia("Ingenieria", 54353);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//		Boolean operacion = false;
//
//		unlam.registrarMaterias(tw1);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(ingieneria);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
//
//		operacion = unlam.eliminarCorrelativaDeMateria(codigoMateria, 54353);
//
//		assertFalse(operacion);
//
//	}
//
//	////DIEGO Y GONZA
//	@Test
//	public void queSePuedaAsignarCorrelativasAMateria2() {
//
//		Integer codigoMateria = 2900;
//		Integer codigoMateriaCorrelativa = 3000;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//		Boolean operacion = false;
//
//		unlam.registrarMaterias(tw1);
//		unlam.registrarMaterias(pb2);
//
//		operacion = unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
//		assertTrue(operacion);
//	}
//
//	@Test
//	public void queSePuedaEliminarCorrelativasAMateria2() {
//
//		Integer codigoMateria = 2900;
//		Integer codigoMateriaCorrelativa = 3000;
//		Materia pb2 = new Materia("Programmacion basica 2", codigoMateriaCorrelativa);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//		Universidad unlam = new Universidad();
//		Boolean operacion = false;
//
//		unlam.registrarMaterias(tw1);
//		unlam.registrarMaterias(pb2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateriaCorrelativa);
//		operacion = unlam.eliminarCorrelativaDeMateria(codigoMateria, codigoMateriaCorrelativa);
//		int cantidad = tw1.cantidadCorrelativas();
//
//		assertTrue(operacion);
//		assertEquals(cantidad, 0);
//
//	}
//	/////////////////////////////////
//	//Incripcion
//	
//	@Test
//	public void queSePuedaInscribirAlumnoAUnCurso() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		////////////////
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
//
//		Universidad unlam = new Universidad();
//		// Ejecucion
//		unlam.registrarMaterias(materia);
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//
//		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
//				idComision);
//
//		Integer ve = 1;
//		Integer vo = comision.getAlumnos().size();
//		// Evaluacion
//		assertEquals(ve, vo);
//		assertTrue(resultado);
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnaComision() {
//		Integer dniAlumno = 412421, codigoComision = 1;
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision = new Comision(codigoComision);
//		Integer idComision = comision.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarComision(comision);
//
//		Boolean exitoso = unlam.inscribirAlumnoComision(idComision, codigoComision, dniAlumno);
//
//		assertTrue(exitoso);
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnaComisionSiTieneLasCorrelativasAprobadas() {
//		Integer codigoMateria = 2300;
//		Integer codigoMateria1 = 2626;
//		Integer codigoMateria2 = 2500;
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//
//		Integer codigoComision1 = 1;
//		Integer codigoComision2 = 2;
//		Integer codigoComision3 = 3;
//		Integer codigoComision4 = 4;
//
//		Comision comision1 = new Comision(codigoComision1, pb2);
//		Comision comision2 = new Comision(codigoComision2, pw1);
//		Comision comision3 = new Comision(codigoComision3, bdd1);
//		Comision comision4 = new Comision(codigoComision4, tw1);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
//		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
//		Integer idComision1 = comision1.getId();
//		Integer idComision2 = comision2.getId();
//		Integer idComision3 = comision3.getId();
//		Integer idComision4 = comision4.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(tw1);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);
//
//		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcial1, parcial2);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
//				dniAlumno, codigoMateria);
//
//		AsignacionComisionAlumno asign = unlam.buscarAsignacionAlumnoComision(idComision4, codigoComision4, dniAlumno);
//
//		assertNotNull(asign);
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnaComisionSiEstaDentroDeLaFechaDeInscripcion() {
//
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		LocalDate fechaInscripto = LocalDate.of(2023, 8, 1);
//		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
//		Turno turno = Turno.TURNO_MAÑANA;
//		Integer codigoComision = 5000;
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
//		Integer idComision = comision2.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarComision(comision2);
//		unlam.registrarCicloLectivo(ciclo);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
//				dniAlumno, fechaInscripto);
//
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queSePuedaInscribirAlumnoAUnaComisionSiHayCupo() {
//		Integer codigoMateria1 = 2626;
//		Integer dniAlumno = 412421;
//		Integer codigoComision = 3000;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Integer numero = 266;
//		Integer capacidadMax = 50;
//
//		Aula aula = new Aula(numero, capacidadMax);
//
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
//		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
//				dniAlumno);
//
//		assertTrue(operacion);
//
//	}
//	
//	@Test
//	public void queSePuedaInscribirAlumnoAUnaMateriaQueTengaLaCorrelativaAprobadaDIEGO() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		LocalDate fechaDeInscripcionALaComision2 = LocalDate.of(2025, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		Integer IdDeLaAsignacion2 = 2;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		String nombreMateria2 = "PB2";
//		Integer codigoMateria2 = 2;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);
//		materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// ciclo2
//		Integer idCiclo2 = 1;
//		LocalDate fechaDeInicioInscripcion2 = LocalDate.of(2025, 3, 10);
//		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2025, 3, 17);
//		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2025, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2025, 7, 16);
//		Cuatrimestre cuatri2 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
////		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
////				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaFinalizacionCicloLectivo2, fechaInicioCicloLectivo2,
//				fechaDeInicioInscripcion2, fechaFinalizacionInscripcion2, cuatri2);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Integer idComision2 = 2;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
//		Comision comision2 = new Comision(idComision2, day, turno, ciclo2, materia2, aula);
//
//		Universidad unlam = new Universidad();
//
//		// Nota
//		Double valor = 7.0;
//		ClaseDeNota tipo = ClaseDeNota.PRIMER_PARCIAL;
//		ClaseDeNota tipo2 = ClaseDeNota.SEGUNDO_PARCIAL;
//		// Ejecucion
//
//		unlam.registrarMaterias(materia);
//		unlam.registrarMaterias(materia2);
//		Boolean resultado = unlam.agregarCorrelativaAMateria(codigoMateria2, codigoMateria);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarCicloLectivo(ciclo2);
//		unlam.registrarComision(comision);
//		unlam.registrarComision(comision2);
//
//		Boolean resultado2 = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
//				idComision);
//		Integer ve = 1;
//		Integer vo = unlam.getComisionesAlumno().size();
//
//		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
//		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo2);
//
//		Boolean resultado3 = unlam.inscribirAlumnoComision(IdDeLaAsignacion2, dni, fechaDeInscripcionALaComision2,
//				idComision2);
//
//		Integer ve2 = 2;
//		Integer vo2 = unlam.getComisionesAlumno().size();
//
//		// Evaluacion
//		assertEquals(ve, vo);
//		assertTrue(resultado);
//		assertTrue(resultado2);
//		assertTrue(resultado3);
//		assertEquals(ve2, vo2);
//	}
	
//	@Test
//	public void queSePuedaInscribirAUnaComisionPorqueNoSeSuperponeConOtraComisionYSusHorarios() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoComision2 = 2900, codigoComision1 = 2626;
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pb1 = new Materia("Pb1", 2300);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision1.getId();
//
//		Comision comision2 = new Comision(codigoComision2, Dia.MARTES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision2 = comision2.getId();
//		Universidad unlam = new Universidad();
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision1);
//		unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);
//
//		AsignacionComisionAlumno asig = unlam.buscarAsignacionAlumnoComision(idComision2, codigoComision2, 1234);
//
//		assertNotNull(asig);
//		assertTrue(operacion);
//
//	}
//
//	/////////////////////////////////
//	//No Inscripcion
//	
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaComisionPorqueElAlumnoNoEstaRegistrado() {
//		Integer dniAlumno = 412421, codigoComision = 1;
//		Universidad unlam = new Universidad();
//
//		Comision comision = new Comision(codigoComision);
//		Integer idComision = comision.getId();
//
//		unlam.registrarComision(comision);
//
//		Boolean exitoso = unlam.inscribirAlumnoComision(idComision, codigoComision, dniAlumno);
//
//		assertFalse(exitoso);
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaComisionPorqueLaComisionNoEstaRegistrada() {
//		Integer dniAlumno = 412421, codigoComision = 1;
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision = new Comision(codigoComision);
//		Integer idComision = comision.getId();
//
//		unlam.registrarAlumno(alm);
//
//		Boolean exitoso = unlam.inscribirAlumnoComision(idComision, codigoComision, dniAlumno);
//
//		assertFalse(exitoso);
//	}
//
//	@Test
//	public void queNoSePuedaMeterDosVecesAlMismoAlumnoEnUnaComision() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoComision1 = 2626;
//		Materia pb1 = new Materia("Pb1", 2300);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision1.getId();
//		Universidad unlam = new Universidad();
//
//		unlam.registrarAlumno(alumno);
//
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision1);
//		Boolean operacion0 = unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);
//		Boolean operacion = unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);
//		assertTrue(operacion0);
//		assertFalse(operacion);
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaComisionSiNoTieneLasCorrelativasAprobadas() {
//		Integer codigoMateria = 2300;
//		Integer codigoMateria1 = 2626;
//		Integer codigoMateria2 = 2500;
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//		Materia tw1 = new Materia("TALLER WEB1", codigoMateria);
//
//		Integer codigoComision1 = 1;
//		Integer codigoComision2 = 2;
//		Integer codigoComision3 = 3;
//		Integer codigoComision4 = 4;
//
//		Comision comision1 = new Comision(codigoComision1, pb2);
//		Comision comision2 = new Comision(codigoComision2, pw1);
//		Comision comision3 = new Comision(codigoComision3, bdd1);
//		Comision comision4 = new Comision(codigoComision4, tw1);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//
//		Nota parcial1 = new Nota(7.5, TipoNota.PARCIAL_UNO);
//		Nota parcial2 = new Nota(9.5, TipoNota.PARCIAL_DOS);
//		Nota parcialError = new Nota(2.0, TipoNota.PARCIAL_UNO);
//		Integer idComision1 = comision1.getId();
//		Integer idComision2 = comision2.getId();
//		Integer idComision3 = comision3.getId();
//		Integer idComision4 = comision4.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(tw1);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, dniAlumno);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, dniAlumno);
//
//		unlam.evaluarAlumnoComision(idComision1, codigoComision1, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision2, codigoComision2, dniAlumno, parcial1, parcial2);
//		unlam.evaluarAlumnoComision(idComision3, codigoComision3, dniAlumno, parcialError, parcial2);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionConCorrelativasAprobadas(idComision4, codigoComision4,
//				dniAlumno, codigoMateria);
//
//		assertFalse(operacion);
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoDosVecesAlUnCursoDelMismoCiclo() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		Integer dni2 = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		Alumno alumno2 = new Alumno(dni2, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		////////////////
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
//
//		Universidad unlam = new Universidad();
//		// Ejecucion
//		unlam.registrarMaterias(materia);
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//
//		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
//				idComision);
//		Boolean resultado2 = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni2, fechaDeInscripcionALaComision,
//				idComision);
//
//		Integer ve = 1;
//		Integer vo = comision.getAlumnos().size();
//		// Evaluacion
//		assertEquals(ve, vo);
//		assertTrue(resultado);
//		assertFalse(resultado2);
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaComisionSiEstaFueraDeLaFechaDeInscripcion() {
//
//		Integer codigoMateria3 = 2600;
//		Integer dniAlumno = 412421;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		LocalDate fechaInscripto = LocalDate.of(2024, 8, 1);
//		Cuatrimestre cuatri = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, cuatri);
//		Turno turno = Turno.TURNO_MAÑANA;
//		Integer codigoComision = 5000;
//		Materia bdd1 = new Materia("Bdd1", codigoMateria3);
//
//		Universidad unlam = new Universidad();
//		Alumno alm = new Alumno(dniAlumno, "F", "G");
//		Comision comision2 = new Comision(codigoComision, turno, ciclo, bdd1);
//		Integer idComision = comision2.getId();
//
//		unlam.registrarAlumno(alm);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarComision(comision2);
//		unlam.registrarCicloLectivo(ciclo);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionSiSeInscribioDentroDeLasFechas(idComision, codigoComision,
//				dniAlumno, fechaInscripto);
//
//		assertFalse(operacion);
//
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaComisionSiEstaElCupoLLeno() {
//		Integer codigoMateria1 = 2626;
//		Integer dniAlumno = 412421;
//		Integer codigoComision = 3000;
//
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Integer numero = 266;
//		Integer capacidadMax = 1;
//
//		Aula aula = new Aula(numero, capacidadMax);
//
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 1);
//		LocalDate fechaDeInicioInscripcion = LocalDate.of(2023, 7, 28);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 5);
//		CicloLectivo ciclo = new CicloLectivo(fechaFinalizacionCicloLectivo, fechaInicioCicloLectivo,
//				fechaDeInicioInscripcion, fechaFinalizacionInscripcion, Cuatrimestre.PRIMER_CUATRIMESTRE);
//		Comision comision = new Comision(codigoComision, ciclo, pb2, aula);
//
//		Universidad unlam = new Universidad();
//		Alumno alm1 = new Alumno(543423333, "F", "G");
//		Alumno alm2 = new Alumno(dniAlumno, "F", "G");
//
//		unlam.registrarAlumno(alm1);
//		unlam.registrarAlumno(alm2);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//		unlam.asignarAulaAComision(comision.getId(), codigoComision, aula);
//		unlam.inscribirAlumnoComision(comision.getId(), codigoComision, 543423333);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoCapacidadAula(comision.getId(), codigoComision,
//				dniAlumno);
//
//		assertFalse(operacion);
//
//	}
//
//	@Test
//	public void queNoSePuedaInscribirAlumnoAUnaMateriaQueDebeLaCorrelativa() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		String nombreMateria2 = "PB2";
//		Integer codigoMateria2 = 2;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//		Materia materia2 = new Materia(nombreMateria2, codigoMateria2);
//		materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		////////////////
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia2, aula);
//
//		Universidad unlam = new Universidad();
//		Materia materiaBuscada = null;
//		Materia materiaBuscada2 = null;
//		// Ejecucion
//
//		unlam.registrarMaterias(materia);
//		unlam.registrarMaterias(materia2);
//		Boolean resultado2 = unlam.agregarCorrelativaAMateria(codigoMateria2,codigoMateria);
//		materiaBuscada = unlam.buscarMateria(codigoMateria);
//		materiaBuscada2 = unlam.buscarMateria(codigoMateria2);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//
//		Boolean resultado = unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision,
//				idComision);
//
//		Integer ve = 0;
//		Integer vo = comision.getAlumnos().size();
//		// Evaluacion
//		assertTrue(resultado2);
//		assertFalse(resultado);
//		assertNotNull(materiaBuscada);
//		assertNotNull(materiaBuscada2);
//		assertEquals(ve, vo);
//	}
//
//	@Test
//	public void queNoPuedaInscribirseAUnaComisionPorqueSeSuperponeConOtraComisionYSusHorarios() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoComision = 2626;
//		Materia pb2 = new Materia("Pb2", codigoMateria1);
//		Materia pb1 = new Materia("Pb1", 2300);
//
//		Comision comision = new Comision(codigoComision, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision.getId();
//		Comision comision2 = new Comision(2900, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//
//		Universidad unlam = new Universidad();
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision);
//
//		unlam.inscribirAlumnoComision(idComision, codigoComision, 1234);
//
//		Boolean operacion = unlam.inscribirAlumnoComisionVerificandoQueNoSeSuperpongan(1234, comision2);
//
//		assertFalse(operacion);
//	}
//	
//	/////////////////////////////////
//	//Notas y valores
//
//	@Test
//	public void queSeLePuedaEvaluarAUnAlumno() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//		materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		////////////////
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
//
//		Universidad unlam = new Universidad();
//		Materia materiaBuscada = null;
//
//		// Nota
//		Double valor = 7.0;
//		ClaseDeNota tipo = ClaseDeNota.PRIMER_PARCIAL;
//		ClaseDeNota tipo2 = ClaseDeNota.SEGUNDO_PARCIAL;
//		// Ejecucion
//
//		unlam.registrarMaterias(materia);
//		materiaBuscada = unlam.buscarMateria(codigoMateria);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//
//		unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision, idComision);
//
//		Boolean resultado = unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
//		AsignacionComisionAlumno buscado = unlam.buscarAsignacionAlumnoComision(IdDeLaAsignacion);
//		ClaseDeNota nota = buscado.getNotas().get(0).getTipoDeNota();
//
//		Integer ve = 1;
//		Integer vo = comision.getAlumnos().size();
//		Integer voAsignacion = unlam.getComisionesAlumno().size();
//		// Evaluacion
//		assertTrue(resultado);
//		assertNotNull(materiaBuscada);
//		assertEquals(ve, voAsignacion);
//		assertEquals(tipo, nota);
//	}
//
//	@Test
//	public void queSePuedaRegistrarUnaNotaEnAsignacionComisionAlumno() {
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoMateria2 = 2627, codigoMateria3 = 4321, codigoComision2 = 2900,
//				codigoComision1 = 2626;
//		Materia pb1 = new Materia("pb1", codigoMateria1);
//		// Materia pb2 = new Materia("Programacion basica 2", codigoMateria1);
//		// Materia tw1 = new Materia("Programacion Web 1", codigoMateria2);
//		// Materia bdd1= new Materia("Base de datos 1", codigoMateria3);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb1);
//		Integer idComision = comision1.getId();
//		Universidad unlam = new Universidad();
//
//		Nota nota = new Nota(10.0, TipoNota.PARCIAL_UNO);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarMaterias(pb1);
//		unlam.registrarComision(comision1);
//		unlam.inscribirAlumnoComision(idComision, codigoComision1, 1234);
//
//		Boolean operacion = unlam.registrarNota(idComision, codigoComision1, 1234, nota);
//
//		TipoNota tipo = TipoNota.PARCIAL_UNO;
//
//		assertTrue(operacion);
//
//	}
//
//	@Test
//	public void queSePuedaRegistrarUnaNotaEnAsignacionComisionAlumnoCompletoSiTieneCorrelativasAprobadas() {
//
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoMateria2 = 2627, codigoMateria3 = 4321, codigoMateria4 = 4124,
//				codigoComision1 = 2626, codigoComision2 = 2112, codigoComision3 = 4122, codigoComision4 = 2900;
//
//		Materia pb2 = new Materia("Programacion basica 2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Base de datos 1", codigoMateria3);
//		Materia tw1 = new Materia("Taller Web 1", codigoMateria4);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision1 = comision1.getId();
//
//		Comision comision2 = new Comision(codigoComision2, Dia.JUEVES, Turno.TURNO_MAÑANA, bdd1);
//		Integer idComision2 = comision2.getId();
//
//		Comision comision3 = new Comision(codigoComision3, Dia.JUEVES, Turno.TURNO_MAÑANA, pw1);
//		Integer idComision3 = comision3.getId();
//
//		Comision comision4 = new Comision(codigoComision4, Dia.JUEVES, Turno.TURNO_MAÑANA, tw1);
//		Integer idComision4 = comision4.getId();
//
//		Universidad unlam = new Universidad();
//
//		Nota nota = new Nota(10.0, TipoNota.PARCIAL_UNO);
//		Nota nota2 = new Nota(10.0, TipoNota.PARCIAL_DOS);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(tw1);
//
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, 1234);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, 1234);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, 1234);
//		unlam.inscribirAlumnoComision(idComision4, codigoComision4, 1234);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota2);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota2);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota2);
//		Boolean operacion1 = unlam.registrarNota(idComision4, codigoComision4, 1234, nota);
//		Boolean operacion2 = unlam.registrarNota(idComision4, codigoComision4, 1234, nota2);
//
//		assertTrue(operacion1);
//		assertTrue(operacion2);
//
//	}
//
//	@Test
//	public void queSePuedaRegistrarUnaNotaEnAsignacionComisionAlumnoCompletoConCorrelativasDesaprobadasYSuNotaMaximaSea6() {
//
//		Alumno alumno = new Alumno(1234, "f", "g");
//		Integer codigoMateria1 = 2500, codigoMateria2 = 2627, codigoMateria3 = 4321, codigoMateria4 = 4124,
//				codigoComision1 = 2626, codigoComision2 = 2112, codigoComision3 = 4122, codigoComision4 = 2900;
//
//		Materia pb2 = new Materia("Programacion basica 2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Base de datos 1", codigoMateria3);
//		Materia tw1 = new Materia("Taller Web 1", codigoMateria4);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision1 = comision1.getId();
//
//		Comision comision2 = new Comision(codigoComision2, Dia.JUEVES, Turno.TURNO_MAÑANA, bdd1);
//		Integer idComision2 = comision2.getId();
//
//		Comision comision3 = new Comision(codigoComision3, Dia.JUEVES, Turno.TURNO_MAÑANA, pw1);
//		Integer idComision3 = comision3.getId();
//
//		Comision comision4 = new Comision(codigoComision4, Dia.JUEVES, Turno.TURNO_MAÑANA, tw1);
//		Integer idComision4 = comision4.getId();
//
//		Universidad unlam = new Universidad();
//
//		Nota nota = new Nota(6.0, TipoNota.PARCIAL_UNO);
//		Nota nota2 = new Nota(5.0, TipoNota.PARCIAL_DOS);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(tw1);
//
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, 1234);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, 1234);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, 1234);
//		unlam.inscribirAlumnoComision(idComision4, codigoComision4, 1234);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota2);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota2);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota2);
//		Nota nota4 = new Nota(10.0, TipoNota.PARCIAL_UNO);
//		Nota nota5 = new Nota(10.0, TipoNota.PARCIAL_DOS);
//		unlam.registrarNota(idComision4, codigoComision4, 1234, nota4);
//		unlam.registrarNota(idComision4, codigoComision4, 1234, nota5);
//
//		AsignacionComisionAlumno asignacion = unlam.buscarAsignacionAlumnoComision(idComision4, codigoComision4, 1234);
//		Double valor = asignacion.getParcial1().getValor();
//		Double valor1 = asignacion.getParcial2().getValor();
//		Double valorEsperado = 6.0;
//		assertEquals(valor, valorEsperado);
//		assertEquals(valor1, valorEsperado);
//	}
//	
//	@Test
//	public void queSeLePuedaEvaluarElPromedioFinalDeUnAlumno() {
//		// Preparacion
//		LocalDate fechaDeInscripcionALaComision = LocalDate.of(2024, 3, 11);
//		Integer IdDeLaAsignacion = 1;
//		// Materia
//		String nombreMateria = "PB1";
//		Integer codigoMateria = 1;
//
//		Materia materia = new Materia(nombreMateria, codigoMateria);
//		materia = new Materia(nombreMateria, codigoMateria);
//
//		// Alumno
//		Integer dni = 123;
//		String nombre = "Diego";
//		String apellido = "Oliva";
//
//		// fechas
//		LocalDate fechaDeNacimiento = LocalDate.of(2021, 7, 28);
//		LocalDate fechaDeInscripcion = LocalDate.of(2024, 3, 11);
//
//		Alumno alumno = new Alumno(dni, nombre, apellido, fechaDeNacimiento, fechaDeInscripcion);
//		////////////////
//		// Aula
//		Integer Id_Aula = 1;
//		Integer cantidadMaximaAlumnos = 5;
//
//		Aula aula = new Aula(Id_Aula, cantidadMaximaAlumnos);
//
//		// Ciclo
//		Integer idCiclo = 0;
//		LocalDate fechaDeInicioInscripcion1 = LocalDate.of(2024, 3, 10);
//		LocalDate fechaFinalizacionInscripcion1 = LocalDate.of(2024, 3, 17);
//		LocalDate fechaInicioCicloLectivo1 = LocalDate.of(2024, 4, 14);
//		LocalDate fechaFinalizacionCicloLectivo1 = LocalDate.of(2024, 7, 16);
//		Cuatrimestre cuatri1 = Cuatrimestre.PRIMER_CUATRIMESTRE;
//
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaFinalizacionCicloLectivo1, fechaInicioCicloLectivo1,
//				fechaDeInicioInscripcion1, fechaFinalizacionInscripcion1, cuatri1);
//
//		// Tiempo
//		Turno turno = Turno.TURNO_MAÑANA;
//		Dia day = Dia.LUNES;
//
//		// Comision
//		Integer idComision = 1;
//		Comision comision = new Comision(idComision, day, turno, ciclo, materia, aula);
//
//		Universidad unlam = new Universidad();
//		Materia materiaBuscada = null;
//
//		// Nota
//		Double valor = 7.0;
//		ClaseDeNota tipo = ClaseDeNota.PRIMER_PARCIAL;
//		ClaseDeNota tipo2 = ClaseDeNota.SEGUNDO_PARCIAL;
//		// Ejecucion
//
//		unlam.registrarMaterias(materia);
//
//		unlam.registrarAlumno(alumno);
//		unlam.registrarAula(aula);
//		unlam.registrarCicloLectivo(ciclo);
//		unlam.registrarComision(comision);
//
//		unlam.inscribirAlumnoComision(IdDeLaAsignacion, dni, fechaDeInscripcionALaComision, idComision);
//
//		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo);
//		unlam.evaluarAlumnoComision(IdDeLaAsignacion, valor, tipo2);
//		AsignacionComisionAlumno buscado = unlam.buscarAsignacionAlumnoComision(IdDeLaAsignacion);
//		ClaseDeNota nota = buscado.getNotas().get(0).getTipoDeNota();
//		ClaseDeNota nota2 = buscado.getNotas().get(1).getTipoDeNota();
//
//		Double ve = 7.0;
//		Double valorObtenido = unlam.promedioFinal(IdDeLaAsignacion);
//		// Evaluacion
//		assertEquals(tipo, nota);
//		assertEquals(tipo2, nota2);
//		assertEquals(ve, valorObtenido);
//	}
//
//	/////////////////////////////////
//	
//	//OTROS
//
//	@Test
//	public void queSeAsignenProfesAUnaComision() {
//
//		Integer codigoMateria1 = 2500, codigoComision1 = 2626;
//
//		Materia pb2 = new Materia("Programacion basica 2", codigoMateria1);
//
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision1 = comision1.getId();
//		Profesor profe = new Profesor(1234, "juan", "z", 0.0);
//		Profesor profe2 = new Profesor(123, "juan", "z", 0.0);
//		Profesor profe3 = new Profesor(12345, "juan", "z", 0.0);
//		Universidad unlam = new Universidad();
//		unlam.registrarProfesor(profe);
//		unlam.registrarProfesor(profe2);
//		unlam.registrarProfesor(profe3);
//		unlam.registrarComision(comision1);
//		unlam.inscribirProfesoresAComision(idComision1, codigoComision1);
//
//		Integer cantProfes = comision1.obtenerCantidadDeProfes();
//		Integer ve = 2;
//
//		assertEquals(cantProfes, ve);
//	}
//	
//	@Test
//	public void obtenerLaListaDeMateriasQueLeFaltanCursarAUnAlumno() {
//		Integer dniAlumno = 1234;
//		Alumno alumno = new Alumno(dniAlumno, "f", "g");
//		Integer codigoMateria1 = 2500, codigoMateria2 = 2627, codigoMateria3 = 4321, codigoMateria4 = 4124,
//				codigoComision1 = 2626, codigoComision2 = 2112, codigoComision3 = 4122, codigoComision4 = 2900;
//		
//		Materia pb2 = new Materia("Programacion basica 2", codigoMateria1);
//		Materia pw1 = new Materia("Pw1", codigoMateria2);
//		Materia bdd1 = new Materia("Base de datos 1", codigoMateria3);
//		Materia tw1 = new Materia("Taller Web 1", codigoMateria4);
//		// maaterias q faltan
//		Materia pw2 = new Materia("Programacion web2", 5555);
//		Materia ddaw = new Materia("Diseños de Aplicaciones Web", 7774);
//		Materia vei = new Materia("Visualizaciones e Interfaces", 5235);
//		Materia bdd2 = new Materia("Base de datos 2", 5112);
//		
//		Comision comision1 = new Comision(codigoComision1, Dia.JUEVES, Turno.TURNO_MAÑANA, pb2);
//		Integer idComision1 = comision1.getId();
//		
//		Comision comision2 = new Comision(codigoComision2, Dia.JUEVES, Turno.TURNO_MAÑANA, bdd1);
//		Integer idComision2 = comision2.getId();
//		
//		Comision comision3 = new Comision(codigoComision3, Dia.JUEVES, Turno.TURNO_MAÑANA, pw1);
//		Integer idComision3 = comision3.getId();
//		
//		Comision comision4 = new Comision(codigoComision4, Dia.JUEVES, Turno.TURNO_MAÑANA, tw1);
//		Integer idComision4 = comision4.getId();
//		
//		Universidad unlam = new Universidad();
//		
//		Nota nota = new Nota(10.0, TipoNota.PARCIAL_UNO);
//		Nota nota2 = new Nota(10.0, TipoNota.PARCIAL_DOS);
//		ArrayList<Materia> planDeEstudio = new ArrayList<>();
//		planDeEstudio.add(pb2);
//		planDeEstudio.add(pw1);
//		planDeEstudio.add(bdd1);
//		planDeEstudio.add(tw1);
//		planDeEstudio.add(pw2);
//		planDeEstudio.add(ddaw);
//		planDeEstudio.add(vei);
//		planDeEstudio.add(bdd2);
//		
//		unlam.registrarAlumno(alumno);
//		unlam.registrarComision(comision1);
//		unlam.registrarComision(comision2);
//		unlam.registrarComision(comision3);
//		unlam.registrarComision(comision4);
//		unlam.registrarMaterias(pb2);
//		unlam.registrarMaterias(bdd1);
//		unlam.registrarMaterias(pw1);
//		unlam.registrarMaterias(tw1);
//		
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria1);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria2);
//		unlam.agregarCorrelativaAMateria(codigoMateria4, codigoMateria3);
//		unlam.inscribirAlumnoComision(idComision1, codigoComision1, 1234);
//		unlam.inscribirAlumnoComision(idComision2, codigoComision2, 1234);
//		unlam.inscribirAlumnoComision(idComision3, codigoComision3, 1234);
//		unlam.inscribirAlumnoComision(idComision4, codigoComision4, 1234);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota);
//		unlam.registrarNota(idComision1, codigoComision1, 1234, nota2);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota);
//		unlam.registrarNota(idComision2, codigoComision2, 1234, nota2);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota);
//		unlam.registrarNota(idComision3, codigoComision3, 1234, nota2);
//		unlam.registrarNota(idComision4, codigoComision4, 1234, nota);
//		unlam.registrarNota(idComision4, codigoComision4, 1234, nota2);
//		
//		ArrayList<Materia> planDeEstudio1 = unlam.obtenerListaMateriasPorCursar(planDeEstudio, dniAlumno);
//		planDeEstudio.remove(pb2);
//		planDeEstudio.remove(pw1);
//		planDeEstudio.remove(bdd1);
//		planDeEstudio.remove(tw1);
//		
//		assertEquals(planDeEstudio, planDeEstudio1);
//		
//	}

	////////////////////////////////

}
