package utnfrgp.daoImp;

import java.util.List;

import org.hibernate.Session;

import utnfrgp.dao.IDaoPaciente;
import utnfrgp.entidad.Paciente;

public class DaoPaciente implements IDaoPaciente{
	
	private Conexion conexion;

	public DaoPaciente() {}

	public DaoPaciente(Conexion conexion) {
		this.conexion = conexion;
	}

	public boolean add(Paciente paciente) {
		boolean estado = true;
	    conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        // Guardar el objeto
	        session.save(paciente);
	        
	        // Forzar la sincronización de la sesión con la base de datos
	        session.flush();
	        
	        // Confirmar la transacción
	        session.getTransaction().commit();
	        
	        // Verificar si el objeto se agregó a la base de datos
	        Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDni());
	        
	        if (savedPaciente == null) {
	            estado = false;
	        }
	        
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
	    return estado;
	}

	public Paciente readOne(int dniPaciente) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente = (Paciente) session.get(Paciente.class, dniPaciente);
		return paciente;
	}

	public boolean exist(int dniPaciente) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Paciente paciente = (Paciente) session.get(Paciente.class, dniPaciente);
		if(paciente != null) {
			return true;
		}
		return false;
	}

	public boolean update(Paciente paciente) {
		boolean estado = true;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			
			// Guardar el objeto
			session.update(paciente);
			
			// Forzar la sincronización de la sesión con la base de datos
			session.flush();
			
			// Confirmar la transacción
			session.getTransaction().commit();
			
			// Verificar si el objeto se agregó a la base de datos
			Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDni());
			
			if(savedPaciente.equals(paciente) == false) {
				estado = false;
			}
		} catch (Exception e) {
			if(session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
		}
		
		return estado;
	}

	public boolean delete(Paciente paciente) {
		boolean estado = true;
		conexion = new Conexion();
	    Session session = null;

	    try {
	        session = conexion.abrirConexion();
	        session.beginTransaction();
	        
	        // Guardar el objeto
	        session.delete(paciente);
	        
	        // Forzar la sincronización de la sesión con la base de datos
	        session.flush();
	        
	        // Confirmar la transacción
	        session.getTransaction().commit();
	        
	        // Verificar si el objeto se agregó a la base de datos
	        Paciente savedPaciente = (Paciente) session.get(Paciente.class, paciente.getDni());
	        
	        if (savedPaciente != null) {
	            estado = false;
	        }
	    } catch (Exception e) {
	        if (session != null) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	    }
	    
		return estado;
	}
	
	public List<Paciente> readAll() {
		conexion = new Conexion();
	    Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Paciente> pacientes = session.createQuery("FROM Paciente").list();
        return pacientes;
	}
	
	//Agrego los gettes y setters para Spring Core
	
	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
