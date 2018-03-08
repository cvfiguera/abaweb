package cl.aba.model.web.vo;

public class GraficoVo implements java.io.Serializable {

	private static final long serialVersionUID = -4974501975900620709L;
	private Integer id;
	private String nombre;
	private Object valor;
	
	public GraficoVo() {
		super();
	}

	public GraficoVo(Integer id, String nombre, Object valor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
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

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}
}
