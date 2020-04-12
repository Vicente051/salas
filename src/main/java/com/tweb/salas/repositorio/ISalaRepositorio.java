package com.tweb.salas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweb.salas.dominio.Sala;

/**
 * @authors Pedro, Chema y Manu
 * Interface ISalaRepositorio que hereda de la Clase JpaRepositoryque implementa un objeto "horario"
 * Parámetros utilizados de las Clases Sala e Integer
 */
public interface ISalaRepositorio extends JpaRepository<Sala, Integer> {
	
	// Consulta que ordena, de menor a mayor, los medios técnicos por Id	
	public List<Sala> findAllByOrderByIdAsc ();
			
	// Consulta que ordena, de mayor a menor, los medios técnicos por Id	
	public List<Sala> findAllByOrderByIdDesc ();
	
	// Consulta que ordena, por orden alfabético de la A-Z, los medios técnicos por nombre	
	public List<Sala> findAllByOrderByNombreAsc ();
		
	// Consulta que ordena, por orden alfabético de la Z-A, los medios técnicos por nombre	
	public List<Sala> findAllByOrderByNombreDesc ();
		
	// Consulta que ordena, de menor a mayor, los medios técnicos por aforo	
	public List<Sala> findAllByOrderByAforoAsc ();
			
	// Consulta que ordena, de mayor a menor, los medios técnicos por aforo	
	public List<Sala> findAllByOrderByAforoDesc ();
}