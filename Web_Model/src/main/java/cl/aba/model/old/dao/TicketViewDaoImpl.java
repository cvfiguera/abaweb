package cl.aba.model.old.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.aba.model.old.common.Comuna;
import cl.aba.model.old.common.Region;
import cl.aba.model.old.common.TicketView;
import cl.aba.model.web.vo.FiltroSinIdVo;
import cl.aba.model.web.vo.FiltroVo;
import cl.aba.model.web.vo.Parametro;

@Repository
public class TicketViewDaoImpl extends HibernateOld implements TicketViewDao {

	@Override
	public List<FiltroVo> getFiltroOperadoras() {
		
		String hql = "SELECT DISTINCT codigoOperadora as id, operadora as nombre FROM TicketView";
		
		List<FiltroVo> lista = new ArrayList<FiltroVo>();
		
		List<? extends Object> result= (List) getObjectListHqlTrans(new FiltroVo(), hql);
		
		lista = (ArrayList<FiltroVo>) result;
		
		return lista;
	}

	@Override
	public List<FiltroSinIdVo> getFiltroCategorias() {
		
		String hql = "SELECT DISTINCT categoria as nombre FROM TicketView";
		
		List<FiltroSinIdVo> lista = new ArrayList<FiltroSinIdVo>();
		
		List<? extends Object> result= (List) getObjectListHqlTrans(new FiltroSinIdVo(), hql);
		
		lista = (List<FiltroSinIdVo>) result;
		
		return lista;
	}

	@Override
	public List<FiltroSinIdVo> getFiltroTipo() {
		
		String hql = "SELECT DISTINCT tipo as nombre FROM TicketView";
		
		List<FiltroSinIdVo> lista = new ArrayList<FiltroSinIdVo>();
		
		List<? extends Object> result= (List) getObjectListHqlTrans(new FiltroSinIdVo(), hql);
		
		lista = (ArrayList<FiltroSinIdVo>) result;
		
		return lista;
	}

	@Override
	public List<FiltroSinIdVo> getFiltroEstado() {
		
		String hql = "SELECT DISTINCT estado as nombre FROM TicketView";
		
		List<FiltroSinIdVo> lista = new ArrayList<FiltroSinIdVo>();
		
		List<? extends Object> result= (List) getObjectListHqlTrans(new FiltroSinIdVo(), hql);
		
		lista = (ArrayList<FiltroSinIdVo>) result;
		
		return lista;
	}

	@Override
	public List<FiltroVo> getFiltroTecnologia() {
		
		String hql = "SELECT DISTINCT codigoTecnologia as id, tecnologia as nombre FROM TicketView";
		
		List<FiltroVo> lista = new ArrayList<FiltroVo>();
		
		List<? extends Object> result= (List) getObjectListHqlTrans(new FiltroVo(), hql);
		
		lista = (ArrayList<FiltroVo>) result;
		
		return lista;
	}

	@Override
	public List<Region> getFiltroRegion() {

		String hql = "FROM Region";
		
		return (List<Region> ) (List) getObjectListHql(new Region(), hql);
	}

	@Override
	public List<Comuna> getFiltroComuna(Integer id) {

		String hql = "FROM Comuna WHERE region = " + id;
		
		return (List<Comuna> ) (List) getObjectListHql(new Comuna(), hql);
	}

	@Override
	public Long getTotalRegistros() {
		
		String hql = "SELECT count(nroTicketCallCenter) FROM TicketView";
		
		Long total = (Long) getObjectHqlUnique(new Long(0), hql);
		
		return total;
	}

	@Override
	public Long getRegistrosFiltrados(List<Parametro> parametros, Date fechaIni, Date fechaFin) {
		
		
		String hql = "SELECT count(nroTicketCallCenter) FROM TicketView WHERE ";
		
		if (fechaIni!= null) 
			hql += "(fechaAtencion >= '" + fechaIni + "') AND ";
		if (fechaFin!=null)
			hql += "(fechaAtencion <= '" + fechaFin + "') AND ";
		
		hql += "(categoria= :categoria OR :categoria IS NULL) AND "
				+ "(tipo= :tipo OR :tipo IS NULL) AND "
				+ "(estado= :estado OR :estado IS NULL) AND "
				+ "(codigoOperadora= :operadora OR :operadora IS NULL) AND "
				+ "(codigoTecnologia = :tecnologia OR :tecnologia IS NULL) AND "
				+ "(codigoComuna= :comuna OR :comuna IS NULL) AND "
				+ "(codigoRegion = :region OR :region IS NULL) AND "
				+ "(rbd IN :rbds OR :rbds IS NULL) ";
		
		Long total = (Long) getObjectHqlUniqueParam(new Long(0), hql, parametros);
		
		return total;
	}

	@Override
	public TicketView getTicketDetail(int ticket) {
		
		String hql = "FROM TicketView WHERE nroTicketCallCenter = " + ticket;
		
		return (TicketView) getObjectHqlUnique(new TicketView(), hql);
	}

	@Override
	public List<TicketView> getTicketsAll() {
		
		String hql = "FROM TicketView";
		
		return (List<TicketView>) (List) getObjectListHql(new TicketView(), hql);
	}

	@Override
	public List<TicketView> getTickets(Integer draw, Integer start, Integer length, String sortColumn, String sortDir) {

		String hql = "FROM TicketView ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<TicketView>) (List) getObjectListHqlRange(new TicketView(), hql, start, length);
	}

	@Override
	public List<TicketView> getTicketWithParams(List<Parametro> parametros, Date fechaIni, Date fechaFin) {
		
		String hql =  "FROM TicketView WHERE ";
				
		if (fechaIni!= null) 
			hql += "(fechaAtencion >= '" + fechaIni + "') AND ";
		if (fechaFin!=null)
			hql += "(fechaAtencion <= '" + fechaFin + "') AND ";
		
		hql += "(categoria= :categoria OR :categoria IS NULL) AND "
			+ "(tipo= :tipo OR :tipo IS NULL) AND "
			+ "(estado= :estado OR :estado IS NULL) AND "
			+ "(codigoOperadora= :operadora OR :operadora IS NULL) AND "
			+ "(codigoTecnologia = :tecnologia OR :tecnologia IS NULL) AND "
			+ "(codigoComuna= :comuna OR :comuna IS NULL) AND "
			+ "(codigoRegion = :region OR :region IS NULL) AND "
			+ "(rbd IN :rbds OR :rbds IS NULL) ";
	
		return (List<TicketView>) (List) getObjectListHqlWithParam(new TicketView(), hql, parametros, null, null);
	}

	@Override
	public List<TicketView> getTicketWithParamsLimit(List<Parametro> parametros, Date fechaIni, Date fechaFin, 
			Integer draw, Integer start,
			Integer length, String sortColumn, String sortDir) {
	
		String hql = "FROM TicketView WHERE ";
		
		if (fechaIni!= null) 
			hql += "(fechaAtencion >= '" + fechaIni + "') AND ";
		if (fechaFin!=null)
			hql += "(fechaAtencion <= '" + fechaFin + "') AND ";
		
		hql += "(categoria= :categoria OR :categoria IS NULL) AND "
			+ "(tipo= :tipo OR :tipo IS NULL) AND "
			+ "(estado= :estado OR :estado IS NULL) AND "
			+ "(codigoOperadora= :operadora OR :operadora IS NULL) AND "
			+ "(codigoTecnologia = :tecnologia OR :tecnologia IS NULL) AND "
			+ "(codigoComuna= :comuna OR :comuna IS NULL) AND "
			+ "(codigoRegion = :region OR :region IS NULL) AND "
			+ "(rbd IN :rbds OR :rbds IS NULL) "
			+ "ORDER BY " + sortColumn + " " + sortDir;
		
		return (List<TicketView>) (List) getObjectListHqlWithParam(new TicketView(), hql, parametros, start, length);
	}

	@Override
	public List<TicketView> getTicketByRbd(Long rbd) {
		
		String hql = "FROM TicketView WHERE rbd = " + rbd;
		
		return (List<TicketView>) (List) getObjectListHql(new TicketView(), hql);
	}

}
