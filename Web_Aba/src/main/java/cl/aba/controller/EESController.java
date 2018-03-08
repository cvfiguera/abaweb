package cl.aba.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import cl.aba.business.service.EesService;
import cl.aba.business.vo.AdjudicacionVo;
import cl.aba.business.vo.ContactoVo;
import cl.aba.business.vo.DatatableRequest;
import cl.aba.business.vo.DatatableResponse;
import cl.aba.business.vo.EESDetalle;
import cl.aba.business.vo.EESVo;
import cl.aba.business.vo.ErrorVo;
import cl.aba.business.vo.InstalacionVo;
import cl.aba.business.vo.ListaEsperaVo;
import cl.aba.business.vo.TicketVo;


@Controller
public class EESController {
	
	protected Logger log = Logger.getLogger(getClass().getName());
	@Autowired
	private EesService eesService;
	
	@RequestMapping(value = "eesrbd", method = RequestMethod.POST, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> getEESWithParams(
			@Valid @RequestBody  DatatableRequest request) throws IOException {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			
			String jsonString = json.toJson(eesService.getEESAll(request)).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "eesinstalacion", method = RequestMethod.GET, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> eesInstalacion(
			@RequestParam("concurso_id") Integer concurso_id,
			@RequestParam("rbd_id") Integer rbd_id) {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			List<InstalacionVo> instalacion = new ArrayList<InstalacionVo>();
			instalacion.add(eesService.getEESInstalacion(concurso_id, rbd_id));
			Map<String, List<InstalacionVo>> model= new HashMap<String, List<InstalacionVo>>();
			model.put("data", instalacion);
			
			String jsonString = json.toJson(model).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value = "eesadjudicacion", method = RequestMethod.GET, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> eesAdjudicacion(
			@RequestParam("concurso_id") Integer concurso_id,
			@RequestParam("rbd_id") Integer rbd_id) {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();
			List<AdjudicacionVo> adjudicacion = new ArrayList<AdjudicacionVo>();
			adjudicacion.add(eesService.getEESAdjudicacion(concurso_id, rbd_id));
			Map<String, List<AdjudicacionVo>> model= new HashMap<String, List<AdjudicacionVo>>();
			
			model.put("data", adjudicacion);
			
			String jsonString = json.toJson(model).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "eeslespera", method = RequestMethod.GET, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> eesLEspera(
		   @RequestParam("concurso_id") Integer concurso_id,
		   @RequestParam("rbd_id") Integer rbd_id) {
		
		try {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/json; charset=utf-8");
			Gson json = new Gson();

			Map<String, List<ListaEsperaVo>> model= new HashMap<String, List<ListaEsperaVo>>();
			
			model.put("data", eesService.getEESListaEspera(concurso_id, rbd_id));
			
			String jsonString = json.toJson(model).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
	
	@RequestMapping(value = "eestickets", method = RequestMethod.GET, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> eesTickets(
		   @RequestParam("concurso_id") Integer concurso_id,
		   @RequestParam("rbd_id") Integer rbd_id) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		String jsonString ="";
		
		try {
			
			Map<String, List<TicketVo>> model= new HashMap<String, List<TicketVo>>();
			
			model.put("data", eesService.getEESTickets(concurso_id, rbd_id));
			
			jsonString = json.toJson(model).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
			
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value = "eescontactos", method = RequestMethod.GET, headers="Accept=*/*",
			produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> eesContactos(@RequestParam("id") Integer id) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		String jsonString ="";
		
		try {
			
			Map<String, List<ContactoVo>> model= new HashMap<String, List<ContactoVo>>();
			
			model.put("data", eesService.getEESContactos(id));
			
			jsonString = json.toJson(model).toString();	
			
			return new ResponseEntity<>(jsonString, responseHeaders,  HttpStatus.OK);
			
		} catch (Exception ex) {
			
			log.error("Ha ocurrido un error: " + ex.getMessage(), ex.getCause());
			return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
