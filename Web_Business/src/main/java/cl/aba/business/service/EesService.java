package cl.aba.business.service;

import java.util.List;

import cl.aba.business.vo.AdjudicacionVo;
import cl.aba.business.vo.ContactoVo;
import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableResponse;
import cl.aba.business.vo.EESDetalle;
import cl.aba.business.vo.EESVo;
import cl.aba.business.vo.InstalacionVo;
import cl.aba.business.vo.ListaEsperaVo;
import cl.aba.business.vo.TicketVo;

public interface EesService {
	
	public DatatableResponse getEESAll(DatatableRequest parametros);
	
	public InstalacionVo getEESInstalacion(int concursoId, int rbdId);
	
	public AdjudicacionVo getEESAdjudicacion(int concursoId, int rbdId);
	
	public List<ListaEsperaVo> getEESListaEspera(int concursoId, int rbdId);
	
	public List<TicketVo> getEESTickets(int concursoId, int rbdId);
	
	public List<ContactoVo> getEESContactos(int rbdId);

}
