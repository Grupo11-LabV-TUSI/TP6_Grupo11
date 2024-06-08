package utnfrgp.daoImp;
import utnfrgp.dao.IDaoUsuario;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

import javax.transaction.Transaction;


public class DaoUsuario implements IDaoUsuario{
    
    private SessionFactory sessionFactory;



    public void add(Usuario usuario) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUsuario(Usuario usuario) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
    }


    public void delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Usuario user = (Usuario) session.get(Usuario.class, id);
        if (user != null) {
            session.delete(id);
        }
        session.getTransaction().commit();
        session.close();
    }


    public Usuario exist(int id) {
        Session session = sessionFactory.openSession();
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        session.close();
        return usuario;
    }


    public List<Usuario> readAll() {
        Session session = sessionFactory.openSession();
        List<Usuario> usuarios = session.createQuery("from Usuario").list();
        session.close();
        return usuarios;
    }



	
}
