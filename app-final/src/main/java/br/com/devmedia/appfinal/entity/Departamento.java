package br.com.devmedia.appfinal.entity;

public class Departamento {

	private Integer idDepartamento;

	private String departamento;

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Departemanto [idDepartamento=" + idDepartamento + ", departamento=" + departamento + "]";
	}

}
