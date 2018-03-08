package cl.aba.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aba.business.vo.PerfilVO;
import cl.aba.model.security.common.Usuarios;
import cl.aba.model.security.dao.UsuariosDao;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private UsuariosDao usuarioDao;
	
	@Override
	public PerfilVO getPerfil(String username) {
		Usuarios usuario = this.usuarioDao.getUsuario(username);
		
		return new PerfilVO(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(),
				usuario.getOrganismo(), usuario.getClave(), usuario.getClave(), usuario.getClave());
	}

	@Override
	public void updatePerfil(PerfilVO perfil, String username) {
		Usuarios usuario = this.usuarioDao.getUsuario(username);
		
		usuario.setEmail(perfil.getEmail());
		usuario.setClave(perfil.getNewpass());
		this.usuarioDao.updateUsuario(usuario);		
	}

}
