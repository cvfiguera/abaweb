package cl.aba.business.service;

import cl.aba.business.vo.EscuelasVo;
import cl.aba.business.vo.FASVo;
import cl.aba.business.vo.FiltroEscuelas;
import cl.aba.business.vo.FiltroTicket;
import cl.aba.business.vo.TicketVo;

import java.io.File;
import java.nio.file.Path;

import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableRequestTicket;
import cl.aba.business.vo.DatatableResponse;

public interface BusquedaService {

	public EscuelasVo getEscuelaDetalle(int rbdId, int concursoId);
	
	public DatatableResponse getListadoEscuelas(DatatableRequest request);
	
	public FASVo getFASDetalle(int rbdId, int concursoId);
	
	public DatatableResponse getListadoFAS(DatatableRequest request);
	
	public TicketVo getTicketDetalle(Integer nro_ticket);
	
	public DatatableResponse getListadoTicket(DatatableRequestTicket request);
	
	public File getReporteEscuelas(FiltroEscuelas filtros);
	
	public File getReporteTickets(FiltroTicket filtros);
	
}
