package utnfrgp.daoImp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utnfrgp.dao.IDaoMedico;
import utnfrgp.entidad.Medico;

public class DaoMedico implements IDaoMedico {
	
	private Conexion conexion;

    private SessionFactory sessionFactory;

    public DaoMedico() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public boolean add(Medico medico) {
        boolean estado = true;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(medico);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
            session.close();
        }

        return estado;
    }

    public Medico readOne(Long id) {
        Session session = sessionFactory.openSession();
        Medico medico = (Medico) session.get(Medico.class, id);
        session.close();
        return medico;
    }

    public boolean exist(Long id) {
        Session session = sessionFactory.openSession();
        Medico medico = (Medico) session.get(Medico.class, id);
        session.close();
        return medico != null;
    }

    public boolean update(Medico medico) {
        boolean estado = true;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.update(medico);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
            session.close();
        }

        return estado;
    }

    public boolean delete(Medico medico) {
        boolean estado = true;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(medico);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            estado = false;
        } finally {
            session.close();
        }

        return estado;
    }

    public List<Medico> readAll() {
        Session session = sessionFactory.openSession();
        List<Medico> medicos = session.createQuery("FROM Medico").list();
        session.close();
        return medicos;
    }
    
    public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
