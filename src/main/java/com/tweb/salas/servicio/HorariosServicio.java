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

import com.tweb.salas.dominio.Horario;
import com.tweb.salas.dominio.Sala;
import com.tweb.salas.repositorio.IHorariosRepositorio;

/**
 * @authors Pedro, Chema y Manu
 * Clase Service que consta con los métodos CRUD necesarios para acceder al repositorio de horarios
 */
@Service
public class HorariosServicio {

	// Inyección de dependencias de los objetos Servicio que se necesitan
	@Autowired
	private IHorariosRepositorio horariosRepositorio;
	
	/**
	 * Método que busca un horario, en la BBDD, por su identificador único
	 * @param id identificador que tiene el medio dentro de la BBDD 
	 * @return el horario cuyo id es igual al parámetro introducido
	 */
	public Horario buscarHorario(Integer id) {		
		return horariosRepositorio.getOne(id);
	}
	
	/**
	 * Método que devuelve una lista de todos los horarios de la BBDD
	 * @return listado de horarios del repositorio
	 */
	public List<Horario> listaHorarios() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAll();
	}
	
	/**
	 * Método que devuelve una lista ordenada por Id de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaId() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByIdAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por Id de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaIdDesc() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByIdDesc();
	}
	
	/**
	 * Método que devuelve una lista ordenada por hora inicial de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaInicio() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByHinicioAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por hora inicial de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaInicioDesc() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByHinicioDesc();
	}
	
	/**
	 * Método que devuelve una lista ordenada por hora inicial de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaFinal() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByHfinalAsc();
	}
	
	/**
	 * Método que devuelve una lista ordenada descendente por hora inicial de todos los horarios de la BBDD
	 * @return listado de medios del repositorio
	 */
	public List<Horario> listaHorariosOrdenaFinalDesc() {
		// Encuentra todos los objetos en el repositorio
		return horariosRepositorio.findAllByOrderByHfinalDesc();
	}
	
	/**
	 * @param horario el objeto a guardar en la BBDD
	 * @return el horario guardado y añadido al repositorio
	 */
	public Horario guardarHorario(Horario horario) {
		// Guarda el objeto en el repositorio
		return horariosRepositorio.save(horario);
	}
	
	/**
	 * @param sala el objeto a borrar o eliminar de la BBDD
	 */
	public void borrarHorario(Horario horario) {
		// Borra el objeto en el repositorio
		Set<Sala> lsalas = horario.getSalas();
		  
		Iterator<Sala> it = lsalas.iterator();
		while(it.hasNext()) {
			Sala sala = it.next();
			sala.deleteHorario(horario);
		}
		horariosRepositorio.delete(horario);
	}	
}