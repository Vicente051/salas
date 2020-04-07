package com.tweb.salas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VistaControlador {
	
	String nombre, ruta;
	
	@RequestMapping({"/", "/inicio"})
	public String inicio(Model model) {
		nombre = "Inicio";
		model.addAttribute("nombrePestana", nombre);
		ruta = "inicio.jsp";
		model.addAttribute("ruta", ruta);
		return "index";
	}
	
	
	
	
	
	@RequestMapping("/eventos")
	public String eventos(Model model) {
		nombre = "Enevtos";
		model.addAttribute("nombrePestana", nombre);
		return "/secciones/eventos";
	}
	
	@RequestMapping("/addEvento")
	public String addEvento(Model model) {
		nombre = "Eventos";
		model.addAttribute("nombrePestana", nombre);
		return "addEvento";
	}

	@RequestMapping("/añadirEvento")
	public String añadirEvento(Model model) {
		nombre = "Eventos";
		model.addAttribute("nombrePestana", nombre);
		return "guardado";
	}
	
	@RequestMapping("/editEvento")
	public String editEvento(Model model) {
		nombre = "Eventos";
		model.addAttribute("nombrePestana", nombre);
		return "editEvento";
	}
	
	@RequestMapping("/guardarEvento")
	public String guardarEvento(Model model) {
		nombre = "Eventos";
		model.addAttribute("nombrePestana", nombre);
		return "guardado";
	}
	
	@RequestMapping("/vivo")
	public String vivo(Model model) {
		nombre = "En vivo";
		model.addAttribute("nombrePestana", nombre);
		return "/secciones/vivo";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		nombre = "Perfil";
		model.addAttribute("nombrePestana", nombre);
		return "/secciones/perfil";
	}
	
	@RequestMapping("/admin")
	public String admin(Model model) {
		nombre = "Administración";
		model.addAttribute("nombrePestana", nombre);
		return "/secciones/admin";
	}
	
	
	@RequestMapping("/registro")
	public String registro(Model model) {
		nombre = "Registro";
		model.addAttribute("nombrePestana", nombre);
		return "/secciones/registro";
	}
	
	
	
	
	
	@RequestMapping("/añadirPerfil")
	public String añadirPerfil(Model model) {
		nombre = "Perfil";
		model.addAttribute("nombrePestana", nombre);
		return "guardado";
	}
	
	@RequestMapping("/añadirJefe")
	public String añadirJefe(Model model) {
		nombre = "Administración";
		model.addAttribute("nombrePestana", nombre);
		return "guardado";
	}

}
