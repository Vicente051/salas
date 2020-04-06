package com.tweb.salas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.servicio.SalaServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que muestra el listado de las Salas
 */
@Controller
public class SalaListarControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private SalaServicio salasServicio;
	
	/**
	 * Método GET que muestras las Salas del repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/")
	public String inicio (Model model) {
		// Añadimos las listas al objeto Model
		String ruta = "salas";
		model.addAttribute("salas", salasServicio.listaSalas());
		model.addAttribute("ruta", ruta);	
		
		return "index";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/salas")
	public String listarSalas (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("salas", salasServicio.listaSalas());		
		
		return "salas";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas alfabeticamente por el nombre
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/salas_nombreAsc")
	public String listarSalasOrdenadasAsc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("salas", salasServicio.listaSalasOrdena());
		
		return "salas";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas descendentemente por el nombre
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/salas_nombreDesc")
	public String listarSalasOrdenadasDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("salas", salasServicio.listaSalasOrdenaDesc());
		
		return "salas";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas de menor a mayor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/salas_idAsc")
	public String listaMediosOrdenaId (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("salas", salasServicio.listaSalasOrdenaId());
		
		return "salas";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas de mayor a mnenor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/salas_idDesc")
	public String listaMediosOrdenaIdDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("salas", salasServicio.listaSalasOrdenaIdDesc());
		
		return "salas";
	}
}