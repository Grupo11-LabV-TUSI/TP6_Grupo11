package utnfrgp.daoImp;

import java.util.List;

import org.hibernate.Session;

import utnfrgp.dao.IDaoEspecialidad;
import utnfrgp.entidad.Especialidad;

public class DaoEspecialidad implements IDaoEspecialidad {
	private Conexion conexion;

	public DaoEspecialidad() {
		// TODO Auto-generated constructor stub
	}

	public DaoEspecialidad(Conexion conexion) {
		this.conexion = conexion;
	}

	public boolean add(Especialidad especialidad) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.save(especialidad);
			session.flush();
			session.getTransaction().commit();

			Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());
			if (savedEspecialidad == null) {
				estado = false;
			}

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		}

		return estado;
	}

	public Especialidad readOne(int idEspecialidad) {
		conexion = new Conexion();
		Session session = null;
		Especialidad especialidad = null;
		try {
			session = conexion.abrirConexion();
			especialidad = (Especialidad) session.get(Especialidad.class, idEspecialidad);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return especialidad;
	}

	public boolean exist(int idEspecialidad) {

		return readOne(idEspecialidad) != null;

	}

	public boolean update(Especialidad especialidad) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.update(especialidad);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			estado = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return estado;
	}

	public boolean delete(Especialidad especialidad) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.delete(especialidad);
			session.flush();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			estado = false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return estado;
	}

	public List<Especialidad> readAll() {
		conexion = new Conexion();
		Session session = null;
		List<Especialidad> especialidades = session.createQuery("FROM Especialidad").list();
		return especialidades;
	}
	// Agrego los gettes y setters para Spring Core

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
