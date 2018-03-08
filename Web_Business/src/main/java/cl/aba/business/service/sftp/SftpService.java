package cl.aba.business.service.sftp;

public interface SftpService {
	
	public String listDirectorioTicket();
	
	public String downloadFile(String ruta, String usuario, String tab);
	
	public String listReportes(String usuario, String tab);
	
	public void conectarSftp();

}
