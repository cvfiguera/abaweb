package cl.aba.business.vo;

import java.util.Date;
import java.util.List;

public class FiltroTicket implements java.io.Serializable {

	private static final long serialVersionUID = -6133544780011591597L;
	private Date fechaIni;
	private Date fechaFin;
	private String categoria;
	private String tipo;
	private String estadoTicket;
	private Integer operadora;
	private Integer tecnologia;
	private Integer region;
	private Integer comuna;
	private List<Long> rbds;
	
	public FiltroTicket() {
		super();
	}

	public FiltroTicket(Date fechaIni, Date fechaFin, String categoria, String tipo, String estadoTicket,
			Integer operadora, Integer tecnologia, Integer region, Integer comuna, List<Long> rbds) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.categoria = categoria;
		this.tipo = tipo;
		this.estadoTicket = estadoTicket;
		this.operadora = operadora;
		this.tecnologia = tecnologia;
		this.region = region;
		this.comuna = comuna;
		this.rbds = rbds;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstadoTicket() {
		return estadoTicket;
	}

	public void setEstadoTicket(String estadoTicket) {
		this.estadoTicket = estadoTicket;
	}

	public Integer getOperadora() {
		return operadora;
	}

	public void setOperadora(Integer operadora) {
		this.operadora = operadora;
	}

	public Integer getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Integer tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public Integer getComuna() {
		return comuna;
	}

	public void setComuna(Integer comuna) {
		this.comuna = comuna;
	}

	public List<Long> getRbds() {
		return rbds;
	}

	public void setRbds(List<Long> rbds) {
		this.rbds = rbds;
	}
	
}
