package utnfrgp.resources;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import utnfrgp.daoImp.Conexion;
import utnfrgp.daoImp.DaoEspecialidad;
import utnfrgp.daoImp.DaoHorario;
import utnfrgp.daoImp.DaoMedico;
import utnfrgp.daoImp.DaoPaciente;
import utnfrgp.daoImp.DaoTurno;
import utnfrgp.daoImp.DaoUsuario;
import utnfrgp.entidad.Especialidad;
import utnfrgp.entidad.Horario;
import utnfrgp.entidad.Medico;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Turno;
import utnfrgp.entidad.Usuario;
import utnfrgp.enums.EDiaHorario;
import utnfrgp.enums.EEstadoTurno;
import utnfrgp.negocioImpl.EspecialidadNegocio;
import utnfrgp.negocioImpl.HorarioNegocio;
import utnfrgp.negocioImpl.MedicoNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;
import utnfrgp.negocioImpl.TurnoNegocio;
import utnfrgp.negocioImpl.UsuarioNegocio;

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

	/* Bean DaoUsuario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoUsuario DaoUsuarioBean() {
		DaoUsuario daoUsuario = new DaoUsuario();
		daoUsuario.setConexion(ConexionBean());
		return daoUsuario;
	}

	/* Bean DaoHorario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoHorario DaoHorarioBean() {
		DaoHorario daoHorario = new DaoHorario();
		daoHorario.setConexion(ConexionBean());
		return daoHorario;
	}

	/* Bean DaoMedico */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoMedico DaoMedicoBean() {
		DaoMedico daoMedico = new DaoMedico();
		daoMedico.setConexion(ConexionBean());
		return daoMedico;
	}
	
	/* Bean DaoTurno */
	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DaoTurno DaoTurnoBean() {		
		DaoTurno daoTurno = new DaoTurno();		
		daoTurno.setConexion(ConexionBean());
        return daoTurno;
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

	/* Bean UsuarioNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UsuarioNegocio UsuarioNegocioBean() {
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		usuarioNegocio.setDaoUsuario(DaoUsuarioBean());
		return usuarioNegocio;
	}

	/* Bean HorarioNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HorarioNegocio HorarioNegocioBean() {
		HorarioNegocio horarioNegocio = new HorarioNegocio();
		horarioNegocio.setDaoHorario(DaoHorarioBean());
		return horarioNegocio;
	}

	/* Bean MedicoNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MedicoNegocio MedicoNegocioBean() {
		MedicoNegocio medicoNegocio = new MedicoNegocio();
		medicoNegocio.setDaoMedico(DaoMedicoBean());
		return medicoNegocio;
	}
	
	/* Bean TurnoNegocio */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TurnoNegocio TurnoNegocioBean() {
    	TurnoNegocio  turnoNegocio = new TurnoNegocio();
    	turnoNegocio.setDaoTurno(DaoTurnoBean());
        return turnoNegocio;
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
		return new Especialidad(0,"SinNombre");
	}

	/* Los Beans de Usuario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario UsuarioBean() {
		return new Usuario(0L, "SinUsuario", "SinContraseña", true);
	}

	/* Los Beans de Horario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Horario HorarioBean() {
		return new Horario(EDiaHorario.Lunes, LocalTime.now(), LocalTime.now().plusHours(1L));
	}

	/* Los Beans de Medico */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Medico MedicoBean() {
		Set<Horario> setEHorarios = new HashSet<Horario>();	
		setEHorarios.add(new Horario(EDiaHorario.Lunes, LocalTime.now(), LocalTime.now().plusHours(1L)));		
		return new Medico(0L,
				"SinNommbre",
				"SinApellido",
				"SinEmail",
				"SinTelefono",
				LocalDate.now(),
				new Usuario(0L, "SinUsuario", "SinContraseña", true),
				new Especialidad(0,"SinNombre"),
				setEHorarios,
				true);
	}
	
	/* Bean Turno */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Turno TurnoBean() {    	
    	Turno nuevoTurno = new Turno();
    	Set<Horario> setEHorarios = new HashSet<Horario>();		
		setEHorarios.add(new Horario(EDiaHorario.Lunes, LocalTime.now(), LocalTime.now().plusHours(1L)));
    	nuevoTurno.setMedico(new Medico(0L,
				"SinNommbre",
				"SinApellido",
				"SinEmail",
				"SinTelefono",
				LocalDate.now(),
				new Usuario(0L, "SinUsuario", "SinContraseña", true),
				new Especialidad(0,"SinNombre"),
				setEHorarios,
				true));
    	nuevoTurno.setPaciente(new Paciente(0, "sinNombre", "sinApellido", "sinEmail", "sinTelefono", LocalDate.now(), "sinDireccion",
				"sinLocalidad", "sinProvincia", true));
    	nuevoTurno.setFecha(LocalDate.now());
    	nuevoTurno.setHora(LocalTime.now());
    	nuevoTurno.setObservacion("SinObservacion");
    	nuevoTurno.setEstado(true);
    	nuevoTurno.setEstadoTurno(EEstadoTurno.Pendiente);
    	return nuevoTurno;
    }

}
