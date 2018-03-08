package cl.aba.model.web.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.EscuelasView;
import cl.aba.model.web.dao.HibernateWeb;
import cl.aba.model.web.vo.Parametro;

@Repository
public class EscuelasViewDaoImpl extends HibernateWeb implements EscuelasViewDao {

	@Override
	public EscuelasView getEscuela(int rbdId, int concursoId) {
		
		String hql = "FROM EscuelasView WHERE concursoId = " + concursoId + " AND rbdId = " + rbdId;
		
		return (EscuelasView) getObjectHqlUnique(new EscuelasView(), hql);
	}

	@Override
	public List<EscuelasView> getEscuelasAll() {
		
		String hql = "FROM EscuelasView";
		
		List<EscuelasView> listRet = new ArrayList<EscuelasView>();
		
		listRet = (List<EscuelasView>) (List) getObjectListHql(new EscuelasView(), hql);
		
		return listRet;
	}

	@Override
	public List<EscuelasView> getEscuelas(Integer draw, Integer start, Integer length, String sortColumn,
			String sortDir) {

		String hql = "FROM EscuelasView ORDER BY " + sortColumn + " " + sortDir;
		
		List<EscuelasView> listRet = new ArrayList<EscuelasView>();
		
		listRet = (List<EscuelasView>) (List) getObjectListHqlRange(new EscuelasView(), hql, start, length);
		
		return listRet;
	}

	@Override
	public List<EscuelasView> getEscuelasWithParam(List<Parametro> parametros) {
	
		String hql = "FROM EscuelasView";
		
		List<Parametro> param = new ArrayList<Parametro>();
		
		for(int i=0, n=0; i<parametros.size();i++) {
			
			Parametro parametro = parametros.get(i); 
			
			if (parametro.getValor()!=null) {
				
				if (n==0) {
					hql += " WHERE ";
					n++;
				} else hql += " AND ";
				
				param.add(parametro);
				
				switch(parametro.getNombre()) {
					case "concurso":
						hql += "concursoId = :concurso";
						break;
					case "operadora":
						hql += "operadoraId = :operadora";
						break;
					case "adjudicacion": 
						hql += "(estadoAdjudicadoId = :adjudicacion OR subEstadoAdjudicadoId = :adjudicacion)";
						break;
					case "instalacion": 
						hql += "estadoConectadoId= :instalacion";
						break;
					case "mineduc": 
						hql += "estadoMineducId = :mineduc";
						break;
					case "tecnologia": 
						hql += "tecnologiaId = :tecnologia";
						break;
					case "region":
						hql += "regionId = :region";
						break;
					case "comuna":
						hql += "comunaId = :comuna";
						break;
					case "rbds":
						hql += "rbd IN (:rbds)";
						break;
				}
			}
		}

		List<EscuelasView> listRet = new ArrayList<EscuelasView>();
		
		listRet = (List<EscuelasView>) (List) getObjectListHqlWithParam(new EscuelasView(), hql, param, null, null);
		
		return listRet;
	}

	@Override
	public List<EscuelasView> getEscuelasWithParamLimit(List<Parametro> parametros, Integer draw, Integer start,
			Integer length, String sortColumn, String sortDir) {
		String hql = "FROM EscuelasView as v";
		Boolean p = false;
		
		List<Parametro> param = new ArrayList<Parametro>();
		
		for(int i=0; i<parametros.size();i++) {
			
			Parametro parametro = parametros.get(i); 
			
			if (parametro.getValor()!=null) {
				
				if (!p) {
					hql += " WHERE ";
					p = true;
				}
				else hql += " AND ";
				
				param.add(parametro);
				
				switch(parametro.getNombre()) {
					case "concurso":
						hql += "v.concursoId = :concurso";
						break;
					case "operadora":
						hql += "v.operadoraId = :operadora";
						break;
					case "adjudicacion": 
						hql += "(v.estadoAdjudicadoId = :adjudicacion OR v.subEstadoAdjudicadoId = :adjudicacion)";
						break;
					case "instalacion": 
						hql += "v.estadoConectadoId= :instalacion";
						break;
					case "mineduc": 
						hql += "v.estadoMineducId = :mineduc";
						break;
					case "tecnologia": 
						hql += "v.tecnologiaId = :tecnologia";
						break;
					case "region":
						hql += "v.regionId = :region";
						break;
					case "comuna":
						hql += "v.comunaId = :comuna";
						break;
					case "rbds":
						hql += "v.rbd IN (:rbds)";
						break;
				}
			}
		}

		hql += " ORDER BY v.rbd " + sortDir;
		
		List<EscuelasView> listRet = new ArrayList<EscuelasView>();
		System.out.println(hql);
		
		listRet = (List<EscuelasView>) (List) getObjectListHqlWithParam(new EscuelasView(), hql, param, start, length);
		
		return listRet;
	}

	@Override
	public Long getTotalEscuelas() {
		
		String sql = "SELECT count(rbd.rbd_id) as total ";
		sql += " FROM web.rbd_estados est JOIN ";
		sql += " ( SELECT rbd_estados.rbd_estado_id ";
		sql += " FROM web.rbd_estados JOIN ";
		sql += " ( SELECT rbd_estados_1.rbd_concurso_id, ";
		sql += " max(rbd_estados_1.fecha_i) AS fecha_actualizacion ";
		sql += "  FROM web.rbd_estados rbd_estados_1 ";
	    sql += "  GROUP BY rbd_estados_1.rbd_concurso_id ";
	    sql += " ) b ON rbd_estados.rbd_concurso_id = b.rbd_concurso_id ";
	    sql += " AND rbd_estados.fecha_i = b.fecha_actualizacion ";
		sql += " ) estb ON estb.rbd_estado_id = est.rbd_estado_id ";
		sql += " JOIN web.rbd_concursos rbd_c ON rbd_c.rbd_concurso_id = est.rbd_concurso_id ";
		sql += " JOIN web.rbd rbd ON rbd.rbd_id = rbd_c.rbd_id ";
		sql += " JOIN web.concursos con ON con.concurso_id = rbd_c.concurso_id ";
		System.out.println(sql);
		
		Session session = null;
		Long total = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			BigInteger tot =  (BigInteger) session.createSQLQuery(sql).uniqueResult();
			total = tot.longValue();
		}catch (Exception e) {
			// TODO: handle exception
			error("al realizar la consulta " + sql + " " + e.getMessage() );
		}finally{
			session.close();
		}
		
	//	String hql = "select count(v.id.rbdId) from EscuelasView as v";
		
		
	//	Long total = (Long) getObjectHqlUnique(new Long(0), hql);
		
		return total;
	}

	@Override
	public Long getTotalEscuelasWithParam(List<Parametro> parametros) {
		
		String hql = "SELECT count(v.rbdId) FROM EscuelasView as v";
		Boolean p = false;
		
		List<Parametro> param = new ArrayList<Parametro>();
		
		for(int i=0; i<parametros.size();i++) {
			
			Parametro parametro = parametros.get(i); 
			
			if (parametro.getValor()!=null) {
				
				if (!p) {
					hql += " WHERE ";
					p = true;
				}
				else hql += " AND ";
				
				param.add(parametro);
				
				switch(parametro.getNombre()) {
					case "concurso":
						hql += "v.concursoId = :concurso";
						break;
					case "operadora":
						hql += "v.operadoraId = :operadora";
						break;
					case "adjudicacion": 
						hql += "(v.estadoAdjudicadoId = :adjudicacion OR v.id.subEstadoAdjudicadoId = :adjudicacion)";
						break;
					case "instalacion": 
						hql += "v.estadoConectadoId= :instalacion";
						break;
					case "mineduc": 
						hql += "v.estadoMineducId = :mineduc";
						break;
					case "tecnologia": 
						hql += "v.tecnologiaId = :tecnologia";
						break;
					case "region":
						hql += "v.regionId = :region";
						break;
					case "comuna":
						hql += "v.comunaId = :comuna";
						break;
					case "rbds":
						hql += "v.rbd IN (:rbds)";
						break;
				}
			}
		}
		
		Long total = (Long) getObjectHqlUniqueParam(new Long(0), hql, param);
		
		return total;
	}

}
