package br.com.devmedia.editora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmedia.editora.dao.EditoraDao;
import br.com.devmedia.editora.entity.Editora;

@RestController
public class EditoraController {
	
	@Autowired
	private EditoraDao dao;

	@RequestMapping("/")
	public String hello() {
		return "Hello Word";
	}
	
	@RequestMapping("/editoras")
	public List<Editora> getEditoras(){
		return dao.findAll();
	}
	
	@RequestMapping("/editora/{id}")
	public Editora getEditora(@PathVariable Integer id){
		return dao.findById(id);
	}
	
	@RequestMapping("/editora/{id}/{page}")
	public Editora getEditoraWithAutor(@PathVariable Integer id, @PathVariable Integer page){
		return dao.findEditoraWithAutores(id, page, 2);
	}
	
}
