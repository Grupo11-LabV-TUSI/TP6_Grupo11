package utnfrgp.negocioImpl;

import java.util.List;

import utnfrgp.dao.IDaoEspecialidad;
import utnfrgp.entidad.Especialidad;
import utnfrgp.negocio.IEspecialidadNegocio;

public class EspecialidadNegocio implements IEspecialidadNegocio {

	private IDaoEspecialidad daoEspecialidad;

	public EspecialidadNegocio() {

	}

	public EspecialidadNegocio(IDaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}

	public IDaoEspecialidad getDaoEspecialidad() {
		return daoEspecialidad;
	}

	public void setDaoEspecialidad(IDaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}

	public boolean add(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return daoEspecialidad.add(especialidad);
	}

	public Especialidad readOne(int idEspecialidad) {
		// TODO Auto-generated method stub
		return daoEspecialidad.readOne(idEspecialidad);
	}

	public boolean exist(int idEspecialidad) {
		// TODO Auto-generated method stub
		return daoEspecialidad.exist(idEspecialidad);
	}

	public boolean update(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return daoEspecialidad.update(especialidad);
	}

	public boolean delete(Especialidad especialidad) {
		// TODO Auto-generated method stub
		return daoEspecialidad.delete(especialidad);
	}

	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return daoEspecialidad.readAll();
	}

}
