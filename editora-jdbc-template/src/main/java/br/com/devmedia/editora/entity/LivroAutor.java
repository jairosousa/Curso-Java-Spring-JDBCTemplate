package br.com.devmedia.editora.entity;

import java.util.ArrayList;
import java.util.List;

public class LivroAutor {
	private Integer idLivroAutor;
	
	private Integer idLivro;
	
	private Integer idAutor;
	
	private List<Autor> autores = new ArrayList<>();

	public LivroAutor() {
	}

	public LivroAutor(Integer idLivro, Integer idAutor) {
		super();
		this.idLivro = idLivro;
		this.idAutor = idAutor;
	}

	public Integer getIdLivroAutor() {
		return idLivroAutor;
	}

	public void setIdLivroAutor(Integer idLivroAutor) {
		this.idLivroAutor = idLivroAutor;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		return "LivroAutor [idLivroAutor=" + idLivroAutor + ", idLivro=" + idLivro + ", idAutor=" + idAutor + "]";
	}

}
