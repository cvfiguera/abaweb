package cl.aba.business.vo;

import java.math.BigDecimal;
import java.util.Date;

import cl.aba.validar.ValorDouble;
import cl.aba.validar.ValorFecha;

public class FASVo implements java.io.Serializable {
	
	private static final long serialVersionUID = -3144447197286861734L;
	private Integer concursoId;
	private Integer rbdId;
	private Integer rbd;
	private String anexo;
	private String concurso;
	private String nombreEES;
	private String estadoConectado;
	private String tecnologia;
	private String operadora;
	private String numFAS;
	private String url;
	private String velocidadBajada;
	private String velocidadSubida;
	private String fechaFAS;
	
	public FASVo() {
		super();
	}

	public FASVo(Integer concursoId, Integer rbdId, Integer rbd, String anexo, String concurso, String nombreEES,
			String estadoConectado, String tecnologia, String operadora, String numFAS, String url,
			BigDecimal velocidadBajada, BigDecimal velocidadSubida, Date fechaFAS) {
		super();
		this.concursoId = concursoId;
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.anexo = anexo;
		this.concurso = concurso;
		this.nombreEES = nombreEES;
		this.estadoConectado = estadoConectado;
		this.tecnologia = tecnologia;
		this.operadora = operadora;
		this.numFAS = numFAS;
		this.url = url;
		ValorDouble vd = new ValorDouble(velocidadBajada,"###,###.###");
		this.velocidadBajada = vd.getValorDecimal();
		vd = new ValorDouble(velocidadSubida,"###,###.###");
		this.velocidadSubida = vd.getValorDecimal();
		ValorFecha vf = new ValorFecha(fechaFAS,"yyyy-MM-dd");
		this.fechaFAS = vf.getFechaString();
	}

	public Integer getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(Integer concursoId) {
		this.concursoId = concursoId;
	}

	public Integer getRbdId() {
		return rbdId;
	}

	public void setRbdId(Integer rbdId) {
		this.rbdId = rbdId;
	}

	public Integer getRbd() {
		return rbd;
	}

	public void setRbd(Integer rbd) {
		this.rbd = rbd;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getNombreEES() {
		return nombreEES;
	}

	public void setNombreEES(String nombreEES) {
		this.nombreEES = nombreEES;
	}

	public String getEstadoConectado() {
		return estadoConectado;
	}

	public void setEstadoConectado(String estadoConectado) {
		this.estadoConectado = estadoConectado;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getNumFAS() {
		return numFAS;
	}

	public void setNumFAS(String numFAS) {
		this.numFAS = numFAS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(String velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	public String getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(String velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public String getFechaFAS() {
		return fechaFAS;
	}

	public void setFechaFAS(String fechaFAS) {
		this.fechaFAS = fechaFAS;
	}
}
