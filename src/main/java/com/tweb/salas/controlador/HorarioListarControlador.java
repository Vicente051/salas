package com.tweb.salas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweb.salas.servicio.HorariosServicio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Controller que carga el modelo de datos CRUD e invoca a las vistas
 * Tiene autorización solamente el Administrador para hacer CRUD
 */
@Controller
@RequestMapping("/admin") // Ruta de carpeta
public class HorarioListarControlador {
	
	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private HorariosServicio horariosServicio;
	
	/**
	 * Método GET que muestras los Horarios del repositorio
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios")
	public String listarHorarios (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorarios());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestras los Horarios del repositorio ordenadas de menor a mayor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_idAsc")
	public String listaHorariosOrdenaId (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaId());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestras las Salas del repositorio ordenadas de mayor a mnenor por el Id
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_idDesc")
	public String listaHorariosOrdenaIdDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaIdDesc());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestra los Horarios del repositorio ordenados por hora inicial de menor a mayor
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_iniAsc")
	public String listarHorariosOrdenadosHora_inicioAsc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaInicio());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestra los Horarios del repositorio ordenados por hora inicial de mayor a menor
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_iniDesc")
	public String listarHorariosOrdenadosDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaInicioDesc());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestra los Horarios del repositorio ordenados por hora inicial de menor a mayor
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_finAsc")
	public String listarHorariosOrdenadosHoraFinalAsc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaFinal());
		
		return "horarios";
	}
	
	/**
	 * Método GET que muestra los Horarios del repositorio ordenados por hora inicial de mayor a menor
	 * @param model objeto de la Clase Model para añadir objetos creados
	 * @return String que busca la página correspondiente
	 */
	@RequestMapping("/horarios_finDesc")
	public String listarHorariosOrdenadosHoraFinalDesc (Model model) {
		// Añadimos las listas al objeto Model
		model.addAttribute("horarios", horariosServicio.listaHorariosOrdenaFinalDesc());
		
		return "horarios";
	}
}