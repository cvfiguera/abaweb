package cl.aba.business.service.sftp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;

import cl.aba.business.sftp.Sftp;
import cl.aba.business.util.SftpSingleton;
import cl.aba.business.util.SftpUtil;
import cl.aba.business.util.UsuarioSftp;
import cl.aba.business.util.WebBusiness;

@Service
public class SftpServiceImpl extends WebBusiness implements SftpService{
	

	
	@Autowired
	private UsuarioSftp usuarioSftp;
	
	@Autowired
	private SftpSingleton sftpSingleton;

	@Override
	public String listDirectorioTicket() {
		// TODO Auto-generated method stub
		String ret="";
		getConexion();
		String ruta = usuarioSftp.getRutaOperadoraTicket();
		SftpUtil utilSftp = new SftpUtil();
		String[] oper = this.usuarioSftp.getOperadorasTicket().split(";");
		if(!sftpSingleton.getChannelSftp().isConnected()){
			try {
				sftpSingleton.getChannelSftp().connect(30000);
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ret =ret + utilSftp.nodosJsTreeTicket(sftpSingleton.getChannelSftp(), ruta, 2,oper,true,true);
		
		return ret;
	}
	
	protected void getConexion(){
		
		Sftp sftp = new Sftp(usuarioSftp.getUserTicket(),usuarioSftp.getUrlTicket(),usuarioSftp.getPassTicket(),
				usuarioSftp.getPortTicket());
		if(sftpSingleton.getSession() == null || sftpSingleton.getChannelSftp()== null){
			if(sftpSingleton.getSession()==null){
				sftp.conexionSftp();
				sftp.getSession();
				sftpSingleton.setSession(sftp.getSession());
			}
			if(sftpSingleton.getChannelSftp()==null){
				sftp.conexionChannelSftp();
				sftpSingleton.setChannelSftp(sftp.getChannelSftp());
			}
		}
		
		if(sftpSingleton.getSessionRepor() == null || sftpSingleton.getChannelSftpRepor() ==null){
			sftp = new Sftp(usuarioSftp.getUserReporte(), usuarioSftp.getUrlReporte(),usuarioSftp.getPassReporte(),
					usuarioSftp.getPortReporte());
			if(sftpSingleton.getSessionRepor() == null){
				sftp.conexionSftp();
				sftpSingleton.setSessionRepor(sftp.getSession());
			}
			if(sftpSingleton.getChannelSftpRepor()==null){
				sftp.conexionChannelSftp();
				sftpSingleton.setChannelSftpRepor(sftp.getChannelSftp());
			}
		}
	}

	@Override
	public String listReportes(String usuario, String tab) {
		// TODO Auto-generated method stub
		info("Obteniendo Lista de archivos del Sftp");
		String ret = "";
		getConexion();
		String ruta="";
		SftpUtil utilSftp = new SftpUtil();
		if(tab.equals("gestionCC")){
			ruta = usuarioSftp.getRutaGestionCC();
		}
		else if(tab.equals("reporteO")){
			ruta = usuarioSftp.getRutareporteO();
		}else if(tab.equals("gestionE")){
			ruta = usuarioSftp.getRutagestionE();
		}else if(tab.equals("estadisticaR")){
			ruta = usuarioSftp.getRutaEstadistica();
		}
		if(!sftpSingleton.getChannelSftpRepor().isConnected()){
			info("Sftp Channel desconectado");
			try {
				sftpSingleton.getChannelSftpRepor().connect(3000);
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info("Buscando los archivos en Sftp");
		ret = utilSftp.nodosReportes(sftpSingleton.getChannelSftpRepor(), ruta, 1);
		return ret;
	}

	@Override
	public String downloadFile(String ruta, String usuario, String tab) {
		// TODO Auto-generated method stub
		getConexion();
		String ret = "";
		SftpUtil utilSftp = new SftpUtil();
		ChannelSftp channel = null;
		String remoto =""; 
		if(usuario.trim().toUpperCase().equals("TICKET")){
			remoto = usuarioSftp.getRutaOperadoraTicket();
			channel = sftpSingleton.getChannelSftp();
		}else if(usuario.trim().toUpperCase().equals("REPORTES")){
			channel = sftpSingleton.getChannelSftpRepor();
			if(tab.trim().toUpperCase().equals("GESTIONCALLCENTER")){
				remoto = usuarioSftp.getRutaGestionCC();
			}else if(tab.trim().toUpperCase().equals("REPORTEOPERADORA")){
				remoto = usuarioSftp.getRutareporteO();
			}else if(tab.trim().toUpperCase().equals("GESTIONENTELGY")){
				remoto = usuarioSftp.getRutagestionE();
			}else if(tab.trim().toUpperCase().equals("REPORTEESTADISTICA")){
				remoto = usuarioSftp.getRutaEstadistica();
			}
			
		}
		ret = utilSftp.downloadFile(channel, ruta, remoto,usuarioSftp.getDownloadTicket());
		return ret;
	}

	@Override
	public void conectarSftp() {
		// TODO Auto-generated method stub
		getConexion();
		
	}
	

	


}
