package utnfrgp.dao;

import java.util.List;

import utnfrgp.entidad.Paciente;
import utnfrgp.entidad.Usuario;

public interface IDaoUsuario {
	public boolean add(Usuario usuario);
	public Usuario readOne(Long idUsuario);
	public boolean exist(Long idUsuario);
	public boolean update(Usuario usuario);
	public boolean delete(Usuario usuario);
	public List<Usuario> readAll();
}
