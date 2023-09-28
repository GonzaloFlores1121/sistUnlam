package ar.unlam.materia;

import java.util.ArrayList;
import java.util.Objects;

public class Comision {
	private static Integer idComisiones = 0;
//	private Integer id;
	private Integer codigo_comision;

	// Tiempo
	private Dia dia;
	private Turno turno;
	private CicloLectivo ciclo;
	// Materia
	private Materia materia;
	// Aula
	private Aula aula;
	// Personas
	private ArrayList<Profesor> profes;
	private ArrayList<Alumno> alumnos;

	// Constructor diego
	public Comision(Integer codigo_comision, Dia dia, Turno turno, CicloLectivo ciclo, Materia materia, Aula aula) {
//		this.id = ++idComisiones;
		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
		this.aula = aula;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}
	
	// Constructor diego con id estatico
	public Comision( Dia dia, Turno turno, CicloLectivo ciclo, Materia materia, Aula aula) {
		this.codigo_comision = ++idComisiones;
//		this.codigo_comision = codigo_comision;
		this.dia = dia;
		this.turno = turno;
		this.ciclo = ciclo;
		this.materia = materia;
		this.aula = aula;
		this.profes = new ArrayList<>();
		this.alumnos = new ArrayList<>();
	}

	public Comision(Integer codigoCurso) {
		this.codigo_comision=codigoCurso;
		this.aula=null;
	}

	// Getters
	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public Dia getDia() {
		return dia;
	}

	public Turno getTurno() {
		return turno;
	}

	public CicloLectivo getCiclo() {
		return ciclo;
	}

	public Materia getMateria() {
		return materia;
	}

	public Aula getAula() {
		return aula;
	}

	public ArrayList<Profesor> getProfes() {
		return profes;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public Boolean inscribirProfesor(Profesor profe) {
		Boolean resultado = false;
		if (!profes.contains(profe) && !this.alumnos.isEmpty()) {
			if (this.profes.size() < this.cantidadDeProfesPorAula()) {
				profes.add(profe);
				resultado = true;
			}
		}
		return resultado;
	}

	public Integer cantidadDeProfesPorAula() {
		Integer cantidadDeProfes = 1;
		Integer cantidadDeAlumnosXProfe = 2;//aca deberia ir 1 por cada 20 alumnos
	
		if(!this.alumnos.isEmpty() && this.alumnos.size()>=cantidadDeAlumnosXProfe) {
			cantidadDeProfes=this.alumnos.size()/cantidadDeAlumnosXProfe;
		}

		return cantidadDeProfes;
	}

	public Boolean inscribirAlumno(Alumno alumno) {
		Boolean resultado = false;
		if (!this.alumnos.contains(alumno) && this.cantidadDeAlumnos() < this.aula.getCapacidadMax()) {
			this.alumnos.add(alumno);
			resultado = true;
		}
		return resultado;
	}

	public Integer cantidadDeProfesores() {
		Integer cantidad = this.profes.size();
		return cantidad;
	}

	public Integer cantidadDeAlumnos() {
		Integer cantidadAlumnos = this.alumnos.size();
		return cantidadAlumnos;
	}
	
	public void setAula(Aula aulaNueva) {
		this.aula=aulaNueva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aula, ciclo, codigo_comision, dia, materia, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(ciclo, other.ciclo) && dia == other.dia
				&& turno == other.turno || Objects.equals(codigo_comision, other.codigo_comision);
	}

	@Override
	public String toString() {
		return "Comision [codigo_comision=" + codigo_comision + ", dia=" + dia + ", turno=" + turno + ", ciclo=" + ciclo
				+ ", materia=" + materia + ", aula=" + aula + ", profes=" + profes + ", alumnos=" + alumnos + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Comision other = (Comision) obj;
//		return Objects.equals(id, other.id);
//	}

//	@Override
//	public String toString() {
//		return "Comision [id=" + id + ", codigo_comision=" + codigo_comision + ", dia=" + dia + ", turno=" + turno
//				+ ", ciclo=" + ciclo + ", materia=" + materia + ", aula=" + aula + ", profes=" + profes + ", alumnos="
//				+ alumnos + "]";
//	}

//	
//	CONSTRUCTORES
//	public Comision(Integer codigo_comision, Dia dia, Turno turno, CicloLectivo ciclo, Materia materia, Aula aula) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.dia = dia;
//		this.turno = turno;
//		this.ciclo = ciclo;
//		this.materia = materia;
//		this.aula = aula;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigo_comision, Turno turno, CicloLectivo ciclo, Materia materia) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.turno = turno;
//		this.ciclo = ciclo;
//		this.materia = materia;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigo_comision, Dia dia, Turno turno, Materia materia) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.dia = dia;
//		this.turno = turno;
//		this.materia = materia;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigo_comision, Materia materia) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.materia = materia;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigo_comision, CicloLectivo ciclo, Materia materia) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.ciclo = ciclo;
//		this.materia = materia;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigoCurso) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigoCurso;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//	}
//
//	public Comision(Integer codigo_comision, CicloLectivo ciclo, Materia materia, Aula aula) {
//		this.id = ++idComisiones;
//		this.codigo_comision = codigo_comision;
//		this.ciclo = ciclo;
//		this.materia = materia;
//		this.aula = aula;
//		this.profes = new ArrayList<>();
//		this.alumnos = new ArrayList<>();
//
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}

//	public Integer getId() {
//		return id;
//	}

}
