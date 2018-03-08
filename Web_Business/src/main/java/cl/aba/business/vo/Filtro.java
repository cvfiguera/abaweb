package cl.aba.business.vo;

import java.util.List;

public class Filtro implements java.io.Serializable {
	
	private static final long serialVersionUID = 8782041988456943590L;
	private String fechaIni;
	private String fechaFin;
	private String categoria;
	private String tipo;
	private String estadoTicket;
	private Integer concurso;
	private Integer operadora;
	private Integer estado;
	private Integer subestado;
	private Integer instalacion;
	private Integer mineduc;
	private Integer tecnologia;
	private Integer region;
	private Integer comuna;
	private Long rbd;
	private String nombre;
	private List<Integer> rbds;
	
	public Filtro() {
		super();
	}
	public Filtro(String fechaIni, String fechaFin, String categoria, String tipo, String estadoTicket,
			Integer concurso, Integer operadora, Integer estado, Integer subestado, Integer instalacion,
			Integer mineduc, Integer tecnologia, Integer region, Integer comuna, Long rbd, String nombre,
			List<Integer> rbds) {
		super();
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.categoria = categoria;
		this.tipo = tipo;
		this.estadoTicket = estadoTicket;
		this.concurso = concurso;
		this.operadora = operadora;
		this.estado = estado;
		this.subestado = subestado;
		this.instalacion = instalacion;
		this.mineduc = mineduc;
		this.tecnologia = tecnologia;
		this.region = region;
		this.comuna = comuna;
		this.rbd = rbd;
		this.nombre = nombre;
		this.rbds = rbds;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
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
	public Integer getConcurso() {
		return concurso;
	}
	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}
	public Integer getOperadora() {
		return operadora;
	}
	public void setOperadora(Integer operadora) {
		this.operadora = operadora;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getSubestado() {
		return subestado;
	}
	public void setSubestado(Integer subestado) {
		this.subestado = subestado;
	}
	public Integer getInstalacion() {
		return instalacion;
	}
	public void setInstalacion(Integer instalacion) {
		this.instalacion = instalacion;
	}
	public Integer getMineduc() {
		return mineduc;
	}
	public void setMineduc(Integer mineduc) {
		this.mineduc = mineduc;
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
	public Long getRbd() {
		return rbd;
	}
	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Integer> getRbds() {
		return rbds;
	}
	public void setRbds(List<Integer> rbds) {
		this.rbds = rbds;
	}

}
