package cl.aba.business.vo;

public class Columnas implements java.io.Serializable {

	private static final long serialVersionUID = 7876453669970107073L;
	private Integer id;
	private String label;
	private String type;
	
	public Columnas() {
		super();
	}

	public Columnas(Integer id, String label, String type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
