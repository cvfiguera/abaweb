package cl.aba.business.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.aba.business.vo.EstadoSinIdVo;
import cl.aba.business.vo.EstadoVo;
import cl.aba.model.old.common.Comuna;
import cl.aba.model.old.common.Region;
import cl.aba.model.old.dao.TicketViewDao;
import cl.aba.model.web.common.AdjudicadoEstados;
import cl.aba.model.web.common.Comunas;
import cl.aba.model.web.common.Concursos;
import cl.aba.model.web.common.ConectadoEstados;
import cl.aba.model.web.common.MineducEstados;
import cl.aba.model.web.common.Operadoras;
import cl.aba.model.web.common.Regiones;
import cl.aba.model.web.common.Tecnologias;
import cl.aba.model.web.dao.FiltrosDao;
import cl.aba.model.web.vo.FiltroSinIdVo;
import cl.aba.model.web.vo.FiltroVo;

@Service
public class FiltrosServiceImpl implements FiltrosService {

	@Autowired
	private FiltrosDao filtrosDao;
	@Autowired
	private TicketViewDao ticketDao;
	
	@Override
	public List<EstadoVo> getConcursos() {
		
		List<Concursos> concursos = filtrosDao.getConcursos();
		List<EstadoVo> filtro = new ArrayList<EstadoVo>();
		
		for(int i=0; i<concursos.size(); i++) {
			filtro.add(new EstadoVo(concursos.get(i).getConcursoId(),
					concursos.get(i).getNombre()));
		}
		
		return filtro;		
	}
	
	@Override
	public List<EstadoVo> getOperadoras() {
		
		List<Operadoras> operadoras = filtrosDao.getOperadorasAll();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<operadoras.size(); i++) {
			newList.add(new EstadoVo(operadoras.get(i).getOperadoraId(), 
					operadoras.get(i).getNombreSocialTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getAdjudicadoEstados() {
		
		List<AdjudicadoEstados> estadosAdjudicado = filtrosDao.getEstados();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<estadosAdjudicado.size();i++) {
			newList.add(new EstadoVo(estadosAdjudicado.get(i).getAdjudicadoEstadoId(), 
					estadosAdjudicado.get(i).getAdjudicadoEstadoTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getAdjudicadoSubestados(int adjudicado_sub_id) {
		
		List<AdjudicadoEstados> estadosAdjudicado = filtrosDao.getSubEstados(adjudicado_sub_id);
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<estadosAdjudicado.size();i++) {
			newList.add(new EstadoVo(estadosAdjudicado.get(i).getAdjudicadoEstadoId(), 
					estadosAdjudicado.get(i).getAdjudicadoEstadoTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getConectadoEstados() {
		
		List<ConectadoEstados> conectados = filtrosDao.getConectados();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<conectados.size();i++) {
			newList.add(new EstadoVo(conectados.get(i).getConectadoEstadoId(), 
					conectados.get(i).getConectadoEstadoTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getMineducEstados() {
		
		List<MineducEstados> mineduc = filtrosDao.getMineduc();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<mineduc.size();i++) {
			newList.add(new EstadoVo(mineduc.get(i).getMineducEstadoId(), 
					mineduc.get(i).getMineducEstadoTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getTecnologias() {
		
		List<Tecnologias> tecnologias = filtrosDao.getTecnologias();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<tecnologias.size();i++) {
			newList.add(new EstadoVo(tecnologias.get(i).getTecnologiaId(), 
					tecnologias.get(i).getNombreTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getRegiones() {
		
		List<Regiones> regiones = filtrosDao.getRegiones();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<regiones.size();i++) {
			newList.add(new EstadoVo(regiones.get(i).getRegionId(), 
					regiones.get(i).getNombreRegionTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getComunas(int region_id) {
		
		List<Comunas> comunas = filtrosDao.getComunas(region_id);
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<comunas.size();i++) {
			newList.add(new EstadoVo(comunas.get(i).getComunaId(), 
					comunas.get(i).getNombreComunaTx()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getOperadorasOld() {
		
		List<FiltroVo> operadoras = ticketDao.getFiltroOperadoras();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<operadoras.size();i++) {
			newList.add(new EstadoVo(operadoras.get(i).getId(), 
					operadoras.get(i).getNombre()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoSinIdVo> getCategoriasOld() {
		
		List<FiltroSinIdVo> categorias = ticketDao.getFiltroCategorias();
		List<EstadoSinIdVo> newList = new ArrayList<EstadoSinIdVo>();
		
		for(int i=0; i<categorias.size();i++) {
			newList.add(new EstadoSinIdVo(categorias.get(i).getNombre()));
		}
		
		return newList;
		
	}

	@Override
	public List<EstadoSinIdVo> getTipoOld() {
		
		List<FiltroSinIdVo> tipos = ticketDao.getFiltroTipo();
		List<EstadoSinIdVo> newList = new ArrayList<EstadoSinIdVo>();
		
		for(int i=0; i<tipos.size();i++) {
			newList.add(new EstadoSinIdVo(tipos.get(i).getNombre()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoSinIdVo> getEstadoOld() {
		
		List<FiltroSinIdVo> estados = ticketDao.getFiltroEstado();
		List<EstadoSinIdVo> newList = new ArrayList<EstadoSinIdVo>();
		
		for(int i=0; i<estados.size();i++) {
			newList.add(new EstadoSinIdVo(estados.get(i).getNombre()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getTecnologiaOld() {
		
		List<FiltroVo> tecnologias = ticketDao.getFiltroTecnologia();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<tecnologias.size();i++) {
			newList.add(new EstadoVo(tecnologias.get(i).getId(), 
					tecnologias.get(i).getNombre()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getRegionesOld() {
		
		List<Region> regiones = ticketDao.getFiltroRegion();
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<regiones.size();i++) {
			newList.add(new EstadoVo(regiones.get(i).getId(), 
					regiones.get(i).getNombre()));
		}
		
		return newList;
	}

	@Override
	public List<EstadoVo> getComunasOld(Integer id) {
		
		List<Comuna> comunas = ticketDao.getFiltroComuna(id);
		List<EstadoVo> newList = new ArrayList<EstadoVo>();
		
		for(int i=0; i<comunas.size();i++) {
			newList.add(new EstadoVo(comunas.get(i).getId(), 
					comunas.get(i).getNombre()));
		}
		
		return newList;
	}

}
