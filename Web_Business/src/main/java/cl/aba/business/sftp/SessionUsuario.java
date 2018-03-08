package cl.aba.business.sftp;

import com.jcraft.jsch.UserInfo;

public class SessionUsuario implements UserInfo{
	/** The pass phrase. */
	private String passPhrase;

	/** The password. */
	@SuppressWarnings("unused")
	private String password;

	/**
	 * Instantiates a new session usuario.
	 * 
	 * @param password
	 *            the password
	 * @param passPhrase
	 *            the pass phrase
	 */
	public SessionUsuario(String password, String passPhrase) {

		this.password = password;

		this.passPhrase = passPhrase;

	}

	/**
	 * Gets the pass phrase.
	 * 
	 * @return the pass phrase
	 */
	public String getPassPhrase() {
		return passPhrase;
	}

	/**
	 * Sets the pass phrase.
	 * 
	 * @param passPhrase
	 *            the new pass phrase
	 */
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#getPassphrase()
	 */
	@Override
	public String getPassphrase() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#getPassword()
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#promptPassphrase(java.lang.String)
	 */
	@Override
	public boolean promptPassphrase(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#promptPassword(java.lang.String)
	 */
	@Override
	public boolean promptPassword(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#promptYesNo(java.lang.String)
	 */
	@Override
	public boolean promptYesNo(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jcraft.jsch.UserInfo#showMessage(java.lang.String)
	 */
	@Override
	public void showMessage(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("SUserInfo.showMessage()");
	}}
