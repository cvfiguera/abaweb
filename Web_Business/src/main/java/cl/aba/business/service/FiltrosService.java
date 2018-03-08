package cl.aba.business.service;

import java.util.List;

import cl.aba.business.vo.EstadoSinIdVo;
import cl.aba.business.vo.EstadoVo;

public interface FiltrosService {
	
	public List<EstadoVo> getConcursos();
	
	public List<EstadoVo> getOperadoras();
	
	public List<EstadoVo> getAdjudicadoEstados();
	
	public List<EstadoVo> getAdjudicadoSubestados(int adjudicado_sub_id);
	
	public List<EstadoVo> getConectadoEstados();
	
	public List<EstadoVo> getMineducEstados();
	
	public List<EstadoVo> getTecnologias();
	
	public List<EstadoVo> getRegiones();
	
	public List<EstadoVo> getComunas(int region_id);
	
	public List<EstadoVo> getOperadorasOld();
	
	public List<EstadoSinIdVo> getCategoriasOld();
	
	public List<EstadoSinIdVo> getTipoOld();
	
	public List<EstadoSinIdVo> getEstadoOld();
	
	public List<EstadoVo> getTecnologiaOld();
	
	public List<EstadoVo> getRegionesOld();
	
	public List<EstadoVo> getComunasOld(Integer id);
	
	
}
