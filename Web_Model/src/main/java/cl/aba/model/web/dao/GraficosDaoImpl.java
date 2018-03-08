package cl.aba.model.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aba.model.web.common.QueryGraficos;
import cl.aba.model.web.vo.GraficoVo;

@Repository
public class GraficosDaoImpl extends HibernateWeb implements GraficosDao {
	
	@Autowired
	private QueryGraficos query;

	@Override
	public List<GraficoVo> getGraficoConcurso() {	
		String sql = query.sqlConcurso();
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}
	
	@Override
	public List<GraficoVo> getGraficoAdjudicaciones(Integer concursoId) {
		String sql = query.sqlAdjudicado(concursoId);
        System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}

	@Override
	public List<GraficoVo> getGraficoMineduc(Integer adjudicacionId, Integer concursoId) {
		
		String sql = query.sqlMineduc(concursoId, adjudicacionId);
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
	//	List<? extends Object> result= (List) getObjectListHqlTrans(new GraficoVo(), hql);
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}

	@Override
	public List<GraficoVo> getGraficoInstalacion(Integer adjudicacionId, Integer mineducId,Integer concursoId) {
		
		String sql =query.sqlConectado(concursoId, adjudicacionId, mineducId);
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
	//	List<? extends Object> result= (List) getObjectListHqlTrans(new GraficoVo(), hql);
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}

	@Override
	public List<GraficoVo> getGraficoOperadora(Integer adjudicacionId, Integer mineducId, Integer conectadoId, Integer concursoId) {
		
		String sql = query.sqlOperadora(concursoId, adjudicacionId, mineducId, conectadoId);
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}

	@Override
	public List<GraficoVo> getGraficoTecnologia(Integer adjudicacionId, Integer mineducId, Integer conectadoId,
			Integer operadoraId, Integer concursoId) {
		
		String sql = query.sqlTecnologia(concursoId, adjudicacionId, mineducId, conectadoId, operadoraId);
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
	}

	@Override
	public List<GraficoVo> getGraficoRegion(Integer adjudicacionId, Integer mineducId, Integer conectadoId,
			Integer operadoraId, Integer tecnologiaId, Integer concursoId) {
		
		String sql = query.sqlRegiones(concursoId, adjudicacionId, mineducId, conectadoId, operadoraId, tecnologiaId);
		System.out.println(sql);
		
		List<GraficoVo> graficos = new ArrayList<GraficoVo>();
		
		List<? extends Object> result= (List) getObjectListSqlTrans(new GraficoVo(), sql);
		
		graficos = (ArrayList<GraficoVo>) result;
		
		return graficos;
		
	}
}
