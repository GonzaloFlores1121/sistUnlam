package ar.unlam.materia;

public class AsignacionCursoProfe {
	
	private Integer codigo_curso;
	private Integer dniProfesor;

	public AsignacionCursoProfe(Integer codigo_curso, Integer dniProfesor) {
		
		this.codigo_curso=codigo_curso;
		this.dniProfesor=dniProfesor;
				
	}

	@Override
	public String toString() {
		return "AsignacionCursoProfe [codigo_curso=" + codigo_curso + ", dniProfesor=" + dniProfesor + "]";
	}

}
