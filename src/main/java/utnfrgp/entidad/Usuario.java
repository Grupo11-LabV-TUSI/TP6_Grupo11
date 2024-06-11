package utnfrgp.entidad;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(
		name = "findAllUsuarios",
		query = "SELECT p FROM Usuario p"
		)
})

@Entity
@Table(name="Usuario")


public class Usuario implements Serializable  {
	// Implementar serializable
		private static final long serialVersionUID = 1L;

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String usuario;
	    private String contraseña;
	    private String estado;

	    // Constructor por defecto
	    public Usuario() {}

	    // Constructor con parámetros
	    public Usuario(String usuario, String contraseña, String estado) {
	        this.usuario = usuario;
	        this.contraseña = contraseña;
	        this.estado = estado;
	    }

	    // Getters y Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(String contraseña) {
	        this.contraseña = contraseña;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
}
