package cl.aba.business.vo;

public class EESVo implements java.io.Serializable {

	private static final long serialVersionUID = -5984701346925644485L;
	private Integer concursoId;
	private Integer rbdId;
	private Long rbd;
	private String concurso;
	private String nombreEES;
	private Long matricula;
	private String direccion;
	private String comuna;
	private String region;
	private String estadoAdjudicado;
	private String estadoConectado;
	private String estadoMineduc;
	
	public EESVo() {
		super();
	}

	public EESVo(Integer concursoId, Integer rbdId, Long rbd, String concurso, String nombreEES, Long matricula,
			String direccion, String comuna, String region, String estadoAdjudicado, String estadoConectado,
			String estadoMineduc) {
		super();
		this.concursoId = concursoId;
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.concurso = concurso;
		this.nombreEES = nombreEES;
		this.matricula = matricula;
		this.direccion = direccion;
		this.comuna = comuna;
		this.region = region;
		this.estadoAdjudicado = estadoAdjudicado;
		this.estadoConectado = estadoConectado;
		this.estadoMineduc = estadoMineduc;
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

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String nombreConcurso) {
		this.concurso = nombreConcurso;
	}

	public String getNombreEES() {
		return nombreEES;
	}

	public void setNombreEES(String nombreEES) {
		this.nombreEES = nombreEES;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getEstadoAdjudicado() {
		return estadoAdjudicado;
	}

	public void setEstadoAdjudicado(String estadoAdjudicado) {
		this.estadoAdjudicado = estadoAdjudicado;
	}

	public String getEstadoConectado() {
		return estadoConectado;
	}

	public void setEstadoConectado(String estadoConectado) {
		this.estadoConectado = estadoConectado;
	}

	public String getEstadoMineduc() {
		return estadoMineduc;
	}

	public void setEstadoMineduc(String estadoMineduc) {
		this.estadoMineduc = estadoMineduc;
	}
}
