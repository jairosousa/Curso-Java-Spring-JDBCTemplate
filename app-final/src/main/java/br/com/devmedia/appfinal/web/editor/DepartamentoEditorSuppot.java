package br.com.devmedia.appfinal.web.editor;

import java.beans.PropertyEditorSupport;

import br.com.devmedia.appfinal.entity.Departamento;
import br.com.devmedia.appfinal.service.DepartamentoService;

public class DepartamentoEditorSuppot extends PropertyEditorSupport {

	private DepartamentoService service;

	public DepartamentoEditorSuppot(DepartamentoService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!text.isEmpty()) {
			Integer id = Integer.parseInt(text);

			Departamento departamento = service.findById(id);

			super.setValue(departamento);

		}
	}

}
