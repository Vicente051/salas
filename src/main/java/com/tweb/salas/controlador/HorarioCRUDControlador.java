package com.tweb.salas.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.dominio.Horario;
import com.tweb.salas.servicio.HorariosServicio;
import com.tweb.salas.servicio.SalaServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que carga el modelo de datos CRUD e invoca a las vistas
 * Tiene autorización solamente el Administrador para hacer CRUD
 */
@Controller
@RequestMapping("/admin") // Ruta de carpeta
public class HorarioCRUDControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private SalaServicio salasServicio;
	
	@Autowired
	private HorariosServicio horariosServicio;
	
	/**
	 * Método GET que añade o crea un Horario en el repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/agregarHorario")
	public String agregarMedio (Model model) {		
		// Añadimos las listas y creamos un objeto nuevo o lo editamos, al objeto Model 
		model.addAttribute("horarios", horariosServicio.listaHorarios());
		model.addAttribute("salas", salasServicio.listaSalas());
		model.addAttribute("horario", new Horario());
		return "agregarHorario";
	}
	
	/**
	 * Método GET que edita un Horario del repositorio 
	 * @param id entero único que identifica al Horario en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/editarHorario/{id}")
	public String verHorario (@PathVariable("id") Integer id, Model model) {		
		// Buscamos el Horario que coincida con el id, recibido como parámetro del JSP
		Horario horario = horariosServicio.buscarHorario(id);
	    
	    // Añadimos las listas y el objeto Horario para editarlo
		model.addAttribute("horario", horario);
		System.out.println("Horario: " + horario);
	
		return "/admin/agregarHorario";
	}
	
	/**
	 * Método GET que borra o elimina un Horario del repositorio 
	 * @param id entero único que identifica al Horario en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */	
	@RequestMapping("/borrarHorario/{id}")
	public String borrarHorario (@PathVariable("id") Integer id, Model model) {
		// Buscamos el objeto horario que coincida con el parámetro id introducido
		// Borramos el objeto encontrado y mostramos el listado con el objeto borrado
		// Buscamos el Medio Técnico que coincida con el id, recibido como parámetro del JSP
		Horario horario = horariosServicio.buscarHorario(id);
		
		horariosServicio.borrarHorario(horario);		
	
		model.addAttribute("medios", horariosServicio.listaHorarios());
		return "redirect:/admin/horarios";
	}
	
	/**
	 * Método POST que guarda un Horario en el repositorio 	 
	 * @param horario objeto recibido para validar
	 * @param bindingResult objeto para validar el objeto recibido
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@PostMapping("/guardarHorario")
	public String guardarMedio (@Valid Horario horario, BindingResult bindingResult, Model model) {
		
		// Comprobamos si existe algún error de validación y redirigimos al formulario		
		 if(bindingResult.hasErrors()) {
			 System.out.println("Hora falla: " + horario.getHinicio() + " - " + horario.getHfinal());
			 return "/admin/agregarHorario"; 
		} 
		 else {
			 // Guardamos el objeto en el repositorio correspondiente 
			 horariosServicio.guardarHorario(horario);
			 return "redirect:/admin/horarios";
		  }
		 	
	}	
}