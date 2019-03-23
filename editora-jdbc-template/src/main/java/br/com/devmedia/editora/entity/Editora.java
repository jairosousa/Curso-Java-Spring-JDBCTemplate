package br.com.devmedia.editora.entity;

import java.util.ArrayList;
import java.util.List;

public class Editora {

	private Integer id;
	private String razaoSocial;
	private String cidade;
	private String email;
	private List<Autor> autores = new ArrayList<Autor>();

	public Editora() {
	}

	public Editora(String razaoSocial, String cidade, String email) {
		this.razaoSocial = razaoSocial;
		this.cidade = cidade;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "Editora [id=" + id + ", razaoSocial=" + razaoSocial + ", cidade=" + cidade + ", email=" + email
				+ ", autores=" + autores + "]";
	}

}
