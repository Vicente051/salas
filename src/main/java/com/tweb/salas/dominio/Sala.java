package com.tweb.salas.dominio;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @authors Pedro, Chema y Manu
 * Clase Sala Entity o de Dominio que implementa un objeto "sala"
 */
@Entity
public class Sala implements Serializable {
	
	private static final long serialVersionUID = -4763636368420401538L;
	
	// Atributo de número entero único y autoincrementado automáticamente (identificador de la sala)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	// Atributo que da nombre a la sala
	@NotBlank
	@Size (min=2, max=50, message="Tamaño excedido")
	private String nombre;	
	
	// Atributo que da el aforo mínimo y máximo de la sala
	@Min(value = 2, message = "Tiene que ser como mínimo para 2 personas")
    @Max(value = 150, message = "No puede exceder de 150 personas")
	@NotNull
	private Integer aforo;
	
	// Listado de medios técnicos con los que constará la sala. Tabla relación muchos a muchos
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "sala_id"),
		inverseJoinColumns  = @JoinColumn(name = "medio_id"))	 
	@NotNull
	private Set<Medio_Tecnico> lista_medios_tecnicos = new HashSet<Medio_Tecnico>();	
	
	// Listado de horarios con los que constará la sala. Tabla relación muchos a muchos
	@ManyToMany//(cascade = CascadeType.MERGE)
	@JoinTable(joinColumns = @JoinColumn(name = "sala_id"),
	inverseJoinColumns	= @JoinColumn(name = "horario_id"))
	@NotNull
	private Set<Horario> lista_horarios = new HashSet<Horario>();		
	/**
	 * Constructor de la Clase Sala
	 */
	public Sala() {
		super();
	}	
	
	/**
	 * Constructor de la Clase con los siguientes parámetros
	 * @param id entero único que identifica a la sala
	 * @param nombre string que da nombre a la sala
	 * @param aforo entero que limita el aforo de la sala
	 * @param lista_medios_tecnicos lista de medios técnicos con los que cuenta la sala
	 * @param lista_horarios lista de horarios con los que cuenta la sala
	 */
	public Sala(Integer id, String nombre, Integer aforo, Set<Medio_Tecnico> lista_medios_tecnicos
							, Set<Horario> lista_horarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aforo = aforo;
		this.lista_medios_tecnicos = lista_medios_tecnicos;
		this.lista_horarios = lista_horarios;
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
	 * @param nombre el nombre a modificar del objeto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método de obtención del aforo del objeto
	 * @return el aforo del objeto
	 */
	public Integer getAforo() {
		return aforo;
	}

	/**
	 * Método para la modificación del aforo del objeto
	 * @param aforo el aforo a modificar del objeto
	 */
	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}
	
	/**
	 * Método de obtención del listado de medios técnicos del objeto
	 * @return el listado de medios técnicos
	 */
	public Set<Medio_Tecnico> getLista_medios_tecnicos() {
		return lista_medios_tecnicos;
	}

	/**
	 * Método para la modificación del listado de medios técnicos del objeto
	 * @param lista_medios_tecnicos el listado de medios técnicos a modificar del objeto
	 */
	public void setLista_medios_tecnicos(Set<Medio_Tecnico> lista_medios_tecnicos) {
		this.lista_medios_tecnicos = lista_medios_tecnicos;
	}
	
	
	public Set<Medio_Tecnico> addMedio(Medio_Tecnico medio) {
		lista_medios_tecnicos.add(medio);
		return lista_medios_tecnicos;
    }
	
	/**
	 * Método de obtención del listado de medios técnicos del objeto
	 * @return el listado de medios técnicos
	 */
	public Set<Medio_Tecnico> deleteMedio(Medio_Tecnico medio) {
		lista_medios_tecnicos.remove(medio);
		return lista_medios_tecnicos;
	}

	/**
	 * Método de obtención del listado de horarios del objeto
	 * @return el listado de horarios
	 */
	public Set<Horario> getLista_horarios() {
		return lista_horarios;
	}

	/**
	 * Método para la modificación del listado de horarios del objeto
	 * @param lista_horarios el listado de horarios a modificar del objeto
	 */
	public void setLista_horarios(Set<Horario> lista_horarios) {
		this.lista_horarios = lista_horarios;
	}
	
	public Set<Horario> addHorario(Horario horario) {
		lista_horarios.add(horario);
		return lista_horarios;
    }
	
    public Set<Horario> deleteHorario(Horario horario) {    	
    	lista_horarios.remove(horario);
    	return lista_horarios;
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
		Sala other = (Sala) obj;
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
		return "Sala [id=" + id + ", nombre=" + nombre + ", aforo=" + aforo + ", medios_tecnicos="
					+ lista_medios_tecnicos + ", horarios=" + lista_horarios + "]";
	}
}