package cl.aba.model.web.common;

import java.math.BigDecimal;
import java.util.Date;

public class FASView implements java.io.Serializable {

	private static final long serialVersionUID = -8073151315180564943L;
	private int rbdId;
	private Integer concursoId;
	private String nombreConcurso;
	private Integer rbd;
	private String anexo;
	private String nombreEES;
	private String url;
	private BigDecimal velocidadBajada;
	private BigDecimal velocidadSubida;
	private Date fechaFAS;
	private String numFAS;
	private Integer tecnologiaId;
	private String tecnologia;
	private Integer operadoraId;
	private String operadora;
	private Integer conectadoEstadoId;
	private String estadoConectado;
	
	public FASView() {
		super();
	}

	public FASView(int rbdId, Integer concursoId, String nombreConcurso, Integer rbd, String anexo, String nombreEES,
			String url, BigDecimal velocidadBajada, BigDecimal velocidadSubida, Date fechaFAS, String numFAS,
			Integer tecnologiaId, String tecnologia, Integer operadoraId, String operadora, Integer conectadoEstadoId,
			String estadoConectado) {
		super();
		this.rbdId = rbdId;
		this.concursoId = concursoId;
		this.nombreConcurso = nombreConcurso;
		this.rbd = rbd;
		this.anexo = anexo;
		this.nombreEES = nombreEES;
		this.url = url;
		this.velocidadBajada = velocidadBajada;
		this.velocidadSubida = velocidadSubida;
		this.fechaFAS = fechaFAS;
		this.numFAS = numFAS;
		this.tecnologiaId = tecnologiaId;
		this.tecnologia = tecnologia;
		this.operadoraId = operadoraId;
		this.operadora = operadora;
		this.conectadoEstadoId = conectadoEstadoId;
		this.estadoConectado = estadoConectado;
	}

	public int getRbdId() {
		return rbdId;
	}

	public void setRbdId(int rbdId) {
		this.rbdId = rbdId;
	}

	public Integer getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(Integer concursoId) {
		this.concursoId = concursoId;
	}

	public String getNombreConcurso() {
		return nombreConcurso;
	}

	public void setNombreConcurso(String nombreConcurso) {
		this.nombreConcurso = nombreConcurso;
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

	public String getNombreEES() {
		return nombreEES;
	}

	public void setNombreEES(String nombreEES) {
		this.nombreEES = nombreEES;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(BigDecimal velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	public BigDecimal getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(BigDecimal velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public Date getFechaFAS() {
		return fechaFAS;
	}

	public void setFechaFAS(Date fechaFAS) {
		this.fechaFAS = fechaFAS;
	}

	public String getNumFAS() {
		return numFAS;
	}

	public void setNumFAS(String numFAS) {
		this.numFAS = numFAS;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Integer getConectadoEstadoId() {
		return conectadoEstadoId;
	}

	public void setConectadoEstadoId(Integer conectadoEstadoId) {
		this.conectadoEstadoId = conectadoEstadoId;
	}

	public String getEstadoConectado() {
		return estadoConectado;
	}

	public void setEstadoConectado(String estadoConectado) {
		this.estadoConectado = estadoConectado;
	}
}
