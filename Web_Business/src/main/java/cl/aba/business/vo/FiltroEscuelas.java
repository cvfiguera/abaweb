package cl.aba.business.vo;

import java.util.List;

public class FiltroEscuelas implements java.io.Serializable {
	
	private static final long serialVersionUID = 8782041988456943590L;
	private Integer concurso;
	private Integer operadora;
	private Integer estado;
	private Integer subestado;
	private Integer instalacion;
	private Integer mineduc;
	private Integer tecnologia;
	private Integer region;
	private Integer comuna;
	private List<Integer> rbds;
	
	public FiltroEscuelas() {
		super();
	}

	public FiltroEscuelas(Integer concurso, Integer operadora, Integer estado, Integer subestado, Integer instalacion,
			Integer mineduc, Integer tecnologia, Integer region, Integer comuna, List<Integer> rbds) {
		super();
		this.concurso = concurso;
		this.operadora = operadora;
		this.estado = estado;
		this.subestado = subestado;
		this.instalacion = instalacion;
		this.mineduc = mineduc;
		this.tecnologia = tecnologia;
		this.region = region;
		this.comuna = comuna;
		this.rbds = rbds;
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

	public List<Integer> getRbds() {
		return rbds;
	}

	public void setRbds(List<Integer> rbds) {
		this.rbds = rbds;
	}
}
