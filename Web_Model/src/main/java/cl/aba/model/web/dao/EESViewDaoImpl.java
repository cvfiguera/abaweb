package cl.aba.model.web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.EESView;
import cl.aba.model.web.vo.Parametro;

@Repository
public class EESViewDaoImpl extends HibernateWeb implements EESViewDao {

	@Override
	public EESView getEES(int concursoId, int rbdId) {
		
		String hql = "FROM EESView WHERE concursoId = " + concursoId + " AND rbdId = " + rbdId;
		
		return (EESView) getObjectHqlUnique(new EESView(), hql);
	}

	@Override
	public List<EESView> getEESAll() {
		
		String hql = "FROM EESView";
		
		return (List<EESView>) (List) getObjectListHql(new EESView(), hql);
		
	}

	@Override
	public List<EESView> getEES(Integer draw, Integer start, Integer length, String sortColumn, String sortDir) {

		String hql = "FROM EESView ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<EESView>) (List) getObjectListHqlRange(new EESView(), hql, start, length);
		
	}

	@Override
	public List<EESView> getEESWithParam(List<Parametro> parametros) {
		
		String hql = "FROM EESView WHERE "
				+ "(concursoId = :concurso OR :concurso IS NULL) AND "
				+ "(estadoConectadoId = :instalacion OR :instalacion IS NULL) AND "
				+ "(estadoAdjudicadoId = :adjudicacion OR subEstadoAdjudicadoId = :adjudicacion OR :adjudicacion IS NULL) AND "
				+ "(regionId = :region OR :region IS NULL) AND "
				+ "(comunaId = :comuna OR :comuna IS NULL) AND "
				+ "(rbd =:rbd OR :rbd IS NULL) ";
		
		if (parametros.get(6).getValor() != null)
			hql += " AND (nombreEES like UPPER(:nombre))";
		else 
			parametros.remove(6);
		
		return (List<EESView>) (List) getObjectListHqlWithParam(new EESView(), hql, parametros, null, null);
		
	}

	@Override
	public List<EESView> getEESWithParamLimit(List<Parametro> parametros, Integer draw, Integer start, Integer length,
			String sortColumn, String sortDir) {
		
		String hql = "FROM EESView WHERE "
				+ "(concursoId = :concurso OR :concurso IS NULL) AND "
				+ "(estadoConectadoId = :instalacion OR :instalacion IS NULL) AND "
				+ "(estadoAdjudicadoId = :adjudicacion OR subEstadoAdjudicadoId = :adjudicacion OR :adjudicacion IS NULL) AND "
				+ "(regionId = :region OR :region IS NULL) AND "
				+ "(comunaId = :comuna OR :comuna IS NULL) AND "
				+ "(rbd =:rbd OR :rbd IS NULL)";
		
		if (parametros.get(6).getValor() != null) 
			hql += " AND (nombreEES like UPPER(:nombre))";
		else
			parametros.remove(6);
		
		hql += "ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<EESView>) (List) getObjectListHqlWithParam(new EESView(), hql, parametros, start, length);

	}

	@Override
	public Long getEESTotal() {
		
		String hql = "SELECT count(ees.rbd) FROM EESView ees";
		
		Long total = (Long) getObjectHqlUnique(new Long(0), hql);
		
		return total;
	}

	@Override
	public Long getEESTotalWithParam(List<Parametro> parametros) {
		
		String hql = "SELECT count(ees.rbd) FROM EESView ees WHERE "
				+ "(ees.concursoId = :concurso OR :concurso IS NULL) AND "
				+ "(estadoConectadoId = :instalacion OR :instalacion IS NULL) AND "
				+ "(ees.estadoAdjudicadoId = :adjudicacion OR ees.subEstadoAdjudicadoId = :adjudicacion OR :adjudicacion IS NULL) AND "
				+ "(ees.regionId = :region OR :region IS NULL) AND "
				+ "(ees.comunaId = :comuna OR :comuna IS NULL) AND "
				+ "(ees.rbd =:rbd OR :rbd IS NULL) ";
		
		if (parametros.get(6).getValor() != null)
			hql += " AND (nombreEES like UPPER(:nombre))";
		else 
			parametros.remove(6);
		
		Long total = (Long) getObjectHqlUniqueParam(new Long(0), hql, parametros);
		
		return total;
		
	}

}
