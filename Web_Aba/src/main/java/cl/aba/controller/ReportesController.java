/*
 * 
 */
package cl.aba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.aba.business.service.ReportesService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportesController. Controlador para los reportes Muestra los
 * archivos de un SFTP, Adicionalmente permite descargar estos archivos al
 * navegador
 */
@Controller
public class ReportesController extends ControllerGeneric {

	/** The reportes service. */
	@Autowired
	private ReportesService reportesService;

	/**
	 * Gets the reportes. Muestra los archivos de los ticket de las operadoras
	 * Obtiene el arbol desde el SFTP de las operadoras
	 * 
	 * @param model
	 *            the model
	 * @return the reportes, String con el contenido del arbol de los archivos
	 */
	@RequestMapping(value = "reporteTicket", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	@ResponseBody
	public String getReportes(Model model) {
		info("REPORTES TICKET");
		String ret = reportesService.reportesTicket();
		return ret;
	}

    @RequestMapping(value="downloadFile/{types}", method=RequestMethod.GET, produces="application/*",headers = "Accept=*/*")
    public @ResponseBody void downloadAll(HttpServletResponse response,@PathVariable("types") String types,@RequestParam("fil") String fil) throws IOException{
    	String ret = reportesService.downloadFile(fil, types);
    	File file = new File(ret);
    	InputStream in = new FileInputStream(file);
    	
    	String mimeType = URLConnection.guessContentTypeFromName ( file.getName () );
    	if (mimeType == null) {
			System.out.println ( "mimetype is not detectable, will take default" );
			mimeType = "application/octet-stream";
		}
    	
    	response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

	/**
	 * Gets the reportes CC. Muestra los archivos de Gestion Call Center Obtiene
	 * los archivos desde un SFPT
	 *
	 * @param model
	 *            the model
	 * @return the reportes CC Retorna un String para dibujar el arbol
	 */
	@RequestMapping(value = "gestionCC", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	@ResponseBody
	public String getReportesCC(Model model) {
		info("REPORTES CALL CENTER");
		String ret = reportesService.getReportes("gestionCC");
		return ret;
	}

	/**
	 * Gets the reporte operadora. Muestra los archivos del SFTP, carpeta
	 * Reporte Operadora
	 *
	 * @param model
	 *            the model
	 * @return the reporte operadora Retorna un String con el arbol para dibujar
	 *         los nodos
	 */
	@RequestMapping(value = "reporteO", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	@ResponseBody
	public String getReporteOperadora(Model model) {
		info("REPORTES OPERADORA");
		String ret = reportesService.getReportes("reporteO");
		return ret;
	}

	/**
	 * Gets the gestion entelgy. Muestra archivos de Gestion Entelgy
	 *
	 * @param model
	 *            the model
	 * @return String con el contenido de gestion Entelgy
	 */
	@RequestMapping(value = "gestionE", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	@ResponseBody
	public String getGestionEntelgy(Model model) {
		info("REPORTES GESTION ENTELGY");
		String ret = reportesService.getReportes("gestionE");
		return ret;
	}

	/**
	 * Gets the estadistica reporte.
	 *
	 * @param model
	 *            the model
	 * @return String reportes Estadisticas
	 */
	@RequestMapping(value = "estadisticaR", method = RequestMethod.GET, produces = "application/json", headers = "Accept=*/*")
	@ResponseBody
	public String getEstadisticaReporte(Model model) {
		info("REPORTE ESTADISTICA");
		String ret = reportesService.getReportes("estadisticaR");
		return ret;
	}
	

}
