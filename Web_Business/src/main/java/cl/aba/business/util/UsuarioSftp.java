package cl.aba.business.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component("usuarioSftp")
@PropertySource("classpath:usersftp.properties")
@Scope("singleton")
public class UsuarioSftp {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Value("${ticket.user.sftp.user}")
	private String userTicket;
	
	@Value("${ticket.user.sftp.pass}")
	private String passTicket;
	
	@Value("${ticket.user.sftp.url}")
	private String urlTicket;
	
	@Value("${ticket.user.sftp.port}")
	private String portTicket;
	
	@Value("${ticket.download.local}")
	private String downloadTicket;
	
	@Value("${ticket.ruta.operador}")
	private String rutaOperadoraTicket;
	
	@Value("${ticket.operadora.nombre}")
	private String operadorasTicket;
	
	@Value("${reporte.sftp.user}")
	private String userReporte;
	
	@Value("${reporte.sftp.pass}")
	private String passReporte;
	
	@Value("${reporte.sftp.url}")
	private String urlReporte;
	
	@Value("${reporte.sftp.port}")
	private String portReporte;
	
	@Value("${reporte.sftp.gestioncc}")
	private String rutaGestionCC;
	
	@Value("${reporte.sftp.reporteO}")
	private String rutareporteO;
	
	@Value("${reporte.sftp.gestionE}")
	private String rutagestionE;
	
	@Value("${reporte.sftp.estadisticaR}")
	private String rutaEstadistica;

	public String getUserTicket() {
		return userTicket;
	}

	public String getPassTicket() {
		return passTicket;
	}

	public String getUrlTicket() {
		return urlTicket;
	}

	public String getPortTicket() {
		return portTicket;
	}

	public String getDownloadTicket() {
		return downloadTicket;
	}

	public String getRutaOperadoraTicket() {
		return rutaOperadoraTicket;
	}

	public String getOperadorasTicket() {
		return operadorasTicket;
	}

	public String getUserReporte() {
		return userReporte;
	}

	public String getPassReporte() {
		return passReporte;
	}

	public String getUrlReporte() {
		return urlReporte;
	}

	public String getPortReporte() {
		return portReporte;
	}

	public String getRutaGestionCC() {
		return rutaGestionCC;
	}

	public String getRutareporteO() {
		return rutareporteO;
	}

	public String getRutagestionE() {
		return rutagestionE;
	}

	public String getRutaEstadistica() {
		return rutaEstadistica;
	}
	
	
	

}
