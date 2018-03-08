package cl.aba.model.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.aba.model.web.common.Adjudicaciones;
import cl.aba.model.web.common.AdjudicadoEstados;
import cl.aba.model.web.common.Comunas;
import cl.aba.model.web.common.Concursos;
import cl.aba.model.web.common.ConectadoEstados;
import cl.aba.model.web.common.Instalaciones;
import cl.aba.model.web.common.MineducEstados;
import cl.aba.model.web.common.Operadoras;
import cl.aba.model.web.common.Regiones;
import cl.aba.model.web.common.Tecnologias;

@Repository
public class FiltrosDaoImpl extends HibernateWeb implements FiltrosDao {

	@Override
	public Concursos getConcurso(int concurso_id) {
		
		String hql = "from Concursos where concursoId = " + concurso_id;
		
		return (Concursos) getObjectHqlUnique(new Concursos(), hql);
	}

	@Override
	public List<Concursos> getConcursos() {
		
		String hql = "from Concursos";
		return (List<Concursos>) (List) getObjectListHql(new Concursos(), hql);
	}
	
	@Override
	public Operadoras getOperadora(int operadora_id) {
		
		String hql = "from Operadoras where operadoraId = " + operadora_id;
		
		return (Operadoras) getObjectHqlUnique(new Operadoras(), hql);
	}

	@Override
	public List<Operadoras> getOperadorasAll() {
		
		String hql = "from Operadoras";
		
		return (List<Operadoras>) ((List) getObjectListHql (new Operadoras(), hql));		

	}
	
	@Override
	public Tecnologias getTecnologia(int tecnologia_id) {
		
		String hql = "from Tecnologias where tecnologiaId = " + tecnologia_id;
		
		return (Tecnologias) getObjectHqlUnique(new Tecnologias(), hql);
		
	}
	
	@Override
	public List<Tecnologias> getTecnologias() {
		
		String hql = "from Tecnologias";
		
		return (List<Tecnologias>)(List)getObjectListHql(new Tecnologias(), hql);
	}

	@Override
	public AdjudicadoEstados getAdjudicado(int estado_id) {

		String hql = "from AdjudicadoEstados where adjudicadoEstadoId  = " + estado_id;
		
		return (AdjudicadoEstados) getObjectHqlUnique(new AdjudicadoEstados(), hql);
	}
	
	@Override
	public List<AdjudicadoEstados> getEstados() {
		
		String hql = "from AdjudicadoEstados  as estb";
		hql +=" where adjudicadoEstadoId in ( ";
		hql +="	select est.adjudicadoEstados.adjudicadoEstadoId "; 
		hql +=" from AdjudicadoEstados  as est ";
		hql +=" group by adjudicadoEstados.adjudicadoEstadoId) ";
		
		List<AdjudicadoEstados> listRet = (List<AdjudicadoEstados>)(List)getObjectListHql(new AdjudicadoEstados(), hql);
		
		return listRet;
	}

	@Override
	public List<AdjudicadoEstados> getSubEstados(int adjudicado) {
		
		String hql = "from AdjudicadoEstados where adjudicadoEstados.adjudicadoEstadoId = '" + adjudicado + "'";
		List<AdjudicadoEstados> listRet = new ArrayList<AdjudicadoEstados>();
		listRet = (List<AdjudicadoEstados>)(List)getObjectListHql(new AdjudicadoEstados(), hql);
		return listRet;
		
	}

	@Override
	public MineducEstados getMineducEstados(int mineduc_id) {

		String hql = "from MineducEstados where mineducEstadoId = '" + mineduc_id + "'";
		
		return (MineducEstados) getObjectHqlUnique(new MineducEstados(), hql);
	}
	
	@Override
	public List<MineducEstados> getMineduc() {
		
		String hql ="from MineducEstados";
		
		return (List<MineducEstados>)(List)getObjectListHql(new MineducEstados(), hql);
	}

	@Override
	public ConectadoEstados getConectadoEstado(int conectado_id) {

		String hql = "from ConectadoEstados where conectadoEstadoId = '" + conectado_id + "'";
		
		return (ConectadoEstados) getObjectHqlUnique(new ConectadoEstados(), hql);
	}
	
	@Override
	public List<ConectadoEstados> getConectados() {
	
		String hql = "from ConectadoEstados";
		
		return (List<ConectadoEstados>) (List)getObjectListHql(new ConectadoEstados(), hql);
	}

	@Override
	public Comunas getComuna(int comuna_id) {

		String hql = "from Comunas where comunaId = '" + comuna_id + "'";
		
		return (Comunas) getObjectHqlUnique(new Comunas(), hql);
	}
	
	@Override
	public List<Comunas> getComunas() {
		
		String hql ="from Comunas" ;
		
		return (List<Comunas>)(List) getObjectListHql(new Comunas(), hql);
		
	}

	@Override
	public List<Comunas> getComunas(int reg) {
		
		String hql ="from Comunas where regiones.regionId = " + reg ;
		
		return (List<Comunas>)(List) getObjectListHql(new Comunas(), hql);
		
	}

	@Override
	public Regiones getRegion(int region_id) {

		String hql = "from Regiones where regionId = '" + region_id + "'";
		
		return (Regiones) getObjectHqlUnique(new Regiones(), hql);
	}
	
	@Override
	public List<Regiones> getRegiones() {
		
		String hql = "from Regiones";
		
		return (List<Regiones>)(List)getObjectListHql(new Regiones(), hql);
	}
}
