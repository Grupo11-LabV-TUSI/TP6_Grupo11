package utnfrgp.negocio;

import java.sql.Date;
import java.util.List;

import utnfrgp.entidad.Turno;

public interface ITurnoNegocio {
	
	// crear
	public  void add(Turno turno);


	// leer
	public  Turno leer(Long id);
	// actualizar
	public  void actualizar(Turno turno);
	// borrar
	public  void borrar(Turno turno);
	// listar
	public  List<Turno> leerTodos();
	// existe
	public  boolean existe(Long id);
	
	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate);
	
	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate);


}
