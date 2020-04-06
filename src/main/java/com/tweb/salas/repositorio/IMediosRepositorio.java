package com.tweb.salas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweb.salas.dominio.Medio_Tecnico;

/**
 * @authors Pedro, Chema y Manu
 * Interface IMediosRepositorio que hereda de la Clase JpaRepositoryque implementa un objeto "horario"
 * Parámetros utilizados de las Clases Medio_Tecnico e Integer
 */
public interface IMediosRepositorio extends JpaRepository<Medio_Tecnico, Integer> {
	
	// Consulta que ordena, por orden alfabético de la A-Z, los medios técnicos por nombre	
	public List<Medio_Tecnico> findAllByOrderByNombreAsc ();
	
	// Consulta que ordena, por orden alfabético de la Z-A, los medios técnicos por nombre	
	public List<Medio_Tecnico> findAllByOrderByNombreDesc ();
	
	// Consulta que ordena, de menor a mayor, los medios técnicos por Id	
	public List<Medio_Tecnico> findAllByOrderByIdAsc ();
		
	// Consulta que ordena, de mayor a menor, los medios técnicos por Id	
	public List<Medio_Tecnico> findAllByOrderByIdDesc ();
}