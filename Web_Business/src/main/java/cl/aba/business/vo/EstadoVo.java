package cl.aba.business.vo;

public class EstadoVo implements java.io.Serializable {
	
	private static final long serialVersionUID = 6119719061957700857L;
	private int id;
	private String nombre;
	
	public EstadoVo() {
		super();
	}

	public EstadoVo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
