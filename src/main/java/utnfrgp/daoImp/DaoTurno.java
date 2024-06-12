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
	
	public DaoTurno (Conexion conexion) {this.conexion = conexion;}
	
	public DaoTurno() {}
	
	
	
	public void add(Turno turno) {
		
		
		conexion = new Conexion();
		Session session = null;
		
			session = conexion.abrirConexion();
			session.beginTransaction();

			// Guardar el objeto
			session.save(turno);

			// Forzar la sincronización de la sesión con la base de datos
			session.flush();

			// Confirmar la transacción
			session.getTransaction().commit();
		

	
	}

	// leer
	public  Turno leer(Long id) {
		
		Session session = conexion.abrirConexion();

		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, id);
		
		session.getTransaction().commit();
		conexion.cerrarSession();

		return turno;
	}

	// actualizar
	public  void actualizar(Turno turno)  {
		
		Session session = conexion.abrirConexion();

		session.beginTransaction();

		session.update(turno);
		

		session.getTransaction().commit();
		conexion.cerrarSession();
	}

	// borrar
	public  void borrar(Turno turno) { // Este turno tiene que venir cargado el id de turnio que se quiere
												// eliminar
		Session session = conexion.abrirConexion();

		session.beginTransaction();
		session.delete(turno);

		session.getTransaction().commit();
		conexion.cerrarSession();
	}

	// listar
	public  List<Turno> leerTodos() {
		
		Session session = conexion.abrirConexion();

		session.beginTransaction();

		Query query = session.getNamedQuery("findAllTurnos");
		List<Turno> lista = query.list();

		return lista;
	}

	// existe
	public  boolean existe(Long id) {
		boolean existe = false;

		if (leer(id) != null) {
			existe = true;
		}

		return existe;
	}

	public  long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {
		
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

	public  long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {
		
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
