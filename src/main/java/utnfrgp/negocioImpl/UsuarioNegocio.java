package utnfrgp.negocioImpl;

import java.util.List;

import utnfrgp.dao.IDaoUsuario;
import utnfrgp.entidad.Usuario;
import utnfrgp.negocio.IUsuarioNegocio;

public class UsuarioNegocio implements IUsuarioNegocio{
	
	// Necesario para spring core
	private IDaoUsuario daoUsuario;

	public UsuarioNegocio() {
	}

	public UsuarioNegocio(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public IDaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	// Hasta aquí: Necesario para spring core

	public boolean add(Usuario usuario) {
		return daoUsuario.add(usuario);
	}

	public Usuario readOne(Long idUsuario) {
		return daoUsuario.readOne(idUsuario);
	}

	public boolean exist(Long idUsuario) {
		return daoUsuario.exist(idUsuario);
	}

	public boolean update(Usuario usuario) {
		return daoUsuario.update(usuario);
	}

	public boolean delete(Usuario usuario) {
		return daoUsuario.delete(usuario);
	}

	public List<Usuario> readAll() {
		return daoUsuario.readAll();
	}

}
