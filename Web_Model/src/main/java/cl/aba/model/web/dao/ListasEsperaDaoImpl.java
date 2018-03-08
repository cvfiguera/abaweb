package cl.aba.model.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.ListaEspera;

@Repository
public class ListasEsperaDaoImpl extends HibernateWeb implements ListasEsperaDao {

	@Override
	public List<ListaEspera> getListasEspera(int concursoId, int rbdId) {
		
		String hql = "FROM ListaEspera WHERE "
				+ "rbdConcursos.concursos.concursoId = " + concursoId
				+ "AND rbdConcursos.rbd.rbdId = " + rbdId;
		
		return (List<ListaEspera>)(List)getObjectListHql(new ListaEspera(), hql);
		
	}

}
