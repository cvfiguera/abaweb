package cl.aba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import cl.aba.business.service.GraficosService;

@Controller
public class GraficosController {

	@Autowired
	GraficosService graficosService;
	
	@RequestMapping(value = "graficos", method = RequestMethod.GET, 
			produces = "application/json", headers="Accept=*/*", consumes = "application/json")
	public ResponseEntity<String> getGraficos(
			@RequestParam(value= "tipoGrafico") Integer tipoGrafico,
			@RequestParam(value= "parametroCero") Integer concursoId,
			@RequestParam(value= "parametroUno") Integer adjudicacionId,
			@RequestParam(value= "parametroDos") Integer mineducId,
			@RequestParam(value= "parametroTres") Integer conectadoId,
			@RequestParam(value= "parametroCuatro") Integer operadoraId,
			@RequestParam(value= "parametroCinco") Integer tecnologiaId) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson json = new Gson();
		String jsonString= "";
		
		long inicio = System.currentTimeMillis();
		
		if (tipoGrafico==0)
			jsonString = json.toJson(graficosService.getConsursoGrafico()).toString();
		
		if (tipoGrafico==1 && concursoId!=null)
			jsonString = json.toJson(graficosService.getAdjudicacionGrafico(concursoId)).toString();
		
		if (tipoGrafico==2 && adjudicacionId!=null)
			jsonString = json.toJson(graficosService.getMineducGrafico(adjudicacionId,concursoId)).toString();
		
		if (tipoGrafico==3 && adjudicacionId!=null && mineducId!=null)
			jsonString = json.toJson(graficosService.getInstalacionGrafico(adjudicacionId, mineducId,concursoId)).toString();
		
		if (tipoGrafico==4 && adjudicacionId!=null && mineducId!=null && conectadoId!=null)
			jsonString = json.toJson(graficosService.getOperadoraGrafico(adjudicacionId, mineducId, conectadoId,concursoId)).toString();
		
		if (tipoGrafico==5 && adjudicacionId!=null && mineducId!=null && conectadoId!=null && operadoraId!=null)
			jsonString = json.toJson(graficosService.getTecnologiaGrafico(adjudicacionId, mineducId, conectadoId, operadoraId,concursoId)).toString();
		
		if (tipoGrafico==6 && adjudicacionId!=null && mineducId!=null && conectadoId!=null && operadoraId!=null
				&& tecnologiaId!=null)
			jsonString = json.toJson(graficosService.getRegionGrafico(adjudicacionId, mineducId, conectadoId, operadoraId, tecnologiaId,concursoId)).toString();
		long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
	    System.out.println(tiempo +" segundos");
		
		return new ResponseEntity<>(jsonString, responseHeaders, HttpStatus.OK);
	}
	
}
