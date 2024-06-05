package utnfrgp.TP6_Grupo11;

import java.time.LocalDate;

import utnfrgp.dao.IDaoPaciente;
import utnfrgp.daoImp.DaoPaciente;
import utnfrgp.entidad.Paciente;
import utnfrgp.negocio.IPacienteNegocio;
import utnfrgp.negocioImpl.PacienteNegocio;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IDaoPaciente daoPaciente = new DaoPaciente();
        IPacienteNegocio pacienteNegocio = new PacienteNegocio(daoPaciente);
        Paciente paciente = new Paciente(1, "nombre1", "apellido1", "email1", "telefono1", LocalDate.now(), "direccion1", "localidad1", "provincia1", true);
        
        System.out.println(paciente);
        
        pacienteNegocio.add(paciente);
        System.out.println(pacienteNegocio.readOne(paciente.getDni()));
    }
}
