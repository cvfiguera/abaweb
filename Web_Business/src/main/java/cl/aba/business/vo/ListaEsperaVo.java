package cl.aba.business.vo;

import java.math.BigDecimal;

public class ListaEsperaVo implements java.io.Serializable {

	private static final long serialVersionUID = 5780254477437357063L;
	private Integer listaEsperaId;
	private Long rbd;
	private String concurso;
	private String tipoLista;
	private String tecnologia;
	private String operadora;
	private BigDecimal velocidadBajada;
	private BigDecimal velocidadSubida;
	private BigDecimal precioMensual;
	
	public ListaEsperaVo() {
		super();
	}

	public ListaEsperaVo(Integer listaEsperaId, Long rbd, String concurso, String tipoLista, String tecnologia,
			String operadora, BigDecimal velocidadBajada, BigDecimal velocidadSubida, BigDecimal precioMensual) {
		super();
		this.listaEsperaId = listaEsperaId;
		this.rbd = rbd;
		this.concurso = concurso;
		this.tipoLista = tipoLista;
		this.tecnologia = tecnologia;
		this.operadora = operadora;
		this.velocidadBajada = velocidadBajada;
		this.velocidadSubida = velocidadSubida;
		this.precioMensual = precioMensual;
	}

	public Integer getListaEsperaId() {
		return listaEsperaId;
	}

	public void setListaEsperaId(Integer listaEsperaId) {
		this.listaEsperaId = listaEsperaId;
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

	public String getTipoLista() {
		return tipoLista;
	}

	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
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

	public BigDecimal getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(BigDecimal precioMensual) {
		this.precioMensual = precioMensual;
	}
}
