package cl.aba.business.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

public class SftpUtil extends  WebBusiness {

	public String nodosReportes(ChannelSftp sftp, String directorio, int nivel) {
		String ret = "[";
		
		if(sftp != null){
			try {
				System.out.println(directorio);
				sftp.cd(directorio);
				
				Vector files = sftp.ls("*");
				files = getOdernarFile(files, 0, files.size());
				for (int i = 0; i < files.size(); i++) {
					ChannelSftp.LsEntry file = (ChannelSftp.LsEntry) files.get(i);
					ret = ret + "{ \"id\" :\"" + file.getFilename() + "\"";
					ret = ret + ", \"text\" : \"" + file.getFilename() + "\"";
					if (file.getAttrs().isDir()) {

						ret = ret + ",\"icon\":\"resources/img/carpeta.png\"";
						ret = ret + ",\"children\":" + nodosReportes(sftp, new StringBuilder(String.valueOf(directorio))
								.append("/").append(file.getFilename()).toString(), nivel);
					} else {
						if (file.getFilename().trim().toUpperCase().lastIndexOf(".XLS") > 0
								|| file.getFilename().trim().toUpperCase().lastIndexOf(".XLSX") > 0) {
							ret = ret + ",\"icon\":\"resources/img/excel.gif\"";
						} else if (file.getFilename().trim().toUpperCase().lastIndexOf(".PDF") > 0) {
							ret = ret + ",\"icon\":\"resources/img/pdf.png\"";
						}
					}
					if (i == files.size() - 1) {
						ret = ret + " } ";
					} else {
						ret = ret + "},";
					}

				}
				ret = ret + "]";
			} catch (SftpException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else{
			error("ChannelSFTP null");
		}


		return ret;
	}

	public String nodosJsTreeTicket(ChannelSftp sftp, String directorio, int nivel, String[] ope, boolean oper,
			boolean tick) {
		String ret = "[";
		try {
			sftp.cd(directorio);
			Vector files = sftp.ls("*");
			files = getOdernarFile(files, 0, files.size());
			boolean raiz = true;
			for (int i = 0; i < files.size(); i++) {
				ChannelSftp.LsEntry file = (ChannelSftp.LsEntry) files.get(i);
				if (oper || tick) {
					if (oper) {
						for (int j = 0; j < ope.length; j++) {
							if (ope[j].equals(file.getFilename())) {
								if (!raiz) {
									ret = ret + ",";
								}
								ret = ret + "{ \"id\" :\"" + file.getFilename() + "\"";
								ret = ret + " , \"text\" : \"" + file.getFilename() + "\"";
								if (file.getAttrs().isDir()) {
									ret = ret + ",\"icon\":\"resources/img/carpeta.png\"";
									ret = ret + ",\"children\":"
											+ nodosJsTreeTicket(sftp,
													new StringBuilder(String.valueOf(directorio))
															.append(file.getFilename()).append("/").toString(),
													nivel, ope, false, true);
									raiz = false;
								}
								ret = ret + "}";
							}

						}
					} else if (tick) {
						if (file.getFilename().toUpperCase().equals("TICKET")
								|| file.getFilename().toUpperCase().equals("TICKETS")) {
							ret = ret + "{ \"id\" :\"" + file.getFilename() + "\"";
							ret = ret + " , \"text\" : \"" + file.getFilename() + "\"";
							if (file.getAttrs().isDir()) {
								ret = ret + ",\"icon\":\"resources/img/carpeta.png\"";
								ret = ret + ",\"children\":"
										+ nodosJsTreeTicket(
												sftp, new StringBuilder(String.valueOf(directorio))
														.append(file.getFilename()).append("/").toString(),
												nivel, ope, false, false);
								raiz = false;
							}
							ret = ret + "}";
						}
					}

				} else {
					if (file.getAttrs().isDir()) {
						ret = ret + "{ \"id\" :\"" + file.getFilename() + "\"";
						ret = ret + " , \"text\" : \"" + file.getFilename() + "\"";
						ret = ret + ",\"icon\":\"resources/img/carpeta.png\"";
						ret = ret + ",\"children\":"
								+ nodosJsTreeTicket(
										sftp, new StringBuilder(String.valueOf(directorio))
												.append(file.getFilename()).append("/").toString(),
										nivel, ope, oper, tick);
						if (i == files.size() - 1) {
							ret = ret + " } ";
						} else {
							ret = ret + "},";
						}
					} else {
						ret = ret + "{ \"id\" :\"" + file.getFilename() + "\"";
						ret = ret + " , \"text\" : \"" + file.getFilename() + "\"";
						if(file.getFilename().trim().toUpperCase().lastIndexOf(".XLS")>0){
							ret = ret + ",\"icon\":\"resources/img/excel.gif\"";
						}else if(file.getFilename().trim().toUpperCase().lastIndexOf(".TXT")>0){
							ret = ret + ",\"icon\":\"resources/img/txt.png\"";
						}

						if (i == files.size() - 1) {
							ret = ret + " } ";
						} else {
							ret = ret + "},";
						}
					}

				}
			}
			ret = ret + "]";
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	protected Vector getOdernarFile(Vector files, int ini, int fin) {
		Comparator comparador = Collections.reverseOrder();
		Collections.sort(files, comparador);
		return files;
	}

	public String downloadFile(ChannelSftp channel, String archivo, String ruta, String local) {
		String ret = "";
		String remot = ruta + archivo;
		try {
			channel.get(remot, local);
			archivo = archivo.substring(archivo.lastIndexOf("/")+1,archivo.length());
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			System.out.println("Error  download " + e.getMessage());
			e.printStackTrace();
		}
		return (local + archivo);
	}

}
