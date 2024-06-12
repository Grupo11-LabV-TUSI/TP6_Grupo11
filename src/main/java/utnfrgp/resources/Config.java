package utnfrgp.resources;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import utnfrgp.daoImp.Conexion;
import utnfrgp.daoImp.DaoEspecialidad;
import utnfrgp.daoImp.DaoHorario;
import utnfrgp.daoImp.DaoMedico;
import utnfrgp.daoImp.DaoPaciente;
import utnfrgp.entidad.Especialidad;
import utnfrgp.entidad.Horario;
import utnfrgp.entidad.Medico;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Turno;
import utnfrgp.negocioImpl.EspecialidadNegocio;
import utnfrgp.negocioImpl.HorarioNegocio;
import utnfrgp.negocioImpl.MedicoNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;
import org.springframework.context.annotation.Configuration;

@Configuration
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
	
	/* Bean DaoMedico */
	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DaoMedico DaoMedicoBean() {
        DaoMedico daoMedico = new DaoMedico();
        daoMedico.setConexion(ConexionBean());
        return daoMedico;
    }
	
	/* Bean DaoHorario */
	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DaoHorario DaoHorarioBean() {
		DaoHorario daoHorario = new DaoHorario();
		daoHorario.setConexion(ConexionBean());
        return daoHorario;
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
	
	/* Bean MedicoNegocio */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MedicoNegocio MedicoNegocioBean() {
        MedicoNegocio medicoNegocio = new MedicoNegocio();
        medicoNegocio.setDaoMedico(DaoMedicoBean());
        return medicoNegocio;
    }
    
    /* Bean HorarioNegocio */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public HorarioNegocio HorarioNegocioBean() {
    	HorarioNegocio horarioNegocio = new HorarioNegocio();
    	horarioNegocio.setDaoHorario(DaoHorarioBean());
        return horarioNegocio;
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
	
	/* Los Beans de Medico */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Medico MedicoBean() {
        return new Medico();
    }
    
    /* Los Beans de Horario */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Horario HorarioBean() {
        return new Horario();
    }
    
    //Bean Turno
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Turno turnoNuevo() {
    	
    	Turno nuevoTurno = new Turno();
    	nuevoTurno.setMedico(MedicoBean());
    	nuevoTurno.setFecha(LocalDate.now());
    	nuevoTurno.setHora(LocalTime.now());
    	nuevoTurno.setPaciente(PacienteBean());
    	return nuevoTurno;
    }
    
}
