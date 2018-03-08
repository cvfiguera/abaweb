package cl.aba.model.security.dao;

import cl.aba.model.security.common.Usuarios;

public interface UsuariosDao {
	
	public Usuarios getUsuarios();
	
	public Usuarios getUsuario(String username);
	
	public void saveUsuario(Usuarios usuario);
	
	public void updateUsuario(Usuarios usuario);
	
	public void deleteUsuario(Usuarios usuario);

}
