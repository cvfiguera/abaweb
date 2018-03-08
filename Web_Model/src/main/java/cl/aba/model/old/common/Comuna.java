package cl.aba.model.old.common;

public class Comuna implements java.io.Serializable {

	private static final long serialVersionUID = 1984384627804616183L;
	private int id;
	private String nombre;
	private Integer codigo;
	private Integer region;
	
	public Comuna() {
		super();
	}

	public Comuna(int id, String nombre, Integer codigo, Integer region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.region = region;
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}
}
