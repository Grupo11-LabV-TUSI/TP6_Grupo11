package utnfrgp.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import utnfrgp.daoImp.Conexion;
import utnfrgp.daoImp.DaoPaciente;
import utnfrgp.entidad.Paciente;
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

	/** BEANS NEGOCIO */
	/* Bean PacienteNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PacienteNegocio PacienteNegocioBean() {
		PacienteNegocio pacienteNegocio = new PacienteNegocio();
		pacienteNegocio.setDaoPaciente(DaoPacienteBean());
		return pacienteNegocio;
	}

	/** BEANS ENTIDADES */
	/* Los Beans de Pacientes */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Paciente PacienteBean() {
		return new Paciente(0, "sinNombre", "sinApellido", "sinEmail", "sinTelefono", LocalDate.now(), "sinDireccion",
				"sinLocalidad", "sinProvincia", true);
	}
}
