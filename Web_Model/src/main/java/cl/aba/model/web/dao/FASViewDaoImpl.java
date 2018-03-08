package cl.aba.model.web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.FASView;
import cl.aba.model.web.vo.Parametro;

@Repository
public class FASViewDaoImpl extends HibernateWeb implements FASViewDao {

	@Override
	public FASView getFAS(int rbdId, int concursoId) {
		
		String hql = "FROM FASView WHERE concursoId = " + concursoId + " AND rbdId = " + rbdId;
		
		return (FASView) getObjectHqlUnique(new FASView(), hql);
		
	}

	@Override
	public List<FASView> getFASAll() {

		String hql = "FROM FASView";
		
		return (List<FASView>) (List) getObjectListHql(new FASView(), hql);
	}

	@Override
	public List<FASView> getFAS(Integer draw, Integer start, Integer length, String sortColumn, String sortDir) {

		String hql = "FROM FASView ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<FASView>) (List) getObjectListHqlRange(new FASView(), hql, start, length);
	}

	@Override
	public List<FASView> getFASWithParam(List<Parametro> parametros) {
		
		String hql = "FROM FASView WHERE "
				+ "(rbd IN (:rbds) OR :rbds IS NULL) ";
		
		return (List<FASView>) (List) getObjectListHqlWithParam(new FASView(), hql, parametros, null, null);
	}

	@Override
	public List<FASView> getFASWithParamLimit(List<Parametro> parametros, Integer draw, Integer start, Integer length,
			String sortColumn, String sortDir) {
		
		String hql = "FROM FASView WHERE "
				+ "(rbd IN (:rbds) OR :rbds IS NULL) ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<FASView>) (List) getObjectListHqlWithParam(new FASView(), hql, parametros, start, length);
		
	}

	@Override
	public Long getFasTotal() {
		
		String hql = "SELECT count(fas.rbd) FROM FASView fas";
		
		Long total = (Long) getObjectHqlUnique(new Long(0), hql);
		
		return total;
	}

	@Override
	public Long getFasTotalWithParam(List<Parametro> parametros) {

		String hql = "SELECT count(fas.rbd) FROM FASView fas WHERE "
				+ "(fas.rbd IN (:rbds) OR :rbds IS NULL) ";
		
		Long total = (Long) getObjectHqlUniqueParam(new Long(0), hql, parametros);
		
		return total;
	}

}
