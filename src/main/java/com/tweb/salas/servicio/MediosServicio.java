/*
 * @author: Pedro Jose Vicente Garcia
 * Implementa la Clase Servicio Marca
 * 
 */

package com.tweb.salas.servicio;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweb.salas.dominio.Medio_Tecnico;
import com.tweb.salas.dominio.Sala;
import com.tweb.salas.repositorio.IMediosRepositorio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Service que consta con los métodos CRUD necesarios para acceder al repositorio de medios técnicos
 */
@Service
public class MediosServicio {

	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private IMediosRepositorio mediosRepositorio;
	
	/**
	 * Método que busca un medio técnico, en la BBDD, por su identificador único
	 * @param id identificador que tiene el medio dentro de la BBDD 
	 * @return el medio técnico cuyo id es igual al parámetro introducido
	 */
	public Medio_Tecnico buscarMedio (Integer id) {		
		return mediosRepositorio.getOne(id);
	}
	
	/**
	 * Método que devuelve una lista de todos los medios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Medio_Tecnico> listaMedios() {
		// Encuentra todos los objetos en el repositorio
		return mediosRepositorio.findAll();
	}
	
	/**
	 * Método que devuelve una lista ordenada por nombre de todos los medios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Medio_Tecnico> listaMediosOrdena() {
		// Encuentra todos los objetos en el repositorio
		return mediosRepositorio.findAllByOrderByNombreAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por nombre de todos los medios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Medio_Tecnico> listaMediosOrdenaDesc() {
		// Encuentra todos los objetos en el repositorio
		return mediosRepositorio.findAllByOrderByNombreDesc();
	}
	
	/**
	 * Método que devuelve una lista ordenada por Id de todos los medios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Medio_Tecnico> listaMediosOrdenaId() {
		// Encuentra todos los objetos en el repositorio
		return mediosRepositorio.findAllByOrderByIdAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por Id de todos los medios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Medio_Tecnico> listaMediosOrdenaIdDesc() {
		// Encuentra todos los objetos en el repositorio
		return mediosRepositorio.findAllByOrderByIdDesc();
	}
	
	/**
	 * @param medio el objeto a guardar en la BBDD
	 * @return la sala guardada y añadida al repositorio
	 */
	public Medio_Tecnico guardarMedio(Medio_Tecnico medio) {
		// Guarda el objeto en el repositorio
		return mediosRepositorio.save(medio);
	}
	
	/**
	 * @param sala el objeto a borrar o eliminar de la BBDD
	 */
	//@PreRemove
	//public List<Medio_Tecnico> borrarMedio(Medio_Tecnico medio) {
	public void borrarMedio(Medio_Tecnico medio) {
		// Borra el objeto en el repositorio
		Set<Sala> lsalas = medio.getSalas();
		  
		Iterator<Sala> it = lsalas.iterator();
		while(it.hasNext()) {
			Sala sala = it.next();
			sala.deleteMedio(medio);
		}
		mediosRepositorio.delete(medio);
	}	
}