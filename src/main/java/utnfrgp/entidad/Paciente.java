package utnfrgp.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findAllPacientes",
		query = "SELECT p FROM Paciente p"
		)
})

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable {
	// Implementar serializable
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="dni")
	private int dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fecha_nacimiento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="estado")
	private boolean estado;
	
	// Constructor vacio requerido por Hibernate
	public Paciente() {}

	public Paciente(int dni, String nombre, String apellido, String email, String telefono, LocalDate fecha_nacimiento,
			String direccion, String localidad, String provincia, boolean estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.estado = estado;
	}

	// Getters y Setters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", estado=" + estado + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Paciente other = (Paciente) obj;
		if(dni == 0) {
			if(other.dni != 0) {
				return false;
			} else if(!(dni == other.dni)) {
				return false;
			}
		}
		if(nombre == null) {
			if(other.nombre != null) {
				return false;
			} else if(!nombre.equals(other.nombre)) {
				return false;
			}
		}
		if(apellido == null) {
			if(other.apellido != null) {
				return false;
			} else if(!apellido.equals(other.apellido)) {
				return false;
			}
		}
		if(email == null) {
			if(other.email != null) {
				return false;
			} else if(!email.equals(other.email)) {
				return false;
			}
		}
		if(telefono == null) {
			if(other.telefono != null) {
				return false;
			} else if(!telefono.equals(other.telefono)) {
				return false;
			}
		}
		if(fecha_nacimiento == null) {
			if(other.fecha_nacimiento != null) {
				return false;
			} else if(!fecha_nacimiento.equals(other.fecha_nacimiento)) {
				return false;
			}
		}
		if(direccion == null) {
			if(other.direccion != null) {
				return false;
			} else if(!direccion.equals(other.direccion)) {
				return false;
			}
		}
		if(localidad == null) {
			if(other.localidad != null) {
				return false;
			} else if(!localidad.equals(other.localidad)) {
				return false;
			}
		}
		if(provincia == null) {
			if(other.provincia != null) {
				return false;
			} else if(!provincia.equals(other.provincia)) {
				return false;
			}
		}
		if(nombre == null) {
			if(other.nombre != null) {
				return false;
			} else if(!nombre.equals(other.nombre)) {
				return false;
			}
		}
		if(estado == false) {
			if(other.estado != false) {
				return false;
			} else if(!(estado == other.estado)) {
				return false;
			}
		}
		return true;
	}
	
}
