package br.com.devmedia.appfinal.entity;

public class Cargo {

	private Integer idCargo;

	private String cargo;

	private Departamento departamento;

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", cargo=" + cargo + ", departamento=" + departamento + "]";
	}

}
