package cl.aba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import cl.aba.business.service.FiltrosService;
import cl.aba.business.vo.EstadoVo;

@Controller
public class FiltrosController {

	@Autowired
	private FiltrosService filtrosService;
	
	@RequestMapping(value = "operadoras", method = RequestMethod.GET, 
			produces = "application/json", headers="Accept=*/*", consumes = "application/json")
	public ResponseEntity<String> getOperadoras() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("operadoras", filtrosService.getOperadoras());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "estados", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getEstadosAdjudicado() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("estados", filtrosService.getAdjudicadoEstados());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "subestados", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getSubestadosAdjudicado(@RequestParam(value= "id") Integer id) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("subestados", filtrosService.getAdjudicadoSubestados(id));
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "mineduc", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getEstadosMineduc() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("estados_mineduc", filtrosService.getMineducEstados());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "conectados", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getEstadosConectado() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("estados_conectado", filtrosService.getConectadoEstados());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "tecnologias", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getTecnologias() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("tecnologias", filtrosService.getTecnologias());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "regiones", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getRegiones() {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("regiones", filtrosService.getRegiones());
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "comunas", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getComunas(@RequestParam(value= "id") Integer id) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("comunas", filtrosService.getComunas(id));
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "comunas_old", method = RequestMethod.GET, 
			 headers="Accept=*/*", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> getComunasTicket(@RequestParam(value= "id") Integer id) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		Map<String, List<EstadoVo>> model = new HashMap<String, List<EstadoVo>>();
		
		model.put("comunas", filtrosService.getComunasOld(id));
		String jsonString = json.toJson(model).toString();
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
}
