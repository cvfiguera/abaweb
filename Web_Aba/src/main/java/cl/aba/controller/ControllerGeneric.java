package cl.aba.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;

public class ControllerGeneric {
	protected Logger log = Logger.getLogger(getClass().getName());

	final protected void error(String message) {
		log.error(message);
	}

	final protected void error(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void debug(String message) {
		log.error(message);
	}

	final protected void debug(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void info(String message) {
		log.info(message);
	}

	public void downloadFileGeneric(HttpServletResponse response, String arch) throws IOException {
		log.info("Iniciando Download Generico");
		File file = null;
		if (!arch.trim().equals("")) {
			file = new File(arch);
			if (!file.exists()) {
				log.error("No Existe el archivo");
				OutputStream outputStream;
				try {
					log.info("Se genera un archivo en blanco");
					outputStream = response.getOutputStream();
					outputStream.write("No existe el archivo".getBytes(Charset.forName("UTF-8")));
					outputStream.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				System.out.println("mimetype is not detectable, will take default");
				mimeType = "application/octet-stream";
			}

			System.out.println("mimetype : " + mimeType);

			response.setContentType(mimeType);

			/*
			 * "Content-Disposition : inline" will show viewable types [like
			 * images/text/pdf/anything viewable by browser] right on browser
			 * while others(zip e.g) will be directly downloaded [may provide
			 * save as popup, based on your browser setting.]
			 */
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			/*
			 * "Content-Disposition : attachment" will be directly download, may
			 * provide save as popup, based on your browser setting
			 */
			// response.setHeader("Content-Disposition",
			// String.format("attachment; filename=\"%s\"", file.getName()));
			response.setContentLength((int) file.length());
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			// Copy bytes from source to destination(outputstream in this
			// example),
			// closes both streams.
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} else {
			log.error("Archivo para descarga no Existe");
		}

	}

}
