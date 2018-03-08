package cl.aba.model.old.dao;

import java.util.Date;
import java.util.List;

import cl.aba.model.old.common.Comuna;
import cl.aba.model.old.common.Region;
import cl.aba.model.old.common.TicketView;
import cl.aba.model.web.vo.FiltroSinIdVo;
import cl.aba.model.web.vo.FiltroVo;
import cl.aba.model.web.vo.Parametro;

public interface TicketViewDao {
	
	public List<FiltroVo> getFiltroOperadoras();
	
	public List<FiltroSinIdVo> getFiltroCategorias();
	
	public List<FiltroSinIdVo> getFiltroTipo();
	
	public List<FiltroSinIdVo> getFiltroEstado();
	
	public List<FiltroVo> getFiltroTecnologia();
	
	public List<Region> getFiltroRegion();
	
	public List<Comuna> getFiltroComuna(Integer id);

	public Long getTotalRegistros();
	
	public Long getRegistrosFiltrados(List<Parametro> parametros, Date fechaIni, Date fechaFin);
	
	public TicketView getTicketDetail(int ticket);
	
	public List<TicketView> getTicketsAll();
	
	public List<TicketView> getTickets(Integer draw, Integer start, Integer length, 
			String sortColumn, String sortDir);
	
	public List<TicketView> getTicketWithParams(List<Parametro> parametros, Date fechaIni, Date fechaFin);
	
	public List<TicketView> getTicketWithParamsLimit(List<Parametro> parametros, 
			Date fechaIni, Date fechaFin, Integer draw, Integer start, 
			Integer length, String T, String sortDir);
	
	public List<TicketView> getTicketByRbd(Long rbd);
}
