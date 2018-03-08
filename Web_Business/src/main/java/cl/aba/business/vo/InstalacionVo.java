package cl.aba.business.vo;

import java.math.BigDecimal;
import java.util.Date;

import cl.aba.validar.ValorDouble;
import cl.aba.validar.ValorFecha;

public class InstalacionVo implements java.io.Serializable {
	
	private static final long serialVersionUID = -2994606788665517440L;
	private Integer instalacionId;
	private Long rbd;
	private String concurso;
	private String operadora;
	private String tecnologia;
	private String fechaFas;
	private String velocidadBajada;
	private String velocidadSubida;
	private String precioMensual;
	private String fas;
	private String url;
	private String estado;
	
	public InstalacionVo() {
		super();
	}

	public InstalacionVo(Integer instalacionId, Long rbd, String concurso, String operadora, String tecnologia,
			Date fechaFas, BigDecimal velocidadBajada, BigDecimal velocidadSubida, BigDecimal precioMensual, String fas,
			String url, String estado) {
		super();
		this.instalacionId = instalacionId;
		this.rbd = rbd;
		this.concurso = concurso;
		this.operadora = operadora;
		this.tecnologia = tecnologia;
		ValorFecha vf = null;
		if(fechaFas != null){
			vf = new ValorFecha(fechaFas, "yyyy-MM-dd");
			this.fechaFas = vf.getFechaString();
		}else{
			this.fechaFas = "";
		}
		
		ValorDouble val =new ValorDouble(velocidadBajada,"###,###.###");
		this.velocidadBajada = val.getValorDecimal();
		
		val = new ValorDouble(velocidadSubida,"###,###.###");
		this.velocidadSubida = val.getValorDecimal();
		
		val = new ValorDouble(precioMensual,"$ ###,###.###");
		this.precioMensual = val.getValorDecimal();
		this.fas = fas;
		this.url = url;
		this.estado = estado;
	}

	public Integer getInstalacionId() {
		return instalacionId;
	}

	public void setInstalacionId(Integer instalacionId) {
		this.instalacionId = instalacionId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getFechaFas() {
		return fechaFas;
	}

	public void setFechaFas(String fechaFas) {
		this.fechaFas = fechaFas;
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

	public String getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(String precioMensual) {
		this.precioMensual = precioMensual;
	}

	public String getFas() {
		return fas;
	}

	public void setFas(String fas) {
		this.fas = fas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
