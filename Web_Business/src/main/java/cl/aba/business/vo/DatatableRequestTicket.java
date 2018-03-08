package cl.aba.business.vo;

public class DatatableRequestTicket implements java.io.Serializable {
	
	private static final long serialVersionUID = 6346678866012956158L;
	private FiltroTicket filtro;
	private DatatableOptions opciones;
	
	public DatatableRequestTicket() {
		super();
	}

	public DatatableRequestTicket(FiltroTicket filtro, DatatableOptions opciones) {
		super();
		this.filtro = filtro;
		this.opciones = opciones;
	}

	public FiltroTicket getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroTicket filtro) {
		this.filtro = filtro;
	}

	public DatatableOptions getOpciones() {
		return opciones;
	}

	public void setOpciones(DatatableOptions opciones) {
		this.opciones = opciones;
	}

}
