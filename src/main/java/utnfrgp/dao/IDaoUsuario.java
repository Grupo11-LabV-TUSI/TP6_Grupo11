package utnfrgp.dao;

import java.util.List;

import utnfrgp.entidad.Usuario;

public interface IDaoUsuario {
	void add(Usuario paciente);
	void updateUsuario(Usuario paciente);
	void delete(int idUsuario);
	Usuario exist(int idUsuario);	
	public List<Usuario> readAll();
}
