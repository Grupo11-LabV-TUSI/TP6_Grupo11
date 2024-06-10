package utnfrgp.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import utnfrgp.daoImp.Conexion;
import utnfrgp.daoImp.DaoEspecialidad;
import utnfrgp.daoImp.DaoPaciente;
import utnfrgp.entidad.Especialidad;
import utnfrgp.entidad.Paciente;
import utnfrgp.negocioImpl.EspecialidadNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;

public class Config {
	/** BEANS CAPAS */
	/* Bean Conexion */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Conexion ConexionBean() {
		return new Conexion();
	}

	/** BEANS DAO */
	/* Bean DaoPaciente */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoPaciente DaoPacienteBean() {
		DaoPaciente daoPaciente = new DaoPaciente();
		daoPaciente.setConexion(ConexionBean());
		return daoPaciente;
	}

	/* Bean DaoEspecialidad */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoEspecialidad DaoEspecialidadBean() {
		DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
		daoEspecialidad.setConexion(ConexionBean());
		return daoEspecialidad;
	}

	/** BEANS NEGOCIO */
	/* Bean PacienteNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PacienteNegocio PacienteNegocioBean() {
		PacienteNegocio pacienteNegocio = new PacienteNegocio();
		pacienteNegocio.setDaoPaciente(DaoPacienteBean());
		return pacienteNegocio;
	}

	/* Bean EspecialidadNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EspecialidadNegocio EspecialidadNegocioBean() {
		EspecialidadNegocio especialidadNegocio = new EspecialidadNegocio();
		especialidadNegocio.setDaoEspecialidad(DaoEspecialidadBean());
		return especialidadNegocio;
	}

	/** BEANS ENTIDADES */
	/* Los Beans de Pacientes */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Paciente PacienteBean() {
		return new Paciente(0, "sinNombre", "sinApellido", "sinEmail", "sinTelefono", LocalDate.now(), "sinDireccion",
				"sinLocalidad", "sinProvincia", true);
	}

	/* Los Beans de Especialidad */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Especialidad EspecialidadBean() {
		return new Especialidad("SinDescripcion");
	}
}
