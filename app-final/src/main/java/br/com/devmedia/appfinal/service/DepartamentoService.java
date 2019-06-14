package br.com.devmedia.appfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmedia.appfinal.dao.DepartamentoDao;
import br.com.devmedia.appfinal.entity.Departamento;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoDao dao;

	public Departamento save(Departamento departamento) {
		return dao.save(departamento);
	}

	public void update(Departamento departamento) {
		dao.update(departamento);
	}

	public void saveOrUpdate(Departamento departamento) {
		if (departamento.getIdDepartamento() == null) {
			dao.save(departamento);
		} else {
			dao.update(departamento);
		}
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public Departamento findById(Integer id) {
		return dao.findById(id);
	}

	public List<Departamento> findAll() {
		return dao.findAll();
	}
}
