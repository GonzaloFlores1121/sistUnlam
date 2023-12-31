package ar.unlam.materia;

import java.util.Objects;

public class AsignacionComisionProfe {
	private Integer idAsignacionComision;
	private Integer codigo_comision;
	private Integer dniProfesor;
	private static int id=1;

	public AsignacionComisionProfe(Integer idAsignacionComision,Integer codigo_comision, Integer dniProfesor) {
		this.idAsignacionComision=idAsignacionComision;
		this.codigo_comision = codigo_comision;
		this.dniProfesor = dniProfesor;
	}
	
	public AsignacionComisionProfe(Integer codigo_comision, Integer dniProfesor) {
		this.idAsignacionComision=id++;
		this.codigo_comision = codigo_comision;
		this.dniProfesor = dniProfesor;
	}

	public Integer getIdComision() {
		return idAsignacionComision;
	}

	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public Integer getDniProfesor() {
		return dniProfesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_comision, dniProfesor, idAsignacionComision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionComisionProfe other = (AsignacionComisionProfe) obj;
		return Objects.equals(codigo_comision, other.codigo_comision) && Objects.equals(dniProfesor, other.dniProfesor)
				|| Objects.equals(idAsignacionComision, other.idAsignacionComision);
	}

	
}
