package cl.aba.business.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class ParametrosSftp {
	
	private String  user;
	private String  host;
	private String  pass;
	private String  port;
	private String  remoto;
	private Session session = null;
	private Channel channel;
	private ChannelSftp channelSftp;
	
	
	
	public ParametrosSftp(String user, String host, String pass, String port,
			String remoto) {
		super();
		this.user = user;
		this.host = host;
		this.pass = pass;
		this.port = port;
		this.remoto = remoto;
	}
	public ParametrosSftp(String user, String host, String pass, String port) {
		super();
		this.user = user;
		this.host = host;
		this.pass = pass;
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getRemoto() {
		return remoto;
	}
	public void setRemoto(String remoto) {
		this.remoto = remoto;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public ChannelSftp getChannelSftp() {
		return channelSftp;
	}
	public void setChannelSftp(ChannelSftp channelSftp) {
		this.channelSftp = channelSftp;
	}
	
	
	

}
