package utnfrgp.negocio;

import java.sql.Date;
import java.util.List;

import utnfrgp.entidad.Turno;

public interface ITurnoNegocio {
	// crear
	public boolean add(Turno turno);

	// leer
	public Turno leer(Long id);

	// existe
	public boolean existe(Long id);

	// actualizar
	public boolean actualizar(Turno turno);

	// borrar
	public boolean borrar(Turno turno);

	// listar
	public List<Turno> leerTodos();

	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate);

	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate);

}
