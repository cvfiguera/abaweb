package cl.aba.model.web.dao;

import java.util.List;
import cl.aba.model.web.common.EscuelasView;
import cl.aba.model.web.vo.Parametro;

public interface EscuelasViewDao {

	public EscuelasView getEscuela(int rbdId, int concursoId);

	public List<EscuelasView> getEscuelasAll();
	
	public List<EscuelasView> getEscuelas(Integer draw, Integer start, Integer length, 
			String sortColumn, String sortDir);
	
	public List<EscuelasView> getEscuelasWithParam(List<Parametro> parametros);
	
	public List<EscuelasView> getEscuelasWithParamLimit(List<Parametro> parametros, 
			Integer draw, Integer start, Integer length, String sortColumn, String sortDir);
	
	public Long getTotalEscuelas();
	
	public Long getTotalEscuelasWithParam(List<Parametro> parametros);
}
