package com.tweb.salas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweb.salas.dominio.Horario;

/**
 * @authors Pedro, Chema y Manu
 * Interface IHorariosRepositorio que hereda de la Clase JpaRepositoryque implementa un objeto "horario"
 * Parámetros utilizados de las Clases Horario e Integer
 */
public interface IHorariosRepositorio extends JpaRepository<Horario, Integer> {
	
	// Consulta que ordena, de menor a mayor, los medios técnicos por Id	
	public List<Horario> findAllByOrderByIdAsc ();
			
	// Consulta que ordena, de mayor a menor, los medios técnicos por Id	
	public List<Horario> findAllByOrderByIdDesc ();
	
	// Consulta que ordena, por orden de menor a mayor, los horarios por hora inicial
	public List<Horario> findAllByOrderByHinicioAsc ();
	
	// Consulta que ordena, por orden de mayor a menor, los horarios por hora inicial
	public List<Horario> findAllByOrderByHinicioDesc ();
	
	// Consulta que ordena, por orden de menor a mayor, los horarios por hora final
	public List<Horario> findAllByOrderByHfinalAsc ();
		
	// Consulta que ordena, por orden de mayor a menor, los horarios por hora final
	public List<Horario> findAllByOrderByHfinalDesc ();
}