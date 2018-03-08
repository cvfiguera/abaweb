package cl.aba.model.web.vo;

public class FiltroVo implements java.io.Serializable {

	private static final long serialVersionUID = 6527708716016684627L;
	private Integer id;
	private String nombre;
	
	public FiltroVo() {
		super();
	}

	public FiltroVo(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
