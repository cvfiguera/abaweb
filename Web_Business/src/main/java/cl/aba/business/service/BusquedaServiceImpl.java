package cl.aba.business.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import cl.aba.business.vo.DatatableOptions;
import cl.aba.business.vo.EscuelasVo;
import cl.aba.business.vo.FASVo;
import cl.aba.business.vo.Filtro;
import cl.aba.business.vo.FiltroEscuelas;
import cl.aba.business.vo.FiltroTicket;
import cl.aba.business.vo.TicketVo;
import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableRequestTicket;
import cl.aba.business.vo.DatatableResponse;
import cl.aba.model.old.common.TicketView;
import cl.aba.model.old.dao.TicketViewDao;
import cl.aba.model.web.common.EscuelasView;
import cl.aba.model.web.common.FASView;
import cl.aba.model.web.vo.Parametro;
import entidades.InformeRBD;
import entidades.InformeTicket;
import entidades.Ticket;
import entidades.infoRbd;
import utils.Export;
import cl.aba.model.web.dao.EscuelasViewDao;
import cl.aba.model.web.dao.FASViewDao;
import cl.aba.model.web.dao.FiltrosDao;;

@Service
public class BusquedaServiceImpl implements BusquedaService {

	protected Logger log = Logger.getLogger(getClass().getName());
	@Autowired
	private EscuelasViewDao escuelasDao;
	@Autowired
	private FASViewDao fasDao;
	@Autowired
	private TicketViewDao ticketDao;
	@Autowired
	private FiltrosDao filtrosDao;
	@Value("${reportes.dir}")
	private String ruta;

	@Override
	public EscuelasVo getEscuelaDetalle(int rbdId, int concursoId) {
		
		EscuelasView escuela = escuelasDao.getEscuela(rbdId, concursoId);
		EscuelasVo escuelaVO = new EscuelasVo(escuela.getConcursoId(), escuela.getRbdId(),
				escuela.getRbd().longValue(), escuela.getAnexo(), escuela.getConcurso(),
				escuela.getNombreEES(), escuela.getDireccion(), escuela.getMatricula(), 
				escuela.getComuna(), escuela.getRegion(), escuela.getSubEstadoAdjudicado(),
				escuela.getEstadoConectado(), escuela.getEstadoMineduc(),
				escuela.getTecnologia(), escuela.getOperadora(), escuela.getPrecioMensual(), 
				escuela.getVelocidadBajada(), escuela.getVelocidadSubida(), escuela.getFechaFas());
		
		return escuelaVO;
		
	}

	@Override
	public DatatableResponse getListadoEscuelas(DatatableRequest parametros) {
		
		List<EscuelasView> escuelas;
		Filtro filtro = parametros.getFiltro();
		DatatableOptions opciones = parametros.getOpciones();
		
		long inicio = System.currentTimeMillis();
        Long registrosAll = escuelasDao.getTotalEscuelas();
       
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
	    System.out.println(tiempo +" segundos");
	    
		Long registros = new Long(0);
		
		List<Parametro> param = new ArrayList<Parametro>();
		
		param.add(new Parametro("concurso", filtro.getConcurso()));
		param.add(new Parametro("operadora", filtro.getOperadora()));
		param.add(new Parametro("adjudicacion", (filtro.getSubestado()!=null)?filtro.getSubestado():filtro.getEstado()));
		param.add(new Parametro("instalacion", filtro.getInstalacion()));
		param.add(new Parametro("mineduc", filtro.getMineduc()));
		param.add(new Parametro("tecnologia", filtro.getTecnologia()));
		param.add(new Parametro("region", filtro.getRegion()));
		param.add(new Parametro("comuna", filtro.getComuna()));
		param.add(new Parametro("rbds", filtro.getRbds()));
		
		
		inicio = System.currentTimeMillis();
		escuelas = escuelasDao.getEscuelasWithParamLimit(param, opciones.getDraw(), opciones.getStart(),
					opciones.getLength(), opciones.getColumns().get(opciones.getSortColumn()), opciones.getSortDir());
		fin = System.currentTimeMillis();
		tiempo = (double) ((fin - inicio)/1000);
		System.out.println(tiempo +" segundos");
		
		
		inicio = System.currentTimeMillis();
		
		registros = escuelasDao.getTotalEscuelasWithParam(param);
		fin = System.currentTimeMillis();	
		tiempo = (double) ((fin - inicio)/1000);
		System.out.println(tiempo +" segundos");
		
		List<EscuelasVo> escuelasVO= new ArrayList<EscuelasVo>();
		
		for(int i=0; i<escuelas.size(); i++) {
			
			EscuelasView escuela = escuelas.get(i);
			if(escuela != null){
				escuelasVO.add(new EscuelasVo(escuela.getConcursoId(), escuela.getRbdId(), escuela.getRbd().longValue(),
							escuela.getAnexo(), escuela.getConcurso(), escuela.getNombreEES(), escuela.getDireccion(),
							escuela.getMatricula(), escuela.getComuna(), escuela.getRegion(), escuela.getSubEstadoAdjudicado(),
							escuela.getEstadoConectado(), escuela.getEstadoMineduc(), escuela.getTecnologia(), 
							escuela.getOperadora(), escuela.getPrecioMensual(), escuela.getVelocidadBajada(), 
							escuela.getVelocidadSubida(), escuela.getFechaFas())
						);
			}
		}
		
		List<? extends Object> data = escuelasVO;
		
		DatatableResponse escuelasResult = new DatatableResponse(parametros.getOpciones().getDraw(), registrosAll, registros, (ArrayList<Object>) data);
		
		return escuelasResult;
	}
	
	@Override
	public FASVo getFASDetalle(int rbdId, int concursoId) {
		
		FASView fas = fasDao.getFAS(rbdId, concursoId);
		FASVo fasVO = new FASVo(fas.getConcursoId(), fas.getRbdId(), fas.getRbd(), fas.getAnexo(), 
				fas.getNombreConcurso(), fas.getNombreEES(), fas.getEstadoConectado(),
				fas.getTecnologia(), fas.getOperadora(), fas.getNumFAS(), fas.getUrl(),
				fas.getVelocidadBajada(), fas.getVelocidadSubida(), fas.getFechaFAS());
		
		return fasVO;
	}

	@Override
	public DatatableResponse getListadoFAS(DatatableRequest parametros) {
		
		List<FASView> fas;
		Filtro filtro = parametros.getFiltro();
		DatatableOptions opciones = parametros.getOpciones();
		Long registrosAll = fasDao.getFasTotal();
		Long registros = new Long(0);
		List<Parametro> param = new ArrayList<Parametro>();
		
		param.add(new Parametro("rbds", filtro.getRbds()));
		
		fas = fasDao.getFASWithParamLimit(param, 
				opciones.getDraw(), opciones.getStart(), opciones.getLength(), opciones.getColumns().get(opciones.getSortColumn()), opciones.getSortDir());
		
		registros = fasDao.getFasTotalWithParam(param);
		
		List<FASVo> fasVO= new ArrayList<FASVo>();
		
		for(int i=0; i<fas.size(); i++) {
			
			FASView fasReg = fas.get(i);
			fasVO.add(new FASVo(fasReg.getConcursoId(), fasReg.getRbdId(), fasReg.getRbd(),
					fasReg.getAnexo(), fasReg.getNombreConcurso(), fasReg.getNombreEES(),
					fasReg.getEstadoConectado(),  fasReg.getTecnologia(), 
					fasReg.getOperadora(), fasReg.getNumFAS(), fasReg.getUrl(),
					fasReg.getVelocidadBajada(), fasReg.getVelocidadSubida(), fasReg.getFechaFAS()));
		}
		
		List<? extends Object> data = fasVO;
		
		DatatableResponse fasResult = new DatatableResponse(parametros.getOpciones().getDraw(), registrosAll, registros, (ArrayList<Object>) data);
		
		return fasResult;
	}

	@Override
	public TicketVo getTicketDetalle(Integer nro_ticket) {
		
		TicketView ticket = ticketDao.getTicketDetail(nro_ticket);
		
		TicketVo ticketVo = new TicketVo(ticket.getNroTicketCallCenter(), ticket.getRbd(), null,
				ticket.getAnexo(), ticket.getEstadoEES(), ticket.getNombreEstablecimiento(),
				ticket.getRegion(), ticket.getComuna(), ticket.getOperadora(),
				ticket.getOrigen(), ticket.getGeneraWF(), ticket.getEscalable(),
				ticket.getEstado(), ticket.getTipo(), ticket.getCategoria(),
				ticket.getEscalarA(), ticket.getNroTicketEscalado(), ticket.getGeneradoOperadora(),
				ticket.getFechaAtencion(), ticket.getFechaCambioEstado(),
				ticket.getFechaCambioEstado(), ticket.getTecnologia(), ticket.getMotivo(),
				ticket.getComentario());
		
		return ticketVo;
	}

	@Override
	public DatatableResponse getListadoTicket(DatatableRequestTicket parametros) {
		
		List<TicketView> tickets;
		FiltroTicket filtro = parametros.getFiltro();
		DatatableOptions opciones = parametros.getOpciones();
		Long registrosAll = ticketDao.getTotalRegistros();
		List<Parametro> param = new ArrayList<Parametro>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIni = null;
		Date fechaFin = null;
		
		if (filtro.getFechaIni()!=null)
			fechaIni = filtro.getFechaIni();
		if(filtro.getFechaFin()!=null)
			fechaFin = filtro.getFechaFin();	
		param.add(new Parametro("categoria", filtro.getCategoria()));
		param.add(new Parametro("tipo", filtro.getTipo()));
		param.add(new Parametro("estado", filtro.getEstadoTicket()));
		param.add(new Parametro("operadora", filtro.getOperadora()));
		param.add(new Parametro("tecnologia", filtro.getTecnologia()));
		param.add(new Parametro("region", filtro.getRegion()));
		param.add(new Parametro("comuna", filtro.getComuna()));
		param.add(new Parametro("rbds", filtro.getRbds()));
			
		tickets = ticketDao.getTicketWithParamsLimit(param, fechaIni, fechaFin,
					opciones.getDraw(), opciones.getStart(), opciones.getLength(), opciones.getColumns().get(opciones.getSortColumn()), opciones.getSortDir());
			
		Long registros = ticketDao.getRegistrosFiltrados(param, fechaIni, fechaFin);			
		
		List<TicketVo> ticketVo= new ArrayList<TicketVo>();
		
		for(int i=0; i<tickets.size(); i++) {
			
			TicketView ticket = tickets.get(i);
			ticketVo.add(new TicketVo(ticket.getNroTicketCallCenter(), ticket.getRbd(), null,
					ticket.getAnexo(), ticket.getEstadoEES(), ticket.getNombreEstablecimiento(),
					ticket.getRegion(), ticket.getComuna(), ticket.getOperadora(),
					ticket.getOrigen(), ticket.getGeneraWF(), ticket.getEscalable(),
					ticket.getEstado(), ticket.getTipo(), ticket.getCategoria(),
					ticket.getEscalarA(), ticket.getNroTicketEscalado(), ticket.getGeneradoOperadora(),
					ticket.getFechaAtencion(), ticket.getFechaCambioEstado(),
					ticket.getFechaCambioEstado(), ticket.getTecnologia(), ticket.getMotivo(),
					ticket.getComentario()));
		}
		
		List<? extends Object> data = ticketVo;
		
		DatatableResponse ticketResult = new DatatableResponse(parametros.getOpciones().getDraw(), registrosAll, registros, (ArrayList<Object>) data);
		
		return ticketResult;
	}

	@Override
	public File getReporteEscuelas(FiltroEscuelas filtros) {
		
		List<EscuelasView> escuelas;
		ArrayList<entidades.Filtro> filtroRep = new ArrayList<entidades.Filtro>();
		ArrayList<infoRbd> rbds = new ArrayList<>();
		Calendar calendario= Calendar.getInstance();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCierre = "ENERO 2017";
		String titulo = "Informe RBD";
		
		if (filtros.getConcurso()!=null)
			filtroRep.add(new entidades.Filtro("Concurso", filtrosDao.getConcurso(filtros.getConcurso()).getNombre()));
		if (filtros.getOperadora()!=null) 
			filtroRep.add(new entidades.Filtro("Operadora", filtrosDao.getOperadora(filtros.getOperadora()).getNombreSocialTx()));
		if (filtros.getTecnologia()!=null) 
			filtroRep.add(new entidades.Filtro("Tecnología", filtrosDao.getTecnologia(filtros.getTecnologia()).getNombreTx()));
		if (filtros.getEstado()!=null) {
			if (filtros.getSubestado()!=null)
				filtroRep.add(new entidades.Filtro("Estado Adjudicación", filtrosDao.getAdjudicado(filtros.getSubestado()).getAdjudicadoEstadoTx()));
			else
				filtroRep.add(new entidades.Filtro("Estado Adjudicación", filtrosDao.getAdjudicado(filtros.getEstado()).getAdjudicadoEstadoTx()));
		}
		if (filtros.getInstalacion()!=null)
			filtroRep.add(new entidades.Filtro("Estado Instalación", filtrosDao.getConectadoEstado(filtros.getInstalacion()).getConectadoEstadoTx()));
		if (filtros.getMineduc()!=null)
			filtroRep.add(new entidades.Filtro("Estado Mineduc", filtrosDao.getMineducEstados(filtros.getMineduc()).getMineducEstadoTx()));
		if (filtros.getComuna()!=null)
			filtroRep.add(new entidades.Filtro("Comuna", filtrosDao.getComuna(filtros.getComuna()).getNombreComunaTx()));
		if (filtros.getRegion()!=null)
			filtroRep.add(new entidades.Filtro("Región", filtrosDao.getRegion(filtros.getRegion()).getNombreRegionTx()));
		if(filtros.getRbds()!=null)
			filtroRep.add(new entidades.Filtro("Rbds", filtros.getRbds().toString()));
		
		List<Parametro> param = new ArrayList<Parametro>();
		
		param.add(new Parametro("operadora", filtros.getOperadora()));
		param.add(new Parametro("adjudicacion", (filtros.getSubestado()!=null)?filtros.getSubestado():filtros.getEstado()));
		param.add(new Parametro("instalacion", filtros.getInstalacion()));
		param.add(new Parametro("mineduc", filtros.getMineduc()));
		param.add(new Parametro("tecnologia", filtros.getTecnologia()));
		param.add(new Parametro("region", filtros.getRegion()));
		param.add(new Parametro("comuna", filtros.getComuna()));
		param.add(new Parametro("rbds", filtros.getRbds()));

		escuelas = escuelasDao.getEscuelasWithParam(param);
		
		for(int i=0; i<escuelas.size(); i++) {
			EscuelasView escuela = escuelas.get(i);
			if (i==29) {
				if (escuela.getMatricula()!=null){
					escuela.getMatricula();
				}
				
				if (escuela.getSubEstadoAdjudicado()!= null) {
					escuela.getSubEstadoAdjudicado();
				}
			}
			
				
			rbds.add(new infoRbd(escuela.getRbd().toString(), escuela.getNombreEES(), escuela.getRegion(),
					escuela.getComuna(), escuela.getDireccion(), escuela.getMatricula()!=null?escuela.getMatricula().toString():null,
					escuela.getSubEstadoAdjudicado(), escuela.getEstadoConectado(),
					escuela.getEstadoMineduc(), escuela.getTecnologia(), escuela.getOperadora(),
					escuela.getPrecioMensual()!=null?escuela.getPrecioMensual().toString():null, escuela.getVelocidadBajada()!=null?escuela.getVelocidadBajada().toString():null, 
					escuela.getVelocidadSubida()!=null?escuela.getVelocidadSubida().toString():null));
		}
		
		InformeRBD informe = new InformeRBD(ruta, titulo, formato.format(calendario.getTime()), filtroRep, fechaCierre, rbds);
		
		try {
			
			Export export = new Export();
			ruta = export.generarInformeRBD(informe,ruta);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File file = new File(ruta);
		
		if (!file.exists()){
			if (!file.exists()){
	            try {
					throw new FileNotFoundException("file was not found.");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
        }
		
		return file;
	}

	@Override
	public File getReporteTickets(FiltroTicket filtro) {

		List<TicketView> tickets;
		List<Parametro> param = new ArrayList<Parametro>();
		ArrayList<entidades.Filtro> filtroRep = new ArrayList<entidades.Filtro>();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String ruta = "/home/carmen/Documentos/informes/";
		Calendar calendario= Calendar.getInstance();
		String fechaCierre = "ENERO 2017";
		String titulo = "Informe Ticket";
		
		if (filtro.getFechaIni()!=null)
			filtroRep.add(new entidades.Filtro("Fecha Inicial", formato.format(filtro.getFechaIni())));
		if (filtro.getFechaFin()!=null)
			filtroRep.add(new entidades.Filtro("Fecha Fin", formato.format(filtro.getFechaFin())));
		if (filtro.getCategoria()!=null) 
			filtroRep.add(new entidades.Filtro("Categoría", filtro.getCategoria()));
		if(filtro.getTipo()!=null)
			filtroRep.add(new entidades.Filtro("Tipo", filtro.getTipo()));
		if (filtro.getEstadoTicket()!=null)
			filtroRep.add(new entidades.Filtro("Estado Ticket", filtro.getEstadoTicket()));
		if(filtro.getOperadora()!=null)
			filtroRep.add(new entidades.Filtro("Operadora", filtrosDao.getOperadora(filtro.getOperadora()).getNombreSocialTx()));
		if (filtro.getTecnologia()!=null) 
			filtroRep.add(new entidades.Filtro("Tecnología", filtrosDao.getTecnologia(filtro.getTecnologia()).getNombreTx()));
		if (filtro.getRegion()!=null)
			filtroRep.add(new entidades.Filtro("Región", filtrosDao.getRegion(filtro.getRegion()).getNombreRegionTx()));
		if (filtro.getComuna()!=null)
			filtroRep.add(new entidades.Filtro("Comuna", filtrosDao.getComuna(filtro.getComuna()).getNombreComunaTx()));
		if(filtro.getRbds()!=null)
			filtroRep.add(new entidades.Filtro("Rbds", filtro.getRbds().toString()));
		
		param.add(new Parametro("categoria", filtro.getCategoria()));
		param.add(new Parametro("tipo", filtro.getTipo()));
		param.add(new Parametro("estado", filtro.getEstadoTicket()));
		param.add(new Parametro("operadora", filtro.getOperadora()));
		param.add(new Parametro("tecnologia", filtro.getTecnologia()));
		param.add(new Parametro("region", filtro.getRegion()));
		param.add(new Parametro("comuna", filtro.getComuna()));
		param.add(new Parametro("rbds", filtro.getRbds()));
			
		tickets = ticketDao.getTicketWithParams(param, filtro.getFechaIni(), filtro.getFechaFin());
			
		
		ArrayList<Ticket> ticketList = new ArrayList<>();
		
		for(int i=0; i<tickets.size(); i++) {
			
			TicketView ticket = tickets.get(i);
			ticketList.add(new Ticket(((Integer)ticket.getNroTicketCallCenter()).toString(), ticket.getRbd().toString(),
					ticket.getNombreEstablecimiento(), ticket.getRegion(), ticket.getComuna(), 
					ticket.getOperadora(), formato.format(ticket.getFechaAtencion()),
					ticket.getOrigen(), ticket.getCategoria(), ticket.getTipo(),
					ticket.getEstado(), ticket.getOperadora()));
		}
		
		InformeTicket informe = new InformeTicket(filtroRep, ticketList, ruta, titulo, formato.format(calendario.getTime()), 
				fechaCierre);
		
		try {
			
			Export export = new Export();
			ruta =export.generarInformeTicket(informe, ruta);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File file = new File(ruta);
		
		if (!file.exists()){
			if (!file.exists()){
	            try {
					throw new FileNotFoundException("file was not found.");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	        }
        }
		
		return file;
	}
}
