package cl.aba.model.web.dao;

import java.util.List;

import cl.aba.model.web.common.ListaEspera;

public interface ListasEsperaDao {

	public List<ListaEspera> getListasEspera (int concursoId, int rbdId);
	
}
