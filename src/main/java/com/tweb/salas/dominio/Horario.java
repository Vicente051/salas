package com.tweb.salas.dominio;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 * @authors Pedro, Chema y Manu
 * Clase Horario Entity o de Dominio que implementa un objeto "horario"
 * Objetos que necesitan la Clase Sala y los objetos creados por esta última
 */
@Entity
public class Horario implements Serializable {
	
	private static final long serialVersionUID = 2363159202722602302L;
	
	// Atributo de número entero único y autoincrementado automáticamente (identificador del horario)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	// Atributo hora de inicio de uso de la sala
	@NotNull
	private LocalTime hinicio;
	
    
	
	// Atributo hora final de uso de la sala
	@NotNull
	private LocalTime hfinal;
	
	// Listado de salas que contendrán los horarios. Tabla relación muchos a muchos
	// Hay que mapear en una de las dos relaciones. Si no la considera como unidireccional	
	@ManyToMany(mappedBy = "lista_horarios")
	private Set<Sala> salas = new HashSet<Sala>();
	
	/**
	 * Constructor de la Clase Horario
	 */
	public Horario() {
		super();
	}

	/**
	 * Constructor de la Clase con los siguientes parámetros
	 * @param hora_inicio hora de inicio de uso de la sala
	 * @param hora_final hora final de uso de la sala
	 */
	public Horario(LocalTime hinicio, LocalTime hfinal) {		
		super();
		this.hinicio = hinicio;
		this.hfinal = hfinal;
	}

	/**
	 * Método de obtención del id del objeto
	 * @return el id del objeto
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método para la modificación del id del objeto
	 * @param id el identificador a modificar del objeto
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método de obtención de la hora de inicio de uso del objeto
	 * @return la hora de inicio del objeto
	 */
	public LocalTime getHinicio() {
		return hinicio;
	}

	/**
	 * Método de modificación de la hora de inicio de uso del objeto
	 * @param hora_inicio la hora de inicio de uso a modificar del objeto
	 */
	public void setHinicio(LocalTime hinicio) {
		this.hinicio = hinicio;
	}

	/**
	 * Método de obtención de la hora final de uso del objeto
	 * @return la hora final del objeto
	 */
	public LocalTime getHfinal() {
		return hfinal;
	}

	/**
	 * Método de modificación de la hora final de uso del objeto
	 * @param hora_final la hora final de uso a modificar del objeto
	 */
	public void setHfinal(LocalTime hfinal) {
		this.hfinal = hfinal;
	}

	/**
	 * Método de obtención del listado de salas del objeto
	 * @return el listado de salas
	 */
	public Set<Sala> getSalas() {
		return salas;
	}

	/**
	 * Método para la modificación del listado de salas del objeto
	 * @param salas el listado de salas a modificar del objeto
	 */
	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horario Sala [id=" + id + ", hora inicio=" + hinicio + ", hora final=" + hfinal + "]";
	}
}