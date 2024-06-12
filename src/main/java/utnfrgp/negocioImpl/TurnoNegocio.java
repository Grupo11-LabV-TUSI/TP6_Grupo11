package utnfrgp.negocioImpl;

import java.sql.Date;
import java.util.List;

import utnfrgp.dao.IDaoTurno;
import utnfrgp.daoImp.DaoTurno;
import utnfrgp.entidad.Turno;
import utnfrgp.negocio.ITurnoNegocio;

public class TurnoNegocio implements ITurnoNegocio {
	
	private IDaoTurno daoTurno; 
	
	public TurnoNegocio() {}
	
	public IDaoTurno getDaoTurno() {
		return daoTurno;
	}


	public void setDaoTurno(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}
	

	public void add(Turno turno) {
		
		 daoTurno.add(turno);
		 
		
	}
	
	
	public Turno leer(Long id) {
		
		return daoTurno.leer(id);
	}

	public void actualizar(Turno turno) {
		daoTurno.actualizar(turno);
		
	}

	public void borrar(Turno turno) {
		daoTurno.borrar(turno);
	}

	public List<Turno> leerTodos() {

			return daoTurno.leerTodos();
			
			
	}

	public boolean existe(Long id) {
		return daoTurno.existe(id);
	}

	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
	
	
	
	

}
