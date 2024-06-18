package utnfrgp.TP6_Grupo11;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import utnfrgp.daoImp.DaoTurno;
import utnfrgp.entidad.Especialidad;
import utnfrgp.entidad.Horario;
import utnfrgp.entidad.Medico;
import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Turno;
import utnfrgp.entidad.Usuario;
import utnfrgp.negocioImpl.EspecialidadNegocio;
import utnfrgp.negocioImpl.MedicoNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;
import utnfrgp.negocioImpl.TurnoNegocio;
import utnfrgp.resources.Config;

public class App {
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";

	public static void main(String[] args) {
		System.out.println("Hello World!");

		boolean estado = false;
		boolean estadoEsp = false;

		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
		
		//Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio)appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad)appContext.getBean("EspecialidadBean");
		
		especialidadNegocio.add(especialidad);
		System.out.println(especialidad.toString());
		  
		
		
		//Paciente 
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");

		Paciente paciente;

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
	
		
		
		//Turno
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno)appContext.getBean("turnoNuevo");
		
		turnoNegocio.add(turno);
		
		
		
		System.out.println(turno.toString());
		
		
		
		
		//Medico
        // Obtener el bean MedicoNegocio
        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
        Medico medico = (Medico)appContext.getBean("MedicoBean");
        
        medicoNegocio.add(medico);
        
        System.out.println(medico.toString());
   
	}
}
