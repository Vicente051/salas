package com.tweb.salas.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.dominio.Horario;
import com.tweb.salas.dominio.Medio_Tecnico;
import com.tweb.salas.dominio.Sala;
import com.tweb.salas.servicio.HorariosServicio;
import com.tweb.salas.servicio.MediosServicio;
import com.tweb.salas.servicio.SalaServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que carga el modelo de datos CRUD e invoca a las vistas
 * Tiene autorización solamente el Administrador para hacer CRUD
 */
@Controller
@RequestMapping("/admin") // Ruta de carpeta
public class SalaCRUDControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private SalaServicio salasServicio;
	
	@Autowired
	private MediosServicio mediosServicio;
	
	@Autowired
	private HorariosServicio horariosServicio;
	
	/**
	 * Método GET que añade o crea una Sala en el repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/agregarSala")
	public String agregarSala (Model model) {		
		// Añadimos las listas y creamos un objeto nuevo o lo editamos, al objeto Model 
		model.addAttribute("medios_tecnicos", mediosServicio.listaMedios());
		model.addAttribute("horarios", horariosServicio.listaHorarios());
		model.addAttribute("salas", salasServicio.listaSalas());
		model.addAttribute("sala", new Sala());
		return "agregarSala";
	}
	
	/**
	 * Método GET que edita una Sala del repositorio 
	 * @param id entero único que identifica a la Sala en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/editarSala/{id}")
	public String verSala (@PathVariable("id") Integer id, Model model) {
		
		// Buscamos la Sala que coincida con el id, recibido como parámetro del JSP
		Sala sala = salasServicio.buscarSala(id);		
		
		// Se crea una nueva lista para insertar los Medios que faltan en el objeto Sala a editar
		List<Medio_Tecnico> lista_medios_faltan = new ArrayList<>();
		// Insertamos todos los medios en la nueva lista creada
		lista_medios_faltan.addAll(mediosServicio.listaMedios());
		// Eliminamos los medios que son comunes en el atributo de la Sala
	    lista_medios_faltan.removeAll(sala.getLista_medios_tecnicos());
	    
	    // Se crea una nueva lista para insertar los Horarios que faltan en el objeto Sala a editar
	 	List<Horario> lista_horarios_faltan = new ArrayList<>();
	 	// Insertamos todos los horarios en la nueva lista creada
	 	lista_horarios_faltan.addAll(horariosServicio.listaHorarios());
	 	// Eliminamos los horarios que son comunes en el atributo de la Sala
	 	lista_horarios_faltan.removeAll(sala.getLista_horarios());
	    
	    // Añadimos las listas y el objeto Sala para editarla
		model.addAttribute("horarios", lista_horarios_faltan);		
		model.addAttribute("medios_tecnicos", lista_medios_faltan);
		model.addAttribute("sala", sala);		
	
		return "/admin/agregarSala";
	}
	
	/**
	 * Método GET que borra o elimina una Sala del repositorio 
	 * @param id entero único que identifica a la Sala en la BBDD
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */	
	@RequestMapping("/borrarSala/{id}")
	public String borrarSala (@PathVariable("id") Integer id, Model model) {		
		// Buscamos el objeto sala que coincida con el parámetro id introducido
		// Borramos el objeto encontrado y mostramos el listado con el objeto borrado
		Sala sala=salasServicio.buscarSala(id);
		salasServicio.borrarSala(sala);
		model.addAttribute("salas", salasServicio.listaSalas());
		return "agregarSala";
	}
	
	/**
	 * Método POST que guarda una Sala en el repositorio 	 
	 * @param sala objeto recibido para validar
	 * @param bindingResult objeto para validar el objeto recibido
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@PostMapping("/guardarSala")
	public String guardarSala (@Valid Sala sala, BindingResult bindingResult, Model model) {		
		
		// Comprobamos si existe algún error de validación y redirigimos al formulario		
		if(bindingResult.hasErrors()) {			
			System.out.println("Ha pasado algo");
			model.addAttribute("errores", bindingResult);			
			return "redirect:/admin/agregarSala";
		}
		else {
			// Guardamos el objeto en el repositorio correspondiente			
			salasServicio.guardarSala(sala);
			return "redirect:/salas";			
		}		
	}
}