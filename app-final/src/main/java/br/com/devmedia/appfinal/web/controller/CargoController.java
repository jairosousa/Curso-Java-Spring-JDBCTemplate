package br.com.devmedia.appfinal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.appfinal.entity.Cargo;
import br.com.devmedia.appfinal.entity.Departamento;
import br.com.devmedia.appfinal.service.CargoService;
import br.com.devmedia.appfinal.service.DepartamentoService;
import br.com.devmedia.appfinal.web.editor.DepartamentoEditorSuppot;

@Controller
@RequestMapping("cargo")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentosService;

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Departamento.class, new DepartamentoEditorSuppot(departamentosService));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView findAll(@ModelAttribute("cargo") Cargo cargo, ModelMap model) {
		model.addAttribute("cargos", cargoService.findAll());
		model.addAttribute("departamentos", departamentosService.findAll());

		return new ModelAndView("addCargo", model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("cargo") Cargo cargo) {
		cargoService.saveOrUpdate(cargo);

		return "redirect:/cargo/add";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView preUpdate(@PathVariable("id") Integer id) {

		Cargo cargo = cargoService.findById(id);

		ModelAndView model = new ModelAndView();
		model.setViewName("addCargo");
		model.addObject("cargo", cargo);
		model.addObject("cargos", cargoService.findAll());
		model.addObject("departamentos", departamentosService.findAll());

		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		cargoService.delete(id);
		return "redirect:/cargo/add";
	}

}
