package cl.aba.business.sftp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;

public class Sftp extends ParametrosSftp {

	private boolean status;
	private String mensaje;
	private String remoto;
	private String archivo;
	private String local;
	private Date fechaSftp;
	private List<String> listArc;
	private int version;

	public Date getFechaSftp() {
		return fechaSftp;
	}

	public void setFechaSftp(Date fechaSftp) {
		this.fechaSftp = fechaSftp;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Sftp(String user, String host, String pass, String port, String remoto) {
		super(user, host, pass, port, remoto);
		// TODO Auto-generated constructor stub
	}

	public Sftp(String user, String host, String pass, String port) {
		super(user, host, pass, port);
		// TODO Auto-generated constructor stub
	}

	public void conexionSftp() {
		JSch.setLogger(new MyLogger());
		JSch jsch = new JSch();
		Session session = null;
		try {
			System.out.println(getUser() + " " + getHost() + " " + getPort() + " " + getPass());
			session = jsch.getSession(getUser(), getHost(), Integer.parseInt(getPort()));
			UserInfo ui = new SessionUsuario(getPass(), null);
			session.setUserInfo(ui);
			session.setPassword(getPass().getBytes());
			session.connect();
			setSession(session);
			setStatus(true);
			rutaRemoto();

		} catch (Exception e) {
			e.printStackTrace();
			setStatus(false);
			setMensaje("No se ha podido conectarse al sftp");

		}
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	protected List<String> getListaArchivos() {
		setListArc(null);
		final List<String> ret = new ArrayList<String>();
		try {
			ChannelSftp sftp = (ChannelSftp) getSession().openChannel("sftp");
			sftp.connect();
			String remoto = getRemoto();
			sftp.ls(remoto, new ChannelSftp.LsEntrySelector() {
				public int select(ChannelSftp.LsEntry le) {
					String nombre = String.valueOf(le);
					ret.add(nombre);
					return ChannelSftp.LsEntrySelector.CONTINUE;
				}
			});
			sftp.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			setStatus(false);
			setMensaje("No se han encontrado Archivos en ruta remota ");
			System.out.println("Mensaje " + e.getMessage());

		}
		return ret;
	}

	protected void rutaRemoto() {
		if (isStatus()) {
			try {
				Session session = getSession();
				Channel channel = session.openChannel("sftp");
				channel.connect();
				ChannelSftp c = (ChannelSftp) channel;
				String rem = c.pwd();
				setRemoto(rem);
				c.disconnect();
				channel.disconnect();
				setStatus(true);

			} catch (Exception e) {
				setStatus(false);
				setMensaje("No se ha podido obtenerse ruta");
			}
		}

	}

	public String getRemoto() {
		return remoto;
	}

	public void setRemoto(String remoto) {
		this.remoto = remoto;
	}



	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public void downloadGetFile() {

		String ret = "";
		String archivo = getArchivo();
		if (archivo != null) {
			archivo = archivo.substring((archivo.lastIndexOf("/") + 1), archivo.length());
			if (!archivo.trim().equals("")) {
				try {
					Session session = getSession();
					Channel channel = session.openChannel("sftp");
					channel.connect();
					ChannelSftp c = (ChannelSftp) channel;
					String local = getLocal();
					String remot = getRemoto() + getArchivo();
					c.get(remot, local);
					ret = local + "/" + archivo;
					channel.disconnect();
					setStatus(true);
					setArchivo(ret);

				} catch (Exception e) {
					System.out.println("Error  download " + e.getMessage());
					setStatus(false);
					e.printStackTrace();
					setMensaje("No se ha descargado el archivo");
				}
			} else {
				ret = "";
				setStatus(false);
				setMensaje("No se encontro el archivo");
			}
		}

	}
	public List<String> getListArc() {
		if (listArc == null) {
			listArc = new ArrayList<String>();
		}
		return listArc;
	}

	public void setListArc(List<String> listArc) {
		this.listArc = listArc;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public void conexionChannel(){
		Session session = getSession();
		Channel channel;
		try {
			channel = session.openChannel("sftp");
			channel.connect();
			setChannel(channel);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void conexionChannelSftp(){
		Session session = getSession();
		ChannelSftp sftp;
		try {
			sftp = (ChannelSftp) session.openChannel("sftp");
			sftp.connect(60000);
			setChannelSftp(sftp);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
