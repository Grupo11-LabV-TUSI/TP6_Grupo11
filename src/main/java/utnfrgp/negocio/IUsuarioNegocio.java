package utnfrgp.negocio;
import java.util.List;

import utnfrgp.entidad.Usuario;
public interface IUsuarioNegocio {
	public boolean add(Usuario usuario);
	public Usuario getById(int id);
	public boolean update(Usuario paciente);
	public boolean delete(Usuario paciente);
	public List<Usuario> readAll();
}
