package cl.aba.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cl.aba.business.service.FiltrosService;
import cl.aba.business.vo.ErrorVo;
import cl.aba.business.vo.FiltroEES;
import cl.aba.business.vo.FiltroEscuelas;
import cl.aba.business.vo.FiltroTicket;

@Controller
public class AbaController {

	protected Logger log = Logger.getLogger(getClass().getName());
	@Autowired
	private FiltrosService filtro;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
			return "login";
	}
	
	@RequestMapping(value = "busquedas", method = RequestMethod.GET)
	public String inicio(Model model) {

		try {

			Calendar calendario = Calendar.getInstance();
			FiltroTicket filtroTicket = new FiltroTicket();
			FiltroEscuelas filtroOpt = new FiltroEscuelas();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			model.addAttribute("filtrosTicket", filtroTicket);
			model.addAttribute("filtros", filtroOpt);
			model.addAttribute("concurso", filtro.getConcursos());
			model.addAttribute("operadora", filtro.getOperadoras());
			model.addAttribute("adjudicacion", filtro.getAdjudicadoEstados());
			model.addAttribute("conectado", filtro.getConectadoEstados());
			model.addAttribute("mineduc", filtro.getMineducEstados());
			model.addAttribute("tecnologia", filtro.getTecnologias());
			model.addAttribute("region", filtro.getRegiones());
			calendario.set(Calendar.DATE, 1);
			model.addAttribute("fechaIni", formato.format(calendario.getTime()));
			calendario = Calendar.getInstance();
			calendario.add(Calendar.DATE, -1);
			model.addAttribute("fechaFin", formato.format(calendario.getTime()));
			model.addAttribute("categorias", filtro.getCategoriasOld());
			model.addAttribute("tipos", filtro.getTipoOld());
			model.addAttribute("estados", filtro.getEstadoOld());
			model.addAttribute("operadoras", filtro.getOperadorasOld());
			model.addAttribute("tecnologias", filtro.getTecnologiaOld());
			model.addAttribute("regiones", filtro.getRegionesOld());

			return "busquedas";

		} catch (Exception ex) {

			ErrorVo error = new ErrorVo();

			if (ex.getCause().getClass().equals(JDBCConnectionException.class)) {
				error.setCode(500);
				error.setDescription(
						"Error de conexión con el servidor de base de datos. Por favor, revise su conexión a la red.");
			} else {
				error.setCode(500);
				error.setDescription("Ha ocurrido un error desconocido. Por favor intente más tarde.");
			}
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			model.addAttribute("error", error);
			return "error";
		}

	}

	@RequestMapping(value = "ees", method = RequestMethod.GET)
	public String ees(Model model) {

		try {
			
			FiltroEES filtroOpt = new FiltroEES();

			model.addAttribute("filtros", filtroOpt);
			model.addAttribute("concurso", filtro.getConcursos());
			model.addAttribute("adjudicacion", filtro.getAdjudicadoEstados());
			model.addAttribute("conexion", filtro.getConectadoEstados());
			model.addAttribute("region", filtro.getRegiones());

			return "ees";
			
		} catch (Exception ex) {

			ErrorVo error = new ErrorVo();

			if (ex.getCause().getClass().equals(JDBCConnectionException.class)) {
				error.setCode(500);
				error.setDescription(
						"Error de conexión con el servidor de base de datos. Por favor, revise su conexión a la red.");
			} else {
				error.setCode(500);
				error.setDescription("Ha ocurrido un error desconocido. Por favor intente más tarde.");
			}
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			model.addAttribute("error", error);
			return "error";
		}
	}

	@RequestMapping(value = "graficos", method = RequestMethod.GET)
	public String graficos(Model model) {

		return "graficos";
	}

	@RequestMapping(value = "reportes", method = RequestMethod.GET)
	public String reportes(Model model) {

		return "reportes";
	}

	@RequestMapping(value = "reporteTicketOperadora", method = RequestMethod.GET)
	public String ticketOperadora(Model model) {
		System.out.println("Ticket Operadoras");
		return "ticketOperadoras";
	}
}
