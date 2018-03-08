package cl.aba.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import cl.aba.business.service.BusquedaService;
import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableRequestTicket;
import cl.aba.business.vo.ErrorVo;
import cl.aba.business.vo.EscuelasVo;
import cl.aba.business.vo.FASVo;
import cl.aba.business.vo.FiltroEscuelas;
import cl.aba.business.vo.FiltroTicket;
import cl.aba.business.vo.TicketVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Controller
public class BusquedaController {
	
	protected Logger log = Logger.getLogger(getClass().getName());
	@Autowired
	private BusquedaService busquedaService;
	
	@RequestMapping(value = "escuelas", method = RequestMethod.POST, 
			headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> getEscuelasWithParams(
			@Valid @RequestBody  DatatableRequest request) throws IOException {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		String jsonString="";
		System.out.println("Busqueda Escuelas");
		
		try {
			
			jsonString = json.toJson(busquedaService.getListadoEscuelas(request)).toString();
			System.out.println("Termino consulta");
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
			
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "concursos/{concurso_id}/rbds/{rbd_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getEscuelaDetalle(
			@PathVariable Integer concurso_id,
			@PathVariable Integer rbd_id) {
		
		try {
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			Map<String, EscuelasVo> model = new HashMap<String, EscuelasVo>();
			
			model.put("escuela", busquedaService.getEscuelaDetalle(concurso_id, rbd_id));
			
			return new ResponseEntity<>(json.toJson(model), responseHeaders, HttpStatus.OK);
			
		} catch (Exception ex) {
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value = "fas", method = RequestMethod.POST, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> getFasWithParams(
			@Valid @RequestBody  DatatableRequest request) throws IOException {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			
			String jsonString = json.toJson(busquedaService.getListadoFAS(request)).toString();
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value = "concursos/{concurso_id}/fas/{rbd_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getFASDetalle(
			@PathVariable Integer concurso_id,
			@PathVariable Integer rbd_id) {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			Map<String, FASVo> model = new HashMap<String, FASVo>();
			
			model.put("fas", busquedaService.getFASDetalle(concurso_id, rbd_id));
			
			return new ResponseEntity<>(json.toJson(model), responseHeaders, HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "tickets", method = RequestMethod.POST, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> getTicketsWithParams(
			@Valid @RequestBody  DatatableRequestTicket request) throws IOException {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			
			String jsonString = json.toJson(busquedaService.getListadoTicket(request)).toString();
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "ticketmodal", method=RequestMethod.GET)
	public String ticketDetalle(@RequestParam("id") Integer id, Model model) {
		
		try {
			TicketVo ticketDetalle = busquedaService.getTicketDetalle(id);
			
			model.addAttribute("ticket", ticketDetalle);
			
			return "ticketmodal";
			
		} catch (Exception ex) {
			
			ErrorVo error = new ErrorVo();
			
			if (ex.getCause().getClass().equals(JDBCConnectionException.class)) {
				error.setCode(500);
				error.setDescription("Error de conexión con el servidor de base de datos. Por favor, revise su conexión a la red.");
			} else {
				error.setCode(500);
				error.setDescription("Ha ocurrido un error desconocido. Por favor intente más tarde.");
			}
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			model.addAttribute("error", error);
			return "error";
		}
		
	}
	
	@RequestMapping(value = "reportes/escuelas.xls", method = RequestMethod.GET, 
			headers="Accept=*/*", produces = "application/vnd.ms-excel")
	public @ResponseBody void getReporteEscuelas(
			@RequestParam(value="concurso") Integer concurso,
			@RequestParam(value="operadora") Integer operadora,
			@RequestParam(value="estado") Integer estado,
			@RequestParam(value="subestado") Integer subestado,
			@RequestParam(value="instalacion") Integer instalacion,
			@RequestParam(value="mineduc") Integer mineduc,
			@RequestParam(value="tecnologia") Integer tecnologia,
			@RequestParam(value="region") Integer region,
			@RequestParam(value="comuna") Integer comuna,
			@RequestParam(value="rbds") String rbds,
			HttpServletResponse response) throws IOException {
		
		try {
			
			List<Integer> listRbds = new ArrayList<Integer>();
			
			if (rbds!="") {
				String[] rbdsArray = rbds.split(";");
				
				for(int i=0; i<rbdsArray.length; i++) {
					listRbds.add(Integer.parseInt(rbdsArray[i]));
				}
			} else listRbds = null;
			
			FiltroEscuelas filtro = new FiltroEscuelas(concurso,operadora, estado, subestado,
					instalacion, mineduc, tecnologia, region, comuna, listRbds);
			File file = busquedaService.getReporteEscuelas(filtro);
			InputStream in = new FileInputStream(file);

	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        FileCopyUtils.copy(in, response.getOutputStream());
	        
		}  catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			response.setStatus(500);
		}
		
        
	}
	
	@RequestMapping(value = "reportes/tickets.xls", method = RequestMethod.GET, 
			headers="Accept=*/*", produces = "application/vnd.ms-excel")
	public @ResponseBody void getReporteTickets(@RequestParam(value="fechaIni") String fechaIni,
			@RequestParam(value="fechaFin") String fechaFin,
			@RequestParam(value="categoria") String categoria,
			@RequestParam(value="tipo") String tipo,
			@RequestParam(value="estado") String estado,
			@RequestParam(value="operadora") Integer operadora,
			@RequestParam(value="tecnologia") Integer tecnologia,
			@RequestParam(value="region") Integer region,
			@RequestParam(value="comuna") Integer comuna,
			@RequestParam(value="rbds") String rbds,
			HttpServletResponse response) throws IOException {
		
		List<Long> listRbds = new ArrayList<Long>();
		
		if (rbds!="") {
			
			String[] rbdsArray = rbds.split(";");
			for(int i=0; i<rbdsArray.length; i++) {
				listRbds.add(Long.parseLong(rbdsArray[i]));
			}
		} else listRbds = null;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecIni = null;
		Date fecFin = null;
		
		try {
			
			fecIni = formato.parse(fechaIni);
			fecFin = formato.parse(fechaFin);
			
			FiltroTicket filtro = new FiltroTicket(fecIni, fecFin, categoria!=""?categoria:null, tipo!=""?tipo:null,
					estado!=""?estado:null, operadora, tecnologia, region, comuna, listRbds);
			File file = busquedaService.getReporteTickets(filtro);
			InputStream in = new FileInputStream(file);

	        response.setContentType("application/vnd.ms-excel");
	        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        FileCopyUtils.copy(in, response.getOutputStream());
	        
		} catch (Exception e) {
			log.error("Ha ocurrido un error: " + e.getMessage(), e.getCause());
			response.setStatus(500);
		}
	}
}
