package utnfrgp.daoImp;

import java.util.List;
import org.hibernate.Session;
import utnfrgp.dao.IDaoHorario;
import utnfrgp.entidad.Horario;

public class DaoHorario implements IDaoHorario {

    private Conexion conexion;

    public DaoHorario() {}

    public DaoHorario(Conexion conexion) {
        this.conexion = conexion;
    }

    public boolean add(Horario horario) {
        boolean estado = true;
        conexion = new Conexion();
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            session.save(horario);
            session.flush();
            session.getTransaction().commit();

            Horario savedHorario = (Horario) session.get(Horario.class, horario.getId());
            if (savedHorario == null) {
                estado = false;
            }
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

    public Horario readOne(int idHorario) {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        Horario horario = (Horario) session.get(Horario.class, idHorario);
        return horario;
    }

    public boolean exist(int idHorario) {
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        Horario horario = (Horario) session.get(Horario.class, idHorario);
        boolean exists = (horario != null);
        return exists;
    }

    public boolean update(Horario horario) {
        boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            session.update(horario);
            session.flush();
            session.getTransaction().commit();

            Horario updatedHorario = (Horario) session.get(Horario.class, horario.getId());
            if (!updatedHorario.equals(horario)) {
                estado = false;
            }
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

    public boolean delete(Horario horario) {
        boolean estado = true;
        conexion = new Conexion();
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            session.delete(horario);
            session.flush();
            session.getTransaction().commit();

            Horario deletedHorario = (Horario) session.get(Horario.class, horario.getId());
            if (deletedHorario != null) {
                estado = false;
            }
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

    public List<Horario> readAll() {
        conexion = new Conexion();
        Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Horario> horarios = session.createQuery("FROM Horario").list();
        return horarios;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
}
