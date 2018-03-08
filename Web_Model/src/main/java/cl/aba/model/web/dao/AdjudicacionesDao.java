package cl.aba.model.web.dao;

import java.util.List;

import cl.aba.model.web.common.Adjudicaciones;
import cl.aba.model.web.common.RbdConcursos;
import cl.aba.model.web.common.RbdEstados;

public interface AdjudicacionesDao {
	
	public List<Adjudicaciones> getAdjudicaciones(int concursoId, int rbdId);
	
	public RbdEstados getRbdEstados(int concursoId, int rbdId);

}
