package cl.aba.model.web.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.Adjudicaciones;
import cl.aba.model.web.common.RbdEstados;

@Repository
public class AdjudicacionesDaoImpl extends HibernateWeb implements AdjudicacionesDao {

	@Override
	public List<Adjudicaciones> getAdjudicaciones(int concursoId, int rbdId) {

		String hql = "from Adjudicaciones adj where"
				+ " adj.rbdConcursos.concursos.concursoId = " + concursoId
				+ " and adj.rbdConcursos.rbd.rbdId = " + rbdId
				+ " order by adj.fechaAdjudicacion desc";
		
		return (List<Adjudicaciones>)(List)getObjectListHql(new Adjudicaciones(), hql);
	}


	@Override
	public RbdEstados getRbdEstados(int concursoId, int rbdId) {
		
		String hql = "from RbdEstados rbde where "
				+ " rbde.rbdConcursos.concursos.concursoId = " + concursoId
				+ " and rbde.rbdConcursos.rbd.rbdId = " + rbdId 
				+ " order by rbde.fechaI desc";
		
		List <RbdEstados> list = new ArrayList<RbdEstados>();
		
		list = (List<RbdEstados>)(List)getObjectListHql(new RbdEstados(), hql);
		
		return (list.size()>0)?(RbdEstados)list.get(0):null;
	}

}
