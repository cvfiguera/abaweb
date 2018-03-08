package cl.aba.business.sftp;

import java.util.Hashtable;

import com.jcraft.jsch.Logger;

public class MyLogger implements Logger{
	static Hashtable name = new Hashtable();
	static {
		name.put(new Integer(DEBUG), "DEBUG: ");
		name.put(new Integer(INFO), "INFO: ");
		name.put(new Integer(WARN), "WARN: ");
		name.put(new Integer(ERROR), "ERROR: ");
		name.put(new Integer(FATAL), "FATAL: ");
	}

	@Override
	public boolean isEnabled(int level) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void log(int level, String message) {
		// TODO Auto-generated method stub
		System.err.print(name.get(new Integer(level)));
		System.err.println(message);
		
	}

}
