package com.tweb.salas.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.dominio.Medio_Tecnico;
import com.tweb.salas.servicio.MediosServicio;
import com.tweb.salas.servicio.SalaServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que carga el modelo de datos CRUD e invoca a las vistas
 * Tiene autorización solamente el Administrador para hacer CRUD
 */
@Controller
@RequestMapping("/admin") // Ruta de carpeta
public class MedioCRUDControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private SalaServicio salasServicio;
	
	@Autowired
	private MediosServicio mediosServicio;
	
	/**
	 * Método GET que añade o crea un Medio Técnico en el repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/agregarMedio")
	public String agregarMedio (Model model) {		
		// Añadimos las listas y creamos un objeto nuevo o lo editamos, al objeto Model 
		model.addAttribute("medios_tecnicos", mediosServicio.listaMedios());
		model.addAttribute("salas", salasServicio.listaSalas());
		model.addAttribute("medio", new Medio_Tecnico());
		return "agregarMedio";
	}
	
	/**
	 * Método GET que edita un Medio Técnico del repositorio 
	 * @param id entero único que identifica al Medio Técnico en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/editarMedio/{id}")
	public String verMedio (@PathVariable("id") Integer id, Model model) {		
		// Buscamos el Medio Técnico que coincida con el id, recibido como parámetro del JSP
		Medio_Tecnico medio = mediosServicio.buscarMedio(id);
		
		System.out.println("Medio: " + medio);
	    
	    // Añadimos las listas y el objeto Medio Técnico para editarlo
		model.addAttribute("medio", medio);		
	
		return "/admin/agregarMedio";
	}
	
	/**
	 * Método GET que borra o elimina un Medio Técnico del repositorio 
	 * @param id entero único que identifica al Medio en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */	
	@RequestMapping("/borrarMedio/{id}")
	public String borrarMedio (@PathVariable("id") Integer id, Model model) {
		// Buscamos el objeto medio que coincida con el parámetro id introducido
		// Borramos el objeto encontrado y mostramos el listado con el objeto borrado
		Medio_Tecnico medio = mediosServicio.buscarMedio(id);
		mediosServicio.borrarMedio(medio);
	
		model.addAttribute("medios", mediosServicio.listaMedios());
		return "redirect:/admin/medios";
	}
	
	/**
	 * Método POST que guarda un Medio Técnico en el repositorio 	 
	 * @param medio objeto recibido para validar
	 * @param bindingResult objeto para validar el objeto recibido
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@PostMapping("/guardarMedio")
	public String guardarMedio (@Valid Medio_Tecnico medio, BindingResult bindingResult, Model model) {		
		
		// Comprobamos si existe algún error de validación y redirigimos al formulario		
		if(bindingResult.hasErrors()) {				
			return "/admin/agregarMedio";
		}
		else {
			// Guardamos el objeto en el repositorio correspondiente			
			mediosServicio.guardarMedio(medio);
			return "/admin/medios";			
		}		
	}	
}