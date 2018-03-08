package cl.aba.model.web.dao;

import java.util.List;
import cl.aba.model.web.common.FASView;
import cl.aba.model.web.vo.Parametro;

public interface FASViewDao {

	public FASView getFAS(int rbdId, int concursoId);

	public List<FASView> getFASAll();
	
	public List<FASView> getFAS(Integer draw, Integer start, Integer length, 
			String sortColumn, String sortDir);
	
	public List<FASView> getFASWithParam(List<Parametro> parametros);
	
	public List<FASView> getFASWithParamLimit(List<Parametro> parametros, 
			Integer draw, Integer start, Integer length, String sortColumn, String sortDir);
	
	public Long getFasTotal();
	
	public Long getFasTotalWithParam(List<Parametro> parametros);
}
