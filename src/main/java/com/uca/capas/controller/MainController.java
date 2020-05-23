package com.uca.capas.controller;

import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService estudianteService;
	

	@RequestMapping("/inicio")
	public ModelAndView index() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}

	// Show students list
	@RequestMapping(value = "/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("estudiantes", listEstudiantes());
		mav.setViewName("listado");

		return mav;

	}

	@RequestMapping("/insert")
	public ModelAndView insert(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudianteClean = new Estudiante();
		
		if (result.hasErrors()) {
			mav.addObject("estudiante", estudiante);
		}else {
			estudianteService.insert(estudiante);
			mav.addObject("estudiante", estudianteClean);
		}
		
		mav.setViewName("index");
		return mav;
		
	}
	
	@RequestMapping(value = "/borrarEstudiante",method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id) throws ParseException {
		ModelAndView mav = new ModelAndView();
		estudianteService.delete(id);
		mav.addObject("estudiantes",listEstudiantes());
		mav.setViewName("listado");
		
		return mav;
		
	}
	
public List<Estudiante> listEstudiantes(){
		
		
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return estudiantes;
	}
}
