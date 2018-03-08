package cl.aba.business.vo;

public class DatatableRequest implements java.io.Serializable {
	
	private static final long serialVersionUID = 6346678866012956158L;
	private Filtro filtro;
	private DatatableOptions opciones;
	
	public DatatableRequest() {
		super();
	}

	public DatatableRequest(Filtro filtro, DatatableOptions opciones) {
		super();
		this.filtro = filtro;
		this.opciones = opciones;
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public DatatableOptions getOpciones() {
		return opciones;
	}

	public void setOpciones(DatatableOptions opciones) {
		this.opciones = opciones;
	}

}
