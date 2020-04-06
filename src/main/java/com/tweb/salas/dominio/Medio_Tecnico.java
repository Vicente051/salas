package com.tweb.salas.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @authors Pedro, Chema y Manu
 * Clase Medio_Tecnico Entity o de Dominio que implementa un objeto "medio_tecnico"
 * Objetos que necesitan la Clase Sala y los objetos creados por esta última
 */
@Entity 
@Table(name="MEDIO_TECNICO")
public class Medio_Tecnico implements Serializable {
	
	private static final long serialVersionUID = -8205128823803257373L;
	
	// Atributo de número entero único y autoincrementado automáticamente (identificador del medio técnico)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	// Atributo que da nombre al medio técnico
	@NotBlank
	@Size (min=2, max=50, message="Tamaño excedido")
	private String nombre;
	
	// Listado de salas que contendrán los medios técnicos. Tabla relación muchos a muchos
	// Hay que mapear en una de las dos relaciones. Si no la considera como unidireccional
	@ManyToMany(mappedBy = "lista_medios_tecnicos")//, cascade = {CascadeType.REFRESH})
	private Set<Sala> salas = new HashSet<Sala>();
	
	/**
	 * Constructor de la Clase Medio_Tecnico
	 */
	public Medio_Tecnico() {
		super();
	}
	
	/**
	 * Constructor de la Clase con los siguientes parámetros
	 * @param nombre string que da nombre al medio técnico
	 */
	public Medio_Tecnico(String nombre) {
		super();
		this.nombre = nombre;
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
	 * Método de obtención del nombre del objeto
	 * @return el nombre del objeto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para la modificación del nombre del objeto
	 * @param medio el nombre a modificar del objeto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public void addSala(Sala sala) {
		salas.add(sala);
		sala.getLista_medios_tecnicos().add(this);
    }
	
	public void removeSala(Sala sala) {
		salas.remove(sala);
		sala.getLista_medios_tecnicos().remove(this);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Medio_Tecnico other = (Medio_Tecnico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medio Tecnico [id=" + id + ", nombre=" + nombre + "]";
	}
}