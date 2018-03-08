package cl.aba.model.web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.Instalaciones;

@Repository
public class InstalacionesDaoImpl extends HibernateWeb implements InstalacionesDao {
	
	@Override
	public List<Instalaciones> getInstalaciones(int concursoId, int rbdId) {
		
		String hql = "from Instalaciones ins where"
				+ " ins.rbdConcursos.concursos.concursoId = " + concursoId
				+ " and ins.rbdConcursos.rbd.rbdId = " + rbdId 
				+ " order by ins.fechaAltaServicioFe desc";
		
		return (List<Instalaciones>)(List)getObjectListHql(new Instalaciones(), hql);
		
	}
}
