package cl.aba.model.web.common;

public class GraficosView implements java.io.Serializable {

	private static final long serialVersionUID = -3571062865929687440L;
	private int rbdId;
	private Integer concursoId;
	private String concurso;
	private Long rbd;
	private Integer estadoAdjudicadoId;
	private String estadoAdjudicado;
	private Integer subEstadoAdjudicadoId;
	private String subEstadoAdjudicado;
	private Integer estadoMineducId;
	private String estadoMineduc;
	private Integer estadoConectadoId;
	private String estadoConectado;
	private Integer operadoraId;
	private String operadora;
	private Integer tecnologiaId;
	private String tecnologia;
	private Integer regionId;
	private String region;
	
	public GraficosView() {
		super();
	}

	public GraficosView(int rbdId, Integer concursoId, String concurso, Long rbd, Integer estadoAdjudicadoId,
			String estadoAdjudicado, Integer subEstadoAdjudicadoId, String subEstadoAdjudicado, Integer estadoMineducId,
			String estadoMineduc, Integer estadoConectadoId, String estadoConectado, Integer operadoraId,
			String operadora, Integer tecnologiaId, String tecnologia, Integer regionId, String region) {
		super();
		this.rbdId = rbdId;
		this.concursoId = concursoId;
		this.concurso = concurso;
		this.rbd = rbd;
		this.estadoAdjudicadoId = estadoAdjudicadoId;
		this.estadoAdjudicado = estadoAdjudicado;
		this.subEstadoAdjudicadoId = subEstadoAdjudicadoId;
		this.subEstadoAdjudicado = subEstadoAdjudicado;
		this.estadoMineducId = estadoMineducId;
		this.estadoMineduc = estadoMineduc;
		this.estadoConectadoId = estadoConectadoId;
		this.estadoConectado = estadoConectado;
		this.operadoraId = operadoraId;
		this.operadora = operadora;
		this.tecnologiaId = tecnologiaId;
		this.tecnologia = tecnologia;
		this.regionId = regionId;
		this.region = region;
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

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public Integer getEstadoAdjudicadoId() {
		return estadoAdjudicadoId;
	}

	public void setEstadoAdjudicadoId(Integer estadoAdjudicadoId) {
		this.estadoAdjudicadoId = estadoAdjudicadoId;
	}

	public String getEstadoAdjudicado() {
		return estadoAdjudicado;
	}

	public void setEstadoAdjudicado(String estadoAdjudicado) {
		this.estadoAdjudicado = estadoAdjudicado;
	}

	public Integer getSubEstadoAdjudicadoId() {
		return subEstadoAdjudicadoId;
	}

	public void setSubEstadoAdjudicadoId(Integer subEstadoAdjudicadoId) {
		this.subEstadoAdjudicadoId = subEstadoAdjudicadoId;
	}

	public String getSubEstadoAdjudicado() {
		return subEstadoAdjudicado;
	}

	public void setSubEstadoAdjudicado(String subEstadoAdjudicado) {
		this.subEstadoAdjudicado = subEstadoAdjudicado;
	}

	public Integer getEstadoMineducId() {
		return estadoMineducId;
	}

	public void setEstadoMineducId(Integer estadoMineducId) {
		this.estadoMineducId = estadoMineducId;
	}

	public String getEstadoMineduc() {
		return estadoMineduc;
	}

	public void setEstadoMineduc(String estadoMineduc) {
		this.estadoMineduc = estadoMineduc;
	}

	public Integer getEstadoConectadoId() {
		return estadoConectadoId;
	}

	public void setEstadoConectadoId(Integer estadoConectadoId) {
		this.estadoConectadoId = estadoConectadoId;
	}

	public String getEstadoConectado() {
		return estadoConectado;
	}

	public void setEstadoConectado(String estadoConectado) {
		this.estadoConectado = estadoConectado;
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

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
