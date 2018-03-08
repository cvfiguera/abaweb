package cl.aba.model.web.dao;

import java.util.List;

import cl.aba.model.web.common.Instalaciones;

public interface InstalacionesDao {
	
	public List<Instalaciones> getInstalaciones(int concursoId, int rbdId);
	
}
