package cl.aba.business.service;

public interface ReportesService {
	
	public String reportesTicket();
	
	public String getReportes(String tab);
	
	public String downloadFile(String rutaArchivo, String tab);
	
	

}
