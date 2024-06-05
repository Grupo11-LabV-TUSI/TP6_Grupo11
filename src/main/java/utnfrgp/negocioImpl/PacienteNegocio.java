package utnfrgp.negocioImpl;

import java.util.List;

import utnfrgp.dao.IDaoPaciente;
import utnfrgp.entidad.Paciente;
import utnfrgp.negocio.IPacienteNegocio;

public class PacienteNegocio implements IPacienteNegocio{
	
	//Necesario para spring core
	private IDaoPaciente daoPaciente;

	public PacienteNegocio() {}

	public PacienteNegocio(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public IDaoPaciente getDaoPaciente() {
		return daoPaciente;
	}
	
	public void setDaoPaciente(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	// Hasta aquí: Necesario para spring core

	public boolean add(Paciente paciente) {
		return daoPaciente.add(paciente);
	}

	public Paciente readOne(int dniPaciente) {
		return daoPaciente.readOne(dniPaciente);
	}

	public boolean exist(int dniPaciente) {
		return daoPaciente.exist(dniPaciente);
	}

	public boolean update(Paciente paciente) {
		return daoPaciente.update(paciente);
	}

	public boolean delete(Paciente paciente) {
		return daoPaciente.delete(paciente);
	}

	public List<Paciente> readAll() {
		return daoPaciente.readAll();
	}

}
