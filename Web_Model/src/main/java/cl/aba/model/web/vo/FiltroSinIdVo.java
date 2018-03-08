package cl.aba.model.web.vo;

public class FiltroSinIdVo implements java.io.Serializable {

	private static final long serialVersionUID = -8808590282549914619L;
	private String nombre;
	
	public FiltroSinIdVo() {
		super();
	}

	public FiltroSinIdVo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
