package ar.unlam.materia;

import java.util.Objects;

public class AsignacionComisionProfe {
	private Integer idComision;
	private Integer codigo_comision;
	private Integer dniProfesor;

	public AsignacionComisionProfe(Integer idComision,Integer codigo_comision, Integer dniProfesor) {
		this.idComision=idComision;
		this.codigo_comision = codigo_comision;
		this.dniProfesor = dniProfesor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_comision, dniProfesor);
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
		return Objects.equals(codigo_comision, other.codigo_comision) && Objects.equals(dniProfesor, other.dniProfesor);
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Integer getCodigo_comision() {
		return codigo_comision;
	}

	public void setCodigo_comision(Integer codigo_comision) {
		this.codigo_comision = codigo_comision;
	}

	public Integer getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(Integer dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	
}
