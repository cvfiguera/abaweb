package cl.aba.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aba.business.service.sftp.SftpService;

@Service
public class ReportesServiceImpl  implements ReportesService{

	@Autowired
	private SftpService sftpService;
	
	@Override
	public String reportesTicket() {
		// TODO Auto-generated method stub
		return sftpService.listDirectorioTicket();
	}

	

	@Override
	public String getReportes(String tab) {
		// TODO Auto-generated method stub
		return sftpService.listReportes("reportes", tab);
	}



	@Override
	public String downloadFile(String rutaArchivo, String tab) {
		// TODO Auto-generated method stub
		String ret = "";
		if(tab.trim().toUpperCase().equals("TICKET")){
			ret = sftpService.downloadFile(rutaArchivo, "ticket", tab);
		}else{
			ret = sftpService.downloadFile(rutaArchivo, "reportes", tab);
		}
		return ret;
	}




	

}
