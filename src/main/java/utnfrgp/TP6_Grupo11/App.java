package utnfrgp.TP6_Grupo11;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import utnfrgp.entidad.Especialidad;
import utnfrgp.entidad.Horario;
import utnfrgp.entidad.Medico;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Turno;
import utnfrgp.entidad.Usuario;
import utnfrgp.enums.EDiaHorario;
import utnfrgp.negocioImpl.EspecialidadNegocio;
import utnfrgp.negocioImpl.HorarioNegocio;
import utnfrgp.negocioImpl.MedicoNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;
import utnfrgp.negocioImpl.TurnoNegocio;
import utnfrgp.negocioImpl.UsuarioNegocio;
import utnfrgp.resources.Config;

public class App {
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";

	public static void main(String[] args) {
		System.out.println("Hello World!");

		boolean estado = false;

		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

		/** Carga de datos */
		/*
		 * PacienteNegocio pacienteNegocio = (PacienteNegocio)
		 * appContext.getBean("PacienteNegocioBean"); Paciente paciente = (Paciente)
		 * appContext.getBean("PacienteBean");
		 * 
		 * EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio)
		 * appContext.getBean("EspecialidadNegocioBean"); Especialidad especialidad =
		 * (Especialidad) appContext.getBean("EspecialidadBean");
		 * 
		 * UsuarioNegocio usuarioNegocio = (UsuarioNegocio)
		 * appContext.getBean("UsuarioNegocioBean"); Usuario usuario = (Usuario)
		 * appContext.getBean("UsuarioBean");
		 * 
		 * HorarioNegocio horarioNegocio = (HorarioNegocio)
		 * appContext.getBean("HorarioNegocioBean"); Horario horario = (Horario)
		 * appContext.getBean("HorarioBean"); Set<Horario> setHorario = new
		 * HashSet<Horario>(); setHorario.add(horario);
		 * 
		 * MedicoNegocio medicoNegocio = (MedicoNegocio)
		 * appContext.getBean("MedicoNegocioBean"); Medico medico = (Medico)
		 * appContext.getBean("MedicoBean"); medico.setUsuario(usuario);
		 * medico.setEspecialidad(especialidad); medico.setHorarios(setHorario);
		 * 
		 * TurnoNegocio turnoNegocio = (TurnoNegocio)
		 * appContext.getBean("TurnoNegocioBean"); Turno turno = (Turno)
		 * appContext.getBean("TurnoBean"); turno.setMedico(medico);
		 * turno.setPaciente(paciente);
		 * 
		 * try { estado = turnoNegocio.add(turno); //
		 * System.out.println(MENSAJE_AGREGADO); } catch (Exception e) { // TODO: handle
		 * exception // System.err.println(MENSAJE_YA_EXISTE); e.printStackTrace(); }
		 * finally { System.out.println(turno.toString());
		 * System.out.println(MENSAJE_YA_EXISTE); }
		 */

		// Paciente
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
		Paciente paciente = (Paciente) appContext.getBean("PacienteBean");

		try {
			estado = pacienteNegocio.add(paciente);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(paciente.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		for (int i = 0; i < 2; i++) {
			paciente = (Paciente) appContext.getBean("PacienteBean");
			paciente.setDni(1 + i);
			paciente.setNombre("nombre" + (1 + i));
			paciente.setApellido("apellido" + (1 + i));
			paciente.setEmail("email" + (1 + i));
			paciente.setTelefono("telefono" + (1 + i));
			paciente.setFecha_nacimiento(LocalDate.of(1900 + (1 + i), 1, 1));
			paciente.setDireccion("direccion" + (1 + i));
			paciente.setLocalidad("localidad" + (1 + i));
			paciente.setProvincia("provincia" + (1 + i));
			paciente.setEstado(true);

			// VERIFICAR QUE NO EXISTE EL USUARIO PARA AGREGARLO
			estado = pacienteNegocio.exist(paciente.getDni());
			if (estado == false) {
				pacienteNegocio.add(paciente);
				System.out.println(MENSAJE_AGREGADO);
			} else {
				System.out.println(MENSAJE_YA_EXISTE);
			}
			System.out.println(pacienteNegocio.readOne(paciente.getDni()));
		}
		// Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");

		try {
			estado = especialidadNegocio.add(especialidad);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(especialidad.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Usuario
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
		Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");

		try {
			estado = usuarioNegocio.add(usuario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(usuario.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Horario
		HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
		Horario horario = (Horario) appContext.getBean("HorarioBean");
		Set<Horario> setHorario = new HashSet<Horario>();
		setHorario.add(horario);

		try {
			estado = horarioNegocio.add(horario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			for (Horario horario2 : setHorario) {
				System.out.println(horario2.toString());
			}
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Medico
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		Medico medico = (Medico) appContext.getBean("MedicoBean");
		medico.setUsuario(usuario);
		medico.setEspecialidad(especialidad);
		medico.setHorarios(setHorario);

		try {
			estado = medicoNegocio.add(medico);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(medico.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		
		// Turno
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno) appContext.getBean("TurnoBean");
		medico = medicoNegocio.readOne(1L);
		paciente = pacienteNegocio.readOne(1);
		System.err.println("datos para el turno");
		//System.out.println(medico);
		//System.out.println(paciente);
		turno.setMedico(medico);
		turno.setPaciente(paciente);

		try {
			estado = turnoNegocio.add(turno);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(turno.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}
		

		/** Lecturas de datos */
		// Pacientes
		List<Paciente> listaPaciente = pacienteNegocio.readAll();
		System.err.println("Listando pacientes");
		for (Paciente paciente2 : listaPaciente) {
			System.out.println(paciente2.toString());
		}

		// Especialidad
		List<Especialidad> listaEspecialidad = especialidadNegocio.readAll();
		System.err.println("Listando Especialidad");
		for (Especialidad especialidad2 : listaEspecialidad) {
			System.out.println(especialidad2.toString());
		}

		// Usuario
		List<Usuario> listaUsuario = usuarioNegocio.readAll();
		System.err.println("Listando Usuario");
		for (Usuario usuario2 : listaUsuario) {
			System.out.println(usuario2.toString());
		}

		// Horario
		List<Horario> listaHorario = horarioNegocio.readAll();
		System.err.println("Listando horarios");
		for (Horario horario2 : listaHorario) {
			System.out.println(horario2.toString());
		}

		// Medico
		List<Medico> listaMedico = medicoNegocio.readAll();
		System.err.println("Listando Medico");
		for (Medico medico2 : listaMedico) {
			System.out.println(medico2.toString());
			System.out.println(medicoNegocio.readOne(medico2.getMatricula()).toString());
		}
		
		
		// Turno
		List<Turno> listaTurno = turnoNegocio.leerTodos();
		System.err.println("Listando Turno");
		for (Turno turno2 : listaTurno) {
			System.out.println(turno2.toString());
			System.out.println(turnoNegocio.leer(turno2.getId()).toString());
		}
		

	}

}
