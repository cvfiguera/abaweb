package cl.aba.business.vo;

public class EstadoSinIdVo implements java.io.Serializable {

	private static final long serialVersionUID = 7626024872281858545L;
	private String nombre;
	
	public EstadoSinIdVo() {
		super();
	}

	public EstadoSinIdVo(String nombre) {
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
