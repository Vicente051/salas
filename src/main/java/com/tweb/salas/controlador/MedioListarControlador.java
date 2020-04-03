package com.tweb.salas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.servicio.MediosServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que carga el modelo de datos CRUD e invoca a las vistas
 * Tiene autorización solamente el Administrador para hacer CRUD
 */
@Controller
@RequestMapping("/admin") // Ruta de carpeta
public class MedioListarControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private MediosServicio mediosServicio;
	
	/**
	 * Método GET que muestras las Salas del repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/medios")
	public String listarMedios (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("medios", mediosServicio.listaMedios());
		
		return "medios";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas alfabeticamente por el nombre
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/medios_nombreAsc")
	public String listarMediosOrdenadosAsc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("medios", mediosServicio.listaMediosOrdena());
		
		return "medios";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas descendentemente por el nombre
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/medios_nombreDesc")
	public String listarMediosOrdenadosDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("medios", mediosServicio.listaMediosOrdenaDesc());
		
		return "medios";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas de menor a mayor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/medios_idAsc")
	public String listaMediosOrdenaId (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("medios", mediosServicio.listaMediosOrdenaId());
		
		return "medios";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas de mayor a mnenor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/medios_idDesc")
	public String listaMediosOrdenaIdDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("medios", mediosServicio.listaMediosOrdenaIdDesc());
		
		return "medios";
	}
}