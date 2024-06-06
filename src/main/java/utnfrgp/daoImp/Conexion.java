package utnfrgp.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Conexion {

	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;

	public Conexion() {
		// Este new configuration no se puede sacar a un bean, es un new de c�digo de
		// hibernate
		configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public Session abrirConexion() {
		session = sessionFactory.openSession();
		return session;
	}

	public void cerrarSession() {
		session.close();
		cerrarSessionFactory();
	}

	private void cerrarSessionFactory() {
		sessionFactory.close();
	}
}
