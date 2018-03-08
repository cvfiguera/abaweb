package cl.aba.model.security.dao;

import org.springframework.stereotype.Repository;

import cl.aba.model.security.common.Usuarios;

@Repository
public class UsuariosDaoImpl extends HibernateSecurity implements UsuariosDao {

	@Override
	public Usuarios getUsuarios() {
		return null;
	}

	@Override
	public Usuarios getUsuario(String username) {
		String hql = "from Usuarios u where u.usuario = '" + username + "'";
		return (Usuarios) this.getObjectHqlUnique((new Usuarios()), hql);
	}

	@Override
	public void saveUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsuario(Usuarios usuario) {
		updateObject(usuario);
	}

	@Override
	public void deleteUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		
	}

}
