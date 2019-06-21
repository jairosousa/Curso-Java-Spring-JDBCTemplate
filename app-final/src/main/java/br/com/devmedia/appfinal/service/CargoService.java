package br.com.devmedia.appfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmedia.appfinal.dao.CargoDao;
import br.com.devmedia.appfinal.entity.Cargo;
import br.com.devmedia.appfinal.entity.Departamento;

@Service
public class CargoService {

	@Autowired
	private CargoDao dao;

	public void saveOrUpdate(Cargo cargo) {
		if (cargo.getIdCargo() == null) {
			dao.save(cargo);
		} else {
			dao.update(cargo);
		}
	}

	public void delete(Integer id) {
		dao.delete(id);
	}

	public Cargo findById(Integer id) {
		return dao.findById(id);
	}

	public List<Cargo> findAll() {
		return dao.findAll();
	}

}
