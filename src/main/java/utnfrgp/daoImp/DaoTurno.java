package utnfrgp.daoImp;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utnfrgp.dao.IDaoTurno;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Turno;

public class DaoTurno implements IDaoTurno {

	private Conexion conexion;

	public DaoTurno(Conexion conexion) {
		this.conexion = conexion;
	}

	public DaoTurno() {
	}

	public boolean add(Turno turno) {
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;

		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			// Guardar el objeto
			session.save(turno);
			// Forzar la sincronización de la sesión con la base de datos
			session.flush();
			// Confirmar la transacción
			session.getTransaction().commit();
			// Verificar si el objeto se agregó a la base de datos
			Turno savedTurno = (Turno) session.get(Turno.class, turno.getId());
			if (savedTurno == null) {
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

	// leer
	public Turno leer(Long idTurno) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, idTurno);
		return turno;
	}

	// existe
	public boolean existe(Long idTurno) {
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, idTurno);
		if (turno != null) {
			return true;
		}
		return false;
	}

	// actualizar
	public boolean actualizar(Turno turno) {
		boolean estado = true;
		Session session = null;
		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.update(turno);
			session.flush();
			session.getTransaction().commit();
			Turno updateturno = (Turno) session.get(Turno.class, turno.getId());
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
		}

		return estado;
	}

	// borrar
	public boolean borrar(Turno turno) { // Este turno tiene que venir cargado el id de turno que se quiere eliminar
		boolean estado = true;
		conexion = new Conexion();
		Session session = null;

		try {
			session = conexion.abrirConexion();
			session.beginTransaction();
			session.delete(turno);
			session.flush();
			session.getTransaction().commit();
			Turno deleteturno = (Turno) session.get(Turno.class, turno.getId());
			if (deleteturno != null) {
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

	// listar
	public List<Turno> leerTodos() {
		conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Turno> lista = session.getNamedQuery("findAllTurnos").list();
		return lista;
	}

	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {

		Session session = conexion.abrirConexion();
		session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Presente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		session.getTransaction().commit();
		conexion.cerrarSession();
		return count;
	}

	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {

		Session session = conexion.abrirConexion();
		session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Ausente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		session.getTransaction().commit();
		conexion.cerrarSession();
		return count;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return conexion;
	}

}
