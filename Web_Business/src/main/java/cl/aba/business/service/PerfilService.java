package cl.aba.business.service;

import cl.aba.business.vo.PerfilVO;

public interface PerfilService {
	
	public PerfilVO getPerfil(String username);
	
	public void updatePerfil(PerfilVO perfil, String username);

}
