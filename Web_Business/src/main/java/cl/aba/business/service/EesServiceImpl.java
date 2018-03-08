package cl.aba.business.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.aba.business.vo.AdjudicacionVo;
import cl.aba.business.vo.ContactoVo;
import cl.aba.business.vo.DatatableOptions;
import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableResponse;
import cl.aba.business.vo.EESDetalle;
import cl.aba.business.vo.EESVo;
import cl.aba.business.vo.Filtro;
import cl.aba.business.vo.InstalacionVo;
import cl.aba.business.vo.ListaEsperaVo;
import cl.aba.business.vo.TicketVo;
import cl.aba.model.old.common.TicketView;
import cl.aba.model.old.dao.TicketViewDao;
import cl.aba.model.web.common.Adjudicaciones;
import cl.aba.model.web.common.Contactos;
import cl.aba.model.web.common.EESView;
import cl.aba.model.web.common.Instalaciones;
import cl.aba.model.web.common.ListaEspera;
import cl.aba.model.web.common.RbdConcursos;
import cl.aba.model.web.common.RbdEstados;
import cl.aba.model.web.dao.AdjudicacionesDao;
import cl.aba.model.web.dao.ContactosDao;
import cl.aba.model.web.dao.EESViewDao;
import cl.aba.model.web.dao.InstalacionesDao;
import cl.aba.model.web.dao.ListasEsperaDao;
import cl.aba.model.web.vo.Parametro;

@Service
public class EesServiceImpl implements EesService {

	protected Logger log = Logger.getLogger(getClass().getName());
	@Autowired
	private EESViewDao eesDao;
	@Autowired
	private InstalacionesDao instalacionesDao;
	@Autowired
	private AdjudicacionesDao adjudicacionesDao;
	@Autowired
	private ListasEsperaDao listaEsperaDao;
	@Autowired
	private ContactosDao contactosDao;
	@Autowired
	private TicketViewDao ticketDao;

	@Override
	public DatatableResponse getEESAll(DatatableRequest parametros) {
	
			List<EESView> eesList;
			Filtro filtro = parametros.getFiltro();
			DatatableOptions opciones = parametros.getOpciones();
			Long registrosAll = eesDao.getEESTotal();
			Long registros = new Long(0);
			List<Parametro> param = new ArrayList<Parametro>();

			param.add(new Parametro("concurso", filtro.getConcurso()));
			param.add(new Parametro("adjudicacion",
					(filtro.getSubestado() != null) ? filtro.getSubestado() : filtro.getEstado()));
			param.add(new Parametro("instalacion", filtro.getInstalacion()));
			param.add(new Parametro("region", filtro.getRegion()));
			param.add(new Parametro("comuna", filtro.getComuna()));
			param.add(new Parametro("rbd", filtro.getRbd()));

			if (filtro.getNombre() != null)
				param.add(new Parametro("nombre", ("%" + filtro.getNombre() + "%").toUpperCase()));
			else
				param.add(new Parametro("nombre", null));

			eesList = eesDao.getEESWithParamLimit(new ArrayList<Parametro>(param), opciones.getDraw(),
					opciones.getStart(), opciones.getLength(), opciones.getColumns().get(opciones.getSortColumn()),
					opciones.getSortDir());

			registros = eesDao.getEESTotalWithParam(new ArrayList<Parametro>(param));

			List<EESVo> eesVO = new ArrayList<EESVo>();

			for (int i = 0; i < eesList.size(); i++) {

				EESView ees = eesList.get(i);
				eesVO.add(new EESVo(ees.getConcursoId(), ees.getRbdId(), ees.getRbd(), 
						ees.getConcurso(), ees.getNombreEES(), ees.getMatricula(),
						ees.getDireccion(), ees.getComuna(), ees.getRegion(), ees.getSubEstadoAdjudicado(),
						ees.getEstadoConectado(), ees.getEstadoMineduc()));
			}

			List<? extends Object> data = eesVO;

			DatatableResponse eesResult = new DatatableResponse(parametros.getOpciones().getDraw(), registrosAll, registros,
					(ArrayList<Object>) data);

			return eesResult;		
	}

	@Override
	public InstalacionVo getEESInstalacion(int concursoId, int rbdId) {

			List<Instalaciones> instalaciones = instalacionesDao.getInstalaciones(concursoId, rbdId);
			Instalaciones instalacion = instalaciones.size() > 0 ? instalaciones.get(0) : null;
			RbdEstados rbdEstados = adjudicacionesDao.getRbdEstados(concursoId, rbdId);
			
			if (instalacion != null && rbdEstados != null) {
				return new InstalacionVo(
						instalacion.getInstalacionId(),
						instalacion.getRbdConcursos().getRbd().getRbdNu().longValue(),
						instalacion.getRbdConcursos().getConcursos().getNombre(),
						instalacion.getOperadoras().getNombreSocialTx(),
						instalacion.getTecnologias().getNombreTx(), instalacion.getFechaAltaServicioFe(),
						instalacion.getVelocidadNacionalNu(), instalacion.getVelocidadInternacionalNu(),
						instalacion.getPrecioInstalacionDecimal(), instalacion.getNumeroFormularioAltaServicio(),
						instalacion.getUrldocTx(), 
						rbdEstados.getConectadoEstados().getConectadoEstadoTx());
			}
			
		return null;
	}

	@Override
	public AdjudicacionVo getEESAdjudicacion(int concursoId, int rbdId) {
		
			List<Adjudicaciones> adjudicaciones = adjudicacionesDao.getAdjudicaciones(concursoId, rbdId);
			Adjudicaciones adjudicacion = adjudicaciones.size() > 0 ? adjudicaciones.get(0) : null;
			RbdEstados rbdEstados = adjudicacionesDao.getRbdEstados(concursoId, rbdId);

			if (adjudicacion != null && rbdEstados != null) {
				return new AdjudicacionVo(adjudicacion.getAdjudicacionId(), 
						adjudicacion.getRbdConcursos().getRbd().getRbdNu().longValue(),
						adjudicacion.getRbdConcursos().getConcursos().getNombre(),
						adjudicacion.getTipoAdjudicaciones().getTipoEsperaTx(),
						rbdEstados.getAdjudicadoEstados().getAdjudicadoEstadoTx(),
						adjudicacion.getOperadoras().getNombreSocialTx(), adjudicacion.getTecnologias().getNombreTx(),
						adjudicacion.getVelocidadNacionalNu(), adjudicacion.getVelocidadInternacionalNu(),
						adjudicacion.getPrecioAdjudicacionNu(), adjudicacion.getFechaAdjudicacion());
			}
		
		return null;
	}

	@Override
	public List<ListaEsperaVo> getEESListaEspera(int concursoId, int rbdId) {
		
			List<ListaEspera> listaEspera = listaEsperaDao.getListasEspera(concursoId, rbdId);
			List<ListaEsperaVo> listaEsperaVo = new ArrayList<ListaEsperaVo>();

			for (int i = 0; i < listaEspera.size(); i++) {
				ListaEspera registro = listaEspera.get(i);
				listaEsperaVo.add(new ListaEsperaVo(registro.getListaEsperaId(),
						registro.getRbdConcursos().getRbd().getRbdNu().longValue(),
						registro.getRbdConcursos().getConcursos().getNombre(),
						registro.getTipoAdjudicaciones().getTipoEsperaTx(),
						registro.getTecnologias().getNombreTx(),
						registro.getOperadoras().getNombreSocialTx(),
						registro.getVelocidadNacionalNu(),
						registro.getVelocidadInternacionalNu(),
						registro.getPrecioNu()));
			}

			return listaEsperaVo;
	}
	
	@Override
	public List<TicketVo> getEESTickets(int concursoId, int rbdId) {
		
			EESView ees = eesDao.getEES(concursoId, rbdId);
			List<TicketView> tickets = ticketDao.getTicketByRbd(ees.getRbd());
			List<TicketVo> ticketsVo = new ArrayList<TicketVo>();

			for (int i = 0; i < tickets.size(); i++) {
				TicketView ticket = tickets.get(i);
				ticketsVo.add(new TicketVo(ticket.getNroTicketCallCenter(), ticket.getRbd(), null,
						ticket.getAnexo(), ticket.getEstadoEES(), ticket.getNombreEstablecimiento(),
						ticket.getRegion(), ticket.getComuna(), ticket.getOperadora(),
						ticket.getOrigen(), ticket.getGeneraWF(), ticket.getEscalable(),
						ticket.getEstado(), ticket.getTipo(), ticket.getCategoria(),
						ticket.getEscalarA(), ticket.getNroTicketEscalado(), ticket.getGeneradoOperadora(),
						ticket.getFechaAtencion(), ticket.getFechaCambioEstado(),
						ticket.getFechaCambioEstado(), ticket.getTecnologia(), ticket.getMotivo(),
						ticket.getComentario()));
			}

			return ticketsVo;
	}

	@Override
	public List<ContactoVo> getEESContactos(int rbdId) {
		
			List<Contactos> contactos = contactosDao.getContactos(rbdId);
			List<ContactoVo> contactosVo = new ArrayList<ContactoVo>();

			for (int i = 0; i < contactos.size(); i++) {
				Contactos contacto = contactos.get(i);
				contactosVo.add(
						new ContactoVo(
								contacto.getContactoId(), 
								contacto.getRbd().getRbdNu().longValue(),
								contacto.getNombreTx(), 
								contacto.getCargoTx(), 
								contacto.getTelefono1Tx(), 
								contacto.getTelefono2Tx(),
								contacto.getMailTx(), 
								contacto.getFechaBaja()
									)
								);
			}

			return contactosVo;
	}

}
