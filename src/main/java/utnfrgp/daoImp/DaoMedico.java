package utnfrgp.daoImp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utnfrgp.dao.IDaoMedico;
import utnfrgp.entidad.Medico;

public class DaoMedico implements IDaoMedico {
	
	private Conexion conexion;

    public DaoMedico() {
    }

    public DaoMedico(Conexion conexion) {
		this.conexion = conexion;
	}

	public boolean add(Medico medico) {
        boolean estado = true;
        conexion = new Conexion();
		Session session = null;

        try {
        	session = conexion.abrirConexion();
			session.beginTransaction();
            session.save(medico);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
        }

        return estado;
    }

    public Medico readOne(Long matriculaMedico) {
    	Session session = conexion.abrirConexion();
		session.beginTransaction();
        Medico medico = (Medico) session.get(Medico.class, matriculaMedico);
        return medico;
    }

    public boolean exist(Long matriculaMedico) {
    	Session session = conexion.abrirConexion();
		session.beginTransaction();
        Medico medico = (Medico) session.get(Medico.class, matriculaMedico);
        return medico != null;
    }

    public boolean update(Medico medico) {
        boolean estado = true;
        Session session = null;
        try {
        	session = conexion.abrirConexion();
            session.beginTransaction();
            session.update(medico);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
        }

        return estado;
    }

    public boolean delete(Medico medico) {
        boolean estado = true;
        conexion = new Conexion();
		Session session = null;

        try {
        	session = conexion.abrirConexion();
			session.beginTransaction();
            session.delete(medico);
            session.flush();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
        }

        return estado;
    }

    public List<Medico> readAll() {
    	conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
        List<Medico> medicos = session.createQuery("FROM Medico").list();
        return medicos;
    }
    
    public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
