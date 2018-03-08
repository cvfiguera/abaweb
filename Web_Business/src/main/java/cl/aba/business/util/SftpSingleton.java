package cl.aba.business.util;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

@Component("sftpSingleton")
@Scope("singleton")
public class SftpSingleton {
	
	private Session session;
	
    private Session sessionRepor;
	
	private ChannelSftp channelSftp;
	
	private ChannelSftp channelSftpRepor;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSessionRepor() {
		return sessionRepor;
	}

	public void setSessionRepor(Session sessionRepor) {
		this.sessionRepor = sessionRepor;
	}

	public ChannelSftp getChannelSftp() {
		return channelSftp;
	}

	public void setChannelSftp(ChannelSftp channelSftp) {
		this.channelSftp = channelSftp;
	}

	public ChannelSftp getChannelSftpRepor() {
		return channelSftpRepor;
	}

	public void setChannelSftpRepor(ChannelSftp channelSftpRepor) {
		this.channelSftpRepor = channelSftpRepor;
	}

	
}
