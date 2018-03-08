package cl.aba.model.web.vo;

public class Parametro {

	private String nombre;
	private Object valor;
	
	public Parametro() {
		super();
	}

	public Parametro(String nombre, Object valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
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
