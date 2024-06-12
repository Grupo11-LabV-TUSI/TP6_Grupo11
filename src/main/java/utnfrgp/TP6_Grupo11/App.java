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
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno)appContext.getBean("turnoNuevo");
		
		turnoNegocio.add(turno);
		
		
		
		System.out.println(turno.toString());
		
		/*	
        // Obtener el bean MedicoNegocio
        MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");

        // Crear horarios para el primer médico
        Horario horario1Medico1 = new Horario("Lunes", LocalTime.of(8, 0), LocalTime.of(12, 0), null);
        Horario horario2Medico1 = new Horario("Martes", LocalTime.of(14, 0), LocalTime.of(18, 0), null);

        // Crear horarios para el segundo médico
        Horario horario1Medico2 = new Horario("Lunes", LocalTime.of(10, 0), LocalTime.of(14, 0), null);
        Horario horario2Medico2 = new Horario("Martes", LocalTime.of(16, 0), LocalTime.of(20, 0), null);

        // Crear listas de horarios
        Set<Horario> horariosMedico1 = new HashSet<Horario>();
        horariosMedico1.add(horario1Medico1);
        horariosMedico1.add(horario2Medico1);

        Set<Horario> horariosMedico2 = new HashSet<Horario>();
        horariosMedico2.add(horario1Medico2);
        horariosMedico2.add(horario2Medico2);

        // Crear médicos
        Medico medico1 = new Medico(123, "Juan", "Perez", "juan.perez@example.com", "123456789",
                LocalDate.of(1980, 1, 1), null, null, true);
        Medico medico2 = new Medico(124, "Ana", "Gomez", "ana.gomez@example.com", "987654321",
                LocalDate.of(1985, 5, 15), null, null, true);

        // Asignar horarios a los médicos
        medico1.setHorarios(horariosMedico1);
        medico2.setHorarios(horariosMedico2);

        // Asignar médicos a los horarios
        for (Horario h : horariosMedico1) {
            h.setMedico(medico1);
        }
        for (Horario h : horariosMedico2) {
            h.setMedico(medico2);
        }

        // Guardar los médicos en la base de datos
        medicoNegocio.add(medico1);
        medicoNegocio.add(medico2);

  */      
        
	}
}
