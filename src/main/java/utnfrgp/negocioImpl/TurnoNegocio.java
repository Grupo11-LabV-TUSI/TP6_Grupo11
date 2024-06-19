package utnfrgp.negocioImpl;

import java.sql.Date;
import java.util.List;

import utnfrgp.dao.IDaoTurno;
import utnfrgp.daoImp.DaoTurno;
import utnfrgp.entidad.Turno;
import utnfrgp.negocio.ITurnoNegocio;

public class TurnoNegocio implements ITurnoNegocio {

	private IDaoTurno daoTurno;

	public TurnoNegocio() {
	}

	public TurnoNegocio(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}

	public IDaoTurno getDaoTurno() {
		return daoTurno;
	}

	public void setDaoTurno(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}

	public boolean add(Turno turno) {
		return daoTurno.add(turno);
	}

	public Turno leer(Long id) {
		return daoTurno.leer(id);
	}

	public boolean existe(Long id) {
		return daoTurno.existe(id);
	}

	public boolean actualizar(Turno turno) {
		return daoTurno.actualizar(turno);
	}

	public boolean borrar(Turno turno) {
		return daoTurno.borrar(turno);
	}

	public List<Turno> leerTodos() {
		return daoTurno.leerTodos();
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
