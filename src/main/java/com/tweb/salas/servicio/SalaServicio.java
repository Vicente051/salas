/*
 * @author: Pedro Jose Vicente Garcia
 * Implementa la Clase Servicio Marca
 * 
 */

package com.tweb.salas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweb.salas.dominio.Sala;
import com.tweb.salas.repositorio.ISalaRepositorio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Service que consta con los métodos CRUD necesarios para acceder al repositorio de salas
 */
@Service
public class SalaServicio {

	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private ISalaRepositorio salasRepositorio;	
	
	/**
	 * Método que busca una sala, en la BBDD, por su identificador único
	 * @param id identificador que tiene la sala dentro de la BBDD 
	 * @return la sala cuyo id es igual al parámetro introducido
	 */
	public Sala buscarSala (Integer id) {		
		return salasRepositorio.getOne(id);
	}
	
	/**
	 * Método que devuelve una lista de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalas() {
		// Encuentra todos los objetos en el repositorio	
		return salasRepositorio.findAll();
	}
	
	/**
	 * Método que devuelve una lista ordenada por Id de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdenaId() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByIdAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por Id de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdenaIdDesc() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByIdDesc();
	}
	
	/**
	 * Método que devuelve una lista ordenada por nombre de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdena() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByNombreAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por nombre de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdenaDesc() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByNombreDesc();
	}
	
	/**
	 * Método que devuelve una lista ordenada por aforo de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdenaAforo() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByAforoAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por aforo de todas las salas de la BBDD
	 * @return listado de salas del repositorio
	 */
	public List<Sala> listaSalasOrdenaAforoDesc() {
		// Encuentra todos los objetos en el repositorio
		return salasRepositorio.findAllByOrderByAforoDesc();
	}	
	
	/**
	 * @param medio el objeto a guardar en la BBDD
	 * @return la sala guardada y añadida al repositorio
	 */
	public Sala guardarMedio(Sala medio) {
		// Guarda el objeto en el repositorio
		return salasRepositorio.save(medio);
	}
	
	/**
	 * @param sala el objeto a guardar en la BBDD
	 * @return la sala guardada y añadida al repositorio
	 */
	public Sala guardarSala(Sala sala) {
		// Guarda el objeto en el repositorio
		return salasRepositorio.save(sala);
	}
	
	/**
	 * @param sala el objeto a borrar o eliminar de la BBDD
	 */
	public void borrarSala(Sala sala) {
		// Borra el objeto en el repositorio
		salasRepositorio.delete(sala);
	}
}