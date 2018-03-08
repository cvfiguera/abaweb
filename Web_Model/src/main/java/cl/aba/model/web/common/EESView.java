package cl.aba.model.web.common;

public class EESView implements java.io.Serializable {

	private static final long serialVersionUID = -4808535074646668696L;
	private int rbdId;
	private Integer concursoId;
	private String concurso;
	private Long rbd;
	private String nombreEES;
	private String direccion;
	private Long matricula;
	private Integer comunaId;
	private String comuna;
	private Integer regionId;
	private String region;
	private Integer estadoAdjudicadoId;
	private Integer subEstadoAdjudicadoId;
	private String subEstadoAdjudicado;
	private Integer estadoConectadoId;
	private String estadoConectado;
	private Integer estadoMineducId;
	private String estadoMineduc;
	
	public EESView() {
		super();
	}

	public EESView(int rbdId, Integer concursoId, String concurso, Long rbd, String nombreEES, String direccion,
			Long matricula, Integer comunaId, String comuna, Integer regionId, String region,
			Integer estadoAdjudicadoId, Integer subEstadoAdjudicadoId, String subEstadoAdjudicado,
			Integer estadoConectadoId, String estadoConectado, Integer estadoMineducId, String estadoMineduc) {
		super();
		this.rbdId = rbdId;
		this.concursoId = concursoId;
		this.concurso = concurso;
		this.rbd = rbd;
		this.nombreEES = nombreEES;
		this.direccion = direccion;
		this.matricula = matricula;
		this.comunaId = comunaId;
		this.comuna = comuna;
		this.regionId = regionId;
		this.region = region;
		this.estadoAdjudicadoId = estadoAdjudicadoId;
		this.subEstadoAdjudicadoId = subEstadoAdjudicadoId;
		this.subEstadoAdjudicado = subEstadoAdjudicado;
		this.estadoConectadoId = estadoConectadoId;
		this.estadoConectado = estadoConectado;
		this.estadoMineducId = estadoMineducId;
		this.estadoMineduc = estadoMineduc;
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

	public String getNombreEES() {
		return nombreEES;
	}

	public void setNombreEES(String nombreEES) {
		this.nombreEES = nombreEES;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Integer getComunaId() {
		return comunaId;
	}

	public void setComunaId(Integer comunaId) {
		this.comunaId = comunaId;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
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

	public Integer getEstadoAdjudicadoId() {
		return estadoAdjudicadoId;
	}

	public void setEstadoAdjudicadoId(Integer estadoAdjudicadoId) {
		this.estadoAdjudicadoId = estadoAdjudicadoId;
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

}
