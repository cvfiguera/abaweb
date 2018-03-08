package cl.aba.business.vo;

public class FiltroEES implements java.io.Serializable {

	private static final long serialVersionUID = -84282634418069910L;
	private Integer concurso;
	private Integer rbd;
	private String nombre;
	private Integer region;
	private Integer comuna;
	private Integer estado;
	private Integer subestado;
	
	public FiltroEES() {
		super();
	}

	public FiltroEES(Integer concurso, Integer rbd, String nombre, Integer region, Integer comuna, Integer estado,
			Integer subestado) {
		super();
		this.concurso = concurso;
		this.rbd = rbd;
		this.nombre = nombre;
		this.region = region;
		this.comuna = comuna;
		this.estado = estado;
		this.subestado = subestado;
	}

	public Integer getConcurso() {
		return concurso;
	}

	public void setConcurso(Integer concurso) {
		this.concurso = concurso;
	}

	public Integer getRbd() {
		return rbd;
	}

	public void setRbd(Integer rbd) {
		this.rbd = rbd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
}
