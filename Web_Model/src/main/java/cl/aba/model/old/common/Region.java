package cl.aba.model.old.common;

public class Region implements java.io.Serializable {

	private static final long serialVersionUID = 1751308077762622663L;
	private int id;
	private String nombre;
	private Integer codigo;
	
	public Region() {
		super();
	}

	public Region(int id, String nombre, Integer codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
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

}
