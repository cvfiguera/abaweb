package cl.aba.model.web.dao;

import java.util.List;
import cl.aba.model.web.common.EESView;
import cl.aba.model.web.vo.Parametro;

public interface EESViewDao {
	
	public EESView getEES(int concursoId, int rbdId);

	public List<EESView> getEESAll();
	
	public List<EESView> getEES(Integer draw, Integer start, Integer length, 
			String sortColumn, String sortDir);
	
	public List<EESView> getEESWithParam(List<Parametro> parametros);
	
	public List<EESView> getEESWithParamLimit(List<Parametro> parametros, 
			Integer draw, Integer start, Integer length, String T, String sortDir);
	
	public Long getEESTotal();
	
	public Long getEESTotalWithParam(List<Parametro> parametros);

}
