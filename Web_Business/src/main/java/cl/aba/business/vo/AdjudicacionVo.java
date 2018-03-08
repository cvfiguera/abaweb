package cl.aba.business.vo;

import java.math.BigDecimal;
import java.util.Date;

import cl.aba.validar.ValorDouble;
import cl.aba.validar.ValorFecha;

public class AdjudicacionVo implements java.io.Serializable {

	private static final long serialVersionUID = 5613678398405584074L;
	private Integer adjudicacionId;
	private Long rbd;
	private String concurso;
	private String tipo;
	private String estado;
	private String operadora;
	private String tecnologia;
	private String velocidadBajada;
	private String velocidadSubida;
	private String precioMensual;
	private String fechaAdjudicacion;
	
	public AdjudicacionVo() {
		super();
	}

	public AdjudicacionVo(Integer adjudicacionId, Long rbd, String concurso, String tipo, String estado,
			String operadora, String tecnologia, BigDecimal velocidadBajada, BigDecimal velocidadSubida,
			BigDecimal precioMensual, Date fechaAdjudicacion) {
		super();
		this.adjudicacionId = adjudicacionId;
		this.rbd = rbd;
		this.concurso = concurso;
		this.tipo = tipo;
		this.estado = estado;
		this.operadora = operadora;
		this.tecnologia = tecnologia;
		ValorDouble val = new ValorDouble(velocidadBajada,"###,###.###");
		this.velocidadBajada = val.getValorDecimal();
		
		val = new ValorDouble(velocidadSubida,"###,###.###");
		this.velocidadSubida = val.getValorDecimal();
		
		val = new ValorDouble(precioMensual,"$ ###,###.###");
		this.precioMensual = val.getValorDecimal();
		
		if(fechaAdjudicacion != null){
			ValorFecha vf = new ValorFecha(fechaAdjudicacion, "yyyy-MM-dd");
			this.fechaAdjudicacion = vf.getFechaString();
		}else {
			this.fechaAdjudicacion = "";
		}
		
	}

	public Integer getAdjudicacionId() {
		return adjudicacionId;
	}

	public void setAdjudicacionId(Integer adjudicacionId) {
		this.adjudicacionId = adjudicacionId;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getFechaAdjudicacion() {
		return fechaAdjudicacion;
	}

	public void setFechaAdjudicacion(String fechaAdjudicacion) {
		this.fechaAdjudicacion = fechaAdjudicacion;
	}
}
