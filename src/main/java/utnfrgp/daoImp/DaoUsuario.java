package utnfrgp.daoImp;

import utnfrgp.dao.IDaoUsuario;
import utnfrgp.entidad.Usuario;
import org.hibernate.Session;

import java.util.List;

public class DaoUsuario implements IDaoUsuario {

	private Conexion conexion;

	public DaoUsuario() {
	}

	public DaoUsuario(Conexion conexion) {
		this.conexion = conexion;
	}

	public boolean add(Usuario usuario) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;

		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.save(usuario);
			session.flush();
			session.getTransaction().commit();
			Usuario saveUsuario = (Usuario) session.get(Usuario.class, usuario.getId());

			if (saveUsuario == null) {
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

	public Usuario readOne(Long idUsuario) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, idUsuario);
		return usuario;
	}

	public boolean exist(Long idUsuario) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, idUsuario);
		if (usuario != null) {
			return true;
		}
		return false;
	}

	public boolean update(Usuario usuario) {
		boolean estado = true;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.update(usuario);
			session.flush();
			session.getTransaction().commit();

			Usuario saveUsuario = (Usuario) session.get(Usuario.class, usuario.getId());

			if (saveUsuario == null) {
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

	public boolean delete(Usuario usuario) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;
		
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.delete(usuario);
			session.flush();
			session.getTransaction().commit();
			
			Usuario user = (Usuario) session.get(Usuario.class, usuario.getId());
			if (user != null) {
				estado = false;
			}
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();				
			}
			e.printStackTrace();
		}finally {
		}
		
		return estado;
	}

	public List<Usuario> readAll() {
		conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Usuario> usuarios = session.createQuery("from Usuario").list();
		return usuarios;
	}
	
	// Agrego los gettes y setters para Spring Core

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
